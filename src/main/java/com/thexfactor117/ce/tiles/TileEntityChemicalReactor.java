package com.thexfactor117.ce.tiles;

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
import cofh.api.energy.IEnergyStorage;

import com.thexfactor117.ce.helpers.EnergyHelper;
import com.thexfactor117.ce.helpers.LogHelper;

public class TileEntityChemicalReactor extends TileEntity implements IEnergyProvider, IInventory
{
	/** Array holds the current ItemStack in slots */
	private ItemStack[] items = new ItemStack[1];
	public EnergyStorage storage = new EnergyStorage(20000, 64);
	public boolean isActive = false;
	public int process = 0;
	public int processMax = 20*8;
	
	/**
	 * Called every tick. Generate and transfer energy if possible.
	 */
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		LogHelper.info("Energy Stored: " + storage.getEnergyStored());
		
		if (!worldObj.isRemote)
		{
			if (items[0] != null && process < processMax && canGenerate())
			{
				process++;
				generate();
				
				if (process == processMax)
				{
					this.decrStackSize(0, 1);
					process = 0;
				}
			}
			
			if (storage.getEnergyStored() > 0)
			{
				transfer();
			}
		}
	}
	
	/**
	 * Gets the item's energy value in the slot.
	 * @param stack
	 * @return energy value
	 */
	public static int getEnergyValue(ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		
		return EnergyHelper.capsuleEnergyGen(stack);
	}
	
	/**
	 * Returns true if the machine can generate RF.
	 */
	public boolean canGenerate()
	{
		return getEnergyValue(this.items[0]) > 0;
	}
	
	/**
	 * Generate Energy.
	 */
	public void generate()
	{
		int energy = getEnergyValue(items[0]);
		
		if (energy > 0)
		{
			this.isActive = true;
			storage.modifyEnergyStored(energy);
			markDirty();
		}
		else
		{
			this.isActive = false;
		}
	}
	
	/**
	 * Transfer Energy.
	 */
	public void transfer()
	{			
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) 
		{
            TileEntity tile = getWorldObj().getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
            
            if (tile instanceof IEnergyReceiver) 
            {
                IEnergyReceiver receiver = (IEnergyReceiver)tile;
                
        		this.storage.modifyEnergyStored(-receiver.receiveEnergy(direction.getOpposite(), Math.min(this.storage.getMaxExtract(), this.storage.getEnergyStored()), false));
            }
        }
	}
	
	public IEnergyStorage getEnergyStored()
	{
		return this.storage;
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
		
		this.storage.readFromNBT(nbt);
		
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
		
		this.storage.writeToNBT(nbt);
		
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
