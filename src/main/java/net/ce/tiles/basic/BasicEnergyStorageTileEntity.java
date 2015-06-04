package net.ce.tiles.basic;

import net.ce.helpers.EnergyStorage;
import net.minecraft.nbt.NBTTagCompound;

public class BasicEnergyStorageTileEntity extends BasicTileEntity
{
	protected EnergyStorage storage;
	private static int currentRF;
	
	public void modifyEnergyStored(int energy)
	{
		storage.modifyEnergyStored(energy);
	}
	
	public BasicEnergyStorageTileEntity(int maxEnergy, int maxRecieve)
	{
		storage = new EnergyStorage(maxEnergy);
		storage.setMaxReceive(maxRecieve);
	}
	
	public BasicEnergyStorageTileEntity(int maxEnergy, int maxRecieve, int maxExtract)
	{
		storage = new EnergyStorage(maxEnergy);
		storage.setMaxReceive(maxRecieve);
		storage.setMaxExtract(maxExtract);
	}
	
	@Override
    public void readFromNBT(NBTTagCompound tagCompound) 
	{
        super.readFromNBT(tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) 
    {
        super.writeToNBT(tagCompound);
    }
    
    public static int getCurrentRF() 
    {
        return currentRF;
    }
    
    public static void setCurrentRF(int currentRF) 
    {
        BasicEnergyStorageTileEntity.currentRF = currentRF;
    }
}
