package com.thexfactor117.ce.tiles.machines;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;

import com.thexfactor117.ce.helpers.EnergyHelper;
import com.thexfactor117.ce.init.CEItems;
import com.thexfactor117.ce.tiles.base.TileMachine;

public class TileCatalyticReactor extends TileMachine implements IEnergyProvider
{
	public EnergyStorage storage = new EnergyStorage(100000, 128);
	public int process = 0;
	public int processMax = 25*2;
	public int catalystDamage = 0;
	
	public TileCatalyticReactor(String name)
	{
		super();
		this.items = new ItemStack[2];
		this.name = name;
	}
	
	/**
	 * Called every tick. Generate and transfer energy if possible.
	 */
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if (!worldObj.isRemote)
		{
			if (items[1] != null && process < processMax && canGenerate())
			{
				process++;
				generate();
				
				if (process == processMax)
				{
					ItemStack catalyst = new ItemStack(CEItems.aluminaCatalyst);
					this.decrStackSize(1, 1);
					
					if (this.items[0] != null && this.items[0].isItemEqual(catalyst))
					{
						catalystDamage++;
					}
					
					if (catalystDamage == 64)
					{
						this.decrStackSize(0, 1);
						catalystDamage = 0;
					}
					
					process = 0;
				}
			}
			
			transfer();
		}
	}
	
	/**
	 * Gets the item's energy value in the slot.
	 * @param stack
	 * @return energy value
	 */
	public int getEnergyValue(ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		
		if (this.items[0] == null || this.items[0].getItem() != CEItems.aluminaCatalyst)
		{
			return EnergyHelper.getCapsuleEnergyGen(stack);
		}
		
		ItemStack catalyst = new ItemStack(CEItems.aluminaCatalyst);
		
		if (this.items[0].isItemEqual(catalyst))
		{
			return EnergyHelper.getCapsuleEnergyGen(stack) * 2;
		}
		
		return EnergyHelper.getCapsuleEnergyGen(stack);
	}
	
	/**
	 * Returns true if the machine can generate RF.
	 */
	public boolean canGenerate()
	{
		return getEnergyValue(this.items[1]) > 0 && storage.getEnergyStored() < storage.getMaxEnergyStored();
	}
	
	/**
	 * Generate Energy.
	 */
	public void generate()
	{
		int energy = getEnergyValue(items[1]);
		
		if (energy > 0)
		{
			this.isActive = true;
			storage.modifyEnergyStored(energy);
			worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
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
		if (storage.getEnergyStored() > 0)
		{
			for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) 
			{
	            TileEntity tile = getWorldObj().getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
	            
	            if (tile instanceof IEnergyReceiver) 
	            {
	                IEnergyReceiver receiver = (IEnergyReceiver)tile;
	                
	        		this.storage.modifyEnergyStored(-receiver.receiveEnergy(direction.getOpposite(), Math.min(this.storage.getMaxReceive(), this.storage.getEnergyStored()), false));
	        		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	        		markDirty();
	            }
	        }
		}
	}
	
	/*
	 * NBT Data and Packets
	 */
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
		return name;
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
