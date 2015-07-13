package com.thexfactor117.ce.tiles.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileMachine extends TileEntity implements IInventory
{
	protected ItemStack[] items;
	protected boolean isActive = false;
	
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
	
	/*
	 * IInventory Interface
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
		return "";
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
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
