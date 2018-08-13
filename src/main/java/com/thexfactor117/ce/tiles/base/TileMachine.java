package com.thexfactor117.ce.tiles.base;

import cofh.api.energy.EnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

/**
 * @author TheXFactor117
 */
public abstract class TileMachine extends TileEntity implements IInventory {
	protected String name;
	protected ItemStack[] items;
	protected boolean isActive = false;

	abstract EnergyStorage getStorage();

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList list = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		items = new ItemStack[getSizeInventory()];

		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound comp = list.getCompoundTagAt(i);
			int j = comp.getByte("Slot") & 255;

			if (j >= 0 && j < items.length) {
				items[j] = ItemStack.loadItemStackFromNBT(comp);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		NBTTagList list = new NBTTagList();

		for (int i = 0; i < items.length; ++i) {
			if (items[i] != null) {
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
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return items[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (items[index] == null) return null;
		ItemStack itemstack;

		if (items[index].stackSize <= count) {
			itemstack = items[index];
			items[index] = null;
		} else {
			itemstack = items[index].splitStack(count);
			if (items[index].stackSize == 0) {
				items[index] = null;
			}
		}

		return itemstack;
	}

	/**
	 * Called to drop items as EntityItem's when closed.
	 * Example would be a Crafting Table.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = items[index];
		items[index] = null;
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		items[index] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}

		markDirty();
	}

	@Override
	public String getInventoryName() {
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	public int getEnergyStored(ForgeDirection from) {
		return getStorage().getEnergyStored();
	}

	public int getMaxEnergyStored(ForgeDirection from) {
		return getStorage().getMaxEnergyStored();
	}

	/**
	 * Retrieves data sent from the server.
	 */
	public void onDataPacket(NetworkManager network, S35PacketUpdateTileEntity packet) {
		this.readSyncableDataFromNBT(packet.func_148857_g());
	}

	/**
	 * Gathers data to be sent to the client.
	 */
	public Packet getDescriptionPacket() {
		NBTTagCompound syncData = new NBTTagCompound();
		this.writeSyncableDataToNBT(syncData);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
	}

	/*
	 * NBT Data and Packets
	 */
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.readSyncableDataFromNBT(nbt);
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		this.writeSyncableDataToNBT(nbt);
	}
}
