package com.thexfactor117.ce.tiles.machines;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import com.thexfactor117.ce.init.CEItems;
import com.thexfactor117.ce.tiles.base.TileMachine;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author TheXFactor117
 */
public class TileElementDiffuser extends TileMachine implements IEnergyReceiver, IInventory {
	public EnergyStorage storage = new EnergyStorage(20000, 64);
	public int process = 0;
	public int processMax = 20 * 30;
	public int energyUse = 30;

	public TileElementDiffuser(String name) {
		super();
		items = new ItemStack[2];
		this.name = name;
	}

	public EnergyStorage getStorage() {
		return storage;
	}

	/**
	 * Called every tick. Consume energy, create new elements.
	 */
	@Override
	public void updateEntity() {
		super.updateEntity();

		if (!worldObj.isRemote) {
			if (storage.getEnergyStored() != storage.getMaxEnergyStored()) {
				storage.receiveEnergy(64, true);
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				markDirty();
			}

			if (canProcess() && process < processMax) {
				process++;
				this.storage.modifyEnergyStored(-this.getEnergyUse());

				if (process == processMax) {
					this.decrStackSize(0, 1);
					this.setInventorySlotContents(1, getElementGenerated());
					process = 0;
				}
			}
		}
	}

	/**
	 * Returns true if the machine can run.
	 *
	 * @return
	 */
	public boolean canProcess() {
		ItemStack stack = this.getStackInSlot(0);
		ItemStack capsuleStack = new ItemStack(CEItems.capsule);

		if (stack != null) {
			if (stack.isItemEqual(capsuleStack) && storage.getEnergyStored() > 30) {
				isActive = true;
				return true;
			}
		}

		isActive = false;
		return false;
	}

	/**
	 * Returns an ItemStack based on the y-value of the tile.
	 *
	 * @return - ItemStack to be generated
	 */
	public ItemStack getElementGenerated() {
		ItemStack hydrogen = new ItemStack(CEItems.gasCapsule, 1, 0);
		ItemStack nitrogen = new ItemStack(CEItems.gasCapsule, 1, 2);
		ItemStack oxygen = new ItemStack(CEItems.gasCapsule, 1, 3);
		ItemStack radon = new ItemStack(CEItems.gasCapsule, 1, 9);

		if (this.yCoord < 50) {
			return radon;
		}

		if (this.yCoord >= 50 && this.yCoord < 100) {
			return oxygen;
		}

		if (this.yCoord >= 100 && this.yCoord < 150) {
			return nitrogen;
		}

		if (this.yCoord >= 150) {
			return hydrogen;
		}

		return null;
	}

	public int getEnergyUse() {
		return Math.min(energyUse, storage.getEnergyStored());
	}

	/**
	 * Reads syncable data.
	 *
	 * @param nbt
	 */
	public void readSyncableDataFromNBT(NBTTagCompound nbt) {
		storage.readFromNBT(nbt);
	}

	/**
	 * Writes data that needs to be synced from the server to client.
	 *
	 * @param nbt
	 */
	public void writeSyncableDataToNBT(NBTTagCompound nbt) {
		storage.writeToNBT(nbt);
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return storage.receiveEnergy(maxReceive, simulate);
	}
}
