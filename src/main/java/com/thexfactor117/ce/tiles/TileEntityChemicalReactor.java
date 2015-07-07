package com.thexfactor117.ce.tiles;

import com.thexfactor117.ce.helpers.EnergyHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;

public class TileEntityChemicalReactor extends TileEntity implements IEnergyProvider, IInventory
{
	/** Array holds the current ItemStack in slots */
	private ItemStack[] items = new ItemStack[1];
	private EnergyStorage storage = new EnergyStorage(20000);
	private int currentEnergy;
	private int oldEnergy;
	private int reactTime = 20*10;
	private boolean isActive = false;
	
	/**
	 * Called every tick. Generate power, and transfer the power.
	 */
	@Override
	public void updateEntity()
	{
		super.updateEntity();
				
		if (!worldObj.isRemote)
		{
			generateEnergy();
			
			if (reactTime > 0)
			{
				reactTime--;
			}
			
			if (reactTime == 0)
			{
				decrStackSize(0, 1);
				reactTime = 20*10;
			}
			
			if (storage.getEnergyStored() > 0)
			{
				transferEnergy();
			}
		}
	}
	
	/**
	 * Returns the amount of power to be generated depending on
	 * the ItemStack in the slot.
	 */
	public int getEnergyValue()
	{
		int energyGen = 0;
		ItemStack stack = getStackInSlot(0);		
		energyGen = EnergyHelper.capsuleEnergyGen(stack);
		
		return energyGen;
	}
	
	public void canGenerate()
	{
		if (!isActive)
		{
			ItemStack stack = getStackInSlot(0);
			
			if (stack != null)
			{
				isActive = true;
			}
		}
	}
	
	/**
	 * Generate energy.
	 */
	public void generateEnergy()
	{
		if (isActive)
		{
			currentEnergy = getEnergyValue();
			
			if (currentEnergy != oldEnergy)
			{
				oldEnergy = currentEnergy;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				markDirty();
			}
			
			storage.modifyEnergyStored(currentEnergy);
		}
	}
	
	/**
	 * Transfer energy.
	 */
	public void transferEnergy()
	{
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) 
		{
            TileEntity tile = getWorldObj().getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
            
            if(tile instanceof IEnergyReceiver) 
            {
                IEnergyReceiver receiver = (IEnergyReceiver)tile;
                extractEnergy(direction.getOpposite(), receiver.receiveEnergy(direction.getOpposite(), storage.getMaxExtract(), false), false);
            }
        }
	}
	
	/*
	 * ISidedInventory Interface (minus the NBT methods).
	 */
	@Override
	public int getSizeInventory() 
	{
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return items[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if (items[index] != null)
        {
            ItemStack itemstack;

            if (items[index].stackSize <= count)
            {
                itemstack = items[index];
                items[index] = null;
                
                return itemstack;
            }
            else
            {
                itemstack = items[index].splitStack(count);

                if (items[index].stackSize == 0)
                {
                	items[index] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	/**
	 * Called to drop items as EntityItem's when closed.
	 * Example would be a Crafting Table.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int index) 
	{
		if (items[index] != null)
		{
			ItemStack stack = items[index];
			items[index] = null;
			
			return stack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		items[index] = stack;
		
		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
				stack.stackSize = getInventoryStackLimit();
		}
	 
		markDirty();
	}

	@Override
	public String getInventoryName() 
	{
		return "container.chemicalReactor";
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		items = new ItemStack[getSizeInventory()];
	 
		for (int i = 0; i < list.tagCount(); ++i) 
		{ 
			NBTTagCompound comp = list.getCompoundTagAt(i); 
			int j = comp.getByte("Slot") & 255;
			
			if (j >= 0 && j < items.length)
			{
				items[j] = ItemStack.loadItemStackFromNBT(comp);
			}
		} 
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
	 
		for (int i = 0; i < items.length; ++i)
		{
			if (items[i] != null)
			{
				NBTTagCompound comp = new NBTTagCompound();
				comp.setByte("Slot", (byte) i);
				items[i].writeToNBT(comp);
				list.appendTag(comp);
			}
		}
		
		nbt.setTag("Items", list);
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() 
	{
		
	}

	@Override
	public void closeInventory()
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return false;
	}

	/*
	 * IEnergyProvider Interface
	 */
	@Override
	public boolean canConnectEnergy(ForgeDirection from) 
	{
		return true;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) 
	{
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) 
	{
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) 
	{
		return storage.getMaxEnergyStored();
	}
}
