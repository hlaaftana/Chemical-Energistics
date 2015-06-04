package net.ce.tiles.basic;

import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyHandler;

public class BasicEnergyHandlerTileEntity extends BasicEnergyStorageTileEntity implements IEnergyHandler
{
	public BasicEnergyHandlerTileEntity(int maxEnergy, int maxReceive)
	{
		super(maxEnergy, maxReceive);
	}
	
	public BasicEnergyHandlerTileEntity(int maxEnergy, int maxReceive, int maxExtract)
	{
		super(maxEnergy, maxReceive, maxExtract);
	}
	
	@Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) 
	{
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) 
    {
        return storage.extractEnergy(maxExtract, simulate);
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
