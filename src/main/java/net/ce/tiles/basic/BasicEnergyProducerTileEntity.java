package net.ce.tiles.basic;

import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyProvider;

public class BasicEnergyProducerTileEntity extends BasicEnergyStorageTileEntity implements IEnergyProvider
{
	public BasicEnergyProducerTileEntity(int maxEnergy, int maxExtract)
	{
		super(maxEnergy, 0, maxExtract);
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
