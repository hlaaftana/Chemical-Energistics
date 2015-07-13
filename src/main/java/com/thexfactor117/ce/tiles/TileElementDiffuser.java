package com.thexfactor117.ce.tiles;

import com.thexfactor117.ce.init.CEItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;

public class TileElementDiffuser extends TileEntity implements IEnergyReceiver, IInventory
{
	private ItemStack[] items = new ItemStack[2];
	public EnergyStorage storage = new EnergyStorage(100000, 64);
	public boolean isActive = false;
	public int process = 0;
	public int processMax = 20*30;
	public int energyUse = 30;
	
	/**
	 * Called every tick. Consume energy, create new elements.
	 */
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if (!worldObj.isRemote)
		{
			storage.receiveEnergy(64, true);
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			markDirty();
			
			if (canProcess() && process < processMax)
			{
				process++;
				this.storage.modifyEnergyStored(-this.getEnergyUse());
				
				if (process == processMax)
				{
					this.decrStackSize(0, 1);
					this.setInventorySlotContents(1, getElementGenerated());
					process = 0;
				}
			}
		}
	}
	
	/**
	 * Returns true if the machine can run.
	 * @return
	 */
	public boolean canProcess()
	{
		ItemStack stack = this.getStackInSlot(0);
		ItemStack capsuleStack = new ItemStack(CEItems.capsule);
		
		if (stack != null)
		{
			if (stack.isItemEqual(capsuleStack) && storage.getEnergyStored() > 30)
			{
				isActive = true;
				return true;
			}
		}
		
		isActive = false;
		return false;
	}
	
	/**
	 * Returns an ItemStack based on the y-value of the tile.
	 * @return - ItemStack to be generated
	 */
	public ItemStack getElementGenerated()
	{
		ItemStack hydrogen = new ItemStack(CEItems.gasCapsule, 1, 0);
		ItemStack nitrogen = new ItemStack(CEItems.gasCapsule, 1, 2);
		ItemStack oxygen = new ItemStack(CEItems.gasCapsule, 1, 3);
		ItemStack radon = new ItemStack(CEItems.gasCapsule, 1, 9);
		
		if (this.yCoord < 50)
		{
			return radon;
		}
		
		if (this.yCoord >= 50 && this.yCoord < 100)
		{
			return oxygen;
		}
		
		if (this.yCoord >= 100 && this.yCoord < 150)
		{
			return nitrogen;
		}
		
		if (this.yCoord >= 150)
		{
			return hydrogen;
		}
		
		return null;
	}
	
	public int getEnergyUse()
	{
		return Math.min(energyUse, storage.getEnergyStored());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.readSyncableDataFromNBT(nbt);
		
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
		
		this.writeSyncableDataToNBT(nbt);
		
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
	
	/**
	 * Reads syncable data.
	 * @param nbt
	 */
	public void readSyncableDataFromNBT(NBTTagCompound nbt)
	{
		storage.readFromNBT(nbt);
	}
	
	/**
	 * Writes data that needs to be synced from the server to client.
	 * @param nbt
	 */
	public void writeSyncableDataToNBT(NBTTagCompound nbt)
	{
		storage.writeToNBT(nbt);
	}
	
	/**
	 * Gathers data to be sent to the client.
	 */
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound syncData = new NBTTagCompound();
		this.writeSyncableDataToNBT(syncData);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
	}
	
	/**
	 * Retrieves data sent from the server.
	 */
	@Override
	public void onDataPacket(NetworkManager network, S35PacketUpdateTileEntity packet)
	{
		this.readSyncableDataFromNBT(packet.func_148857_g());
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
		return "Element Diffuser";
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

	/*
	 * IEnergyReceiver Interface
	 */
	@Override
	public boolean canConnectEnergy(ForgeDirection from) 
	{
		return true;
	}
	
	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) 
	{
		return storage.receiveEnergy(maxReceive, simulate);
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
