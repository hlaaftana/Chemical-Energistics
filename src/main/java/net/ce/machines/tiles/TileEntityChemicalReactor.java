package net.ce.machines.tiles;

import net.ce.helpers.EnergyHelper;
import net.ce.helpers.LogHelper;
import net.ce.init.CEItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import cofh.api.energy.EnergyStorage;

public class TileEntityChemicalReactor extends TileEntity implements IInventory
{
	/** Array holds the current ItemStack in slots */
	private ItemStack[] chemicalReactorItemStacks = new ItemStack[1];
	private EnergyStorage storage;
	private int energyGen;
	private int energyTransfer;
	private int energyCapacity;
	private int currentEnergy;
	
	public TileEntityChemicalReactor(int energyGen, int energyTransfer, int energyCapacity)
	{
		storage = new EnergyStorage(energyCapacity, energyTransfer);
		this.energyGen = energyGen;
		this.energyTransfer = energyTransfer;
		this.energyCapacity = energyCapacity;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		LogHelper.info("updating Entity.");
		
		if (!worldObj.isRemote)
		{
			generateEnergy();
			LogHelper.info("generating energy");
			
			if (storage.getEnergyStored() > 0)
			{
				transferEnergy();
			}
		}
	}
	
	public int getEnergyGen()
	{
		int energyGen = 0;
		
		ItemStack stack = getStackInSlot(0);
		LogHelper.info("Stack in slot:" + stack);
		
		energyGen = EnergyHelper.capsuleEnergyGen(stack);
		
		return energyGen;
	}
	
	public void generateEnergy()
	{
		currentEnergy = getEnergyGen();
		storage.modifyEnergyStored(currentEnergy);
	}
	
	public void transferEnergy()
	{
		
	}
	
	/*
	 * ISidedInventory implemented methods.
	 */
	@Override
	public int getSizeInventory() 
	{
		return chemicalReactorItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return chemicalReactorItemStacks[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if (chemicalReactorItemStacks[index] != null)
        {
            ItemStack itemstack;

            if (chemicalReactorItemStacks[index].stackSize <= count)
            {
                itemstack = chemicalReactorItemStacks[index];
                chemicalReactorItemStacks[index] = null;
                
                return itemstack;
            }
            else
            {
                itemstack = chemicalReactorItemStacks[index].splitStack(count);

                if (chemicalReactorItemStacks[index].stackSize == 0)
                {
                	chemicalReactorItemStacks[index] = null;
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
		if (chemicalReactorItemStacks[index] != null)
		{
			ItemStack stack = chemicalReactorItemStacks[index];
			chemicalReactorItemStacks[index] = null;
			
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
		chemicalReactorItemStacks[index] = stack;
		
		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
				stack.stackSize = getInventoryStackLimit();
		}
	 
		markDirty();
	}

	@Override
	public String getInventoryName() 
	{
		return "container.pressurizedTank";
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
		chemicalReactorItemStacks = new ItemStack[getSizeInventory()];
	 
		for (int i = 0; i < list.tagCount(); ++i) 
		{ 
			NBTTagCompound comp = list.getCompoundTagAt(i); 
			int j = comp.getByte("Slot") & 255;
			
			if (j >= 0 && j < chemicalReactorItemStacks.length)
			{
				chemicalReactorItemStacks[j] = ItemStack.loadItemStackFromNBT(comp);
			}
		} 
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
	 
		for (int i = 0; i < chemicalReactorItemStacks.length; ++i)
		{
			if (chemicalReactorItemStacks[i] != null)
			{
				NBTTagCompound comp = new NBTTagCompound();
				comp.setByte("Slot", (byte) i);
				chemicalReactorItemStacks[i].writeToNBT(comp);
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
}
