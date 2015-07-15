package com.thexfactor117.ce.tiles.machines;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;

import com.thexfactor117.ce.api.crafting.ElementExtractorRecipes;
import com.thexfactor117.ce.helpers.LogHelper;
import com.thexfactor117.ce.tiles.base.TileMachine;

public class TileElementExtractor extends TileMachine implements IEnergyReceiver
{
	public EnergyStorage storage = new EnergyStorage(20000, 64);
	public int process = 0;
	public int processMax = 20*2;
	public int energyUse = 30;
	
	public TileElementExtractor()
	{
		super();
		items = new ItemStack[2];
	}
	
	/**
	 * Called every tick. Consume energy, extract items.
	 */
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if (!worldObj.isRemote)
		{
			if (storage.getEnergyStored() != storage.getMaxEnergyStored())
			{
				storage.receiveEnergy(64, true);
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				markDirty();
			}
			
			if (canProcess() && process < processMax)
			{
				process++;
				this.storage.modifyEnergyStored(-getEnergyUse());
				
				if (process == processMax)
				{
					this.extractItem();
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
		if (this.items[0] != null)
		{
			if (storage.getEnergyStored() > 30)
			{
				LogHelper.info("Test 1.");
				ItemStack extractStack = ElementExtractorRecipes.extract().getExtractionResult(this.items[0]);
				
				if (extractStack == null) return false;
				if (this.items[1] == null) return true;
				if (!this.items[1].isItemEqual(extractStack)) return false;
				
				LogHelper.info("Test 3.");
				int result = this.items[1].stackSize + extractStack.stackSize;
				return result <= this.getInventoryStackLimit() && result <= this.items[1].getMaxStackSize();
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if input item can be extracted into something else. If so,
	 * extract the item.
	 */
	public void extractItem()
	{
		if (this.canProcess())
		{
			ItemStack extractStack = ElementExtractorRecipes.extract().getExtractionResult(this.items[0]);
			
			if (this.items[1] == null)
			{
				this.items[1] = extractStack.copy();
			}
			else if (this.items[1].getItem() == extractStack.getItem())
			{
				this.items[1].stackSize += extractStack.stackSize;
			}
			
			this.decrStackSize(0, 1);
		}
	}
	
	/**
	 * Energy to be used per tick.
	 * @return - RF/t
	 */
	public int getEnergyUse()
	{
		return Math.min(energyUse, storage.getEnergyStored());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.readSyncableDataFromNBT(nbt); 
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		this.writeSyncableDataToNBT(nbt);
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
	public String getInventoryName() 
	{
		return "Element Extractor";
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
