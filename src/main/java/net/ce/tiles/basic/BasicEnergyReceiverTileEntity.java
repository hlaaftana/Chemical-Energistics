package net.ce.tiles.basic;

import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyReceiver;

public class BasicEnergyReceiverTileEntity extends BasicEnergyStorageTileEntity implements IEnergyReceiver
{
	public BasicEnergyReceiverTileEntity(int maxEnergy, int maxReceive)
	{
		super(maxEnergy, maxReceive);
	}
	
	public BasicEnergyReceiverTileEntity(int maxEnergy, int maxReceive, int maxExtract)
	{
		super(maxEnergy, maxReceive, maxExtract);
	}
	
	public void consumeEnergy(int consume) 
	{
        modifyEnergyStored(-consume);
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

    @Override
    public boolean canConnectEnergy(ForgeDirection from) 
    {
        return true;
    }
}
