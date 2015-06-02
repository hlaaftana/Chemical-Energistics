package net.ce.machines.tiles;

import net.ce.helpers.EnergyStorage;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import cofh.api.energy.IEnergyProvider;

public class TileEntityChemicalReactor extends TileEntity implements IEnergyProvider
{
	private EnergyStorage storage;
	private static final String NBT_MAX_ENERGY_GENERATION = "CRMaxEnergyGeneration";
	private static final String NBT_CURRENT_ENERGY_GENERATION = "CRCurrentEnergyGeneration";
	private int maxEnergyGeneration;
	private float currentEnergyGeneration;
	private float oldEnergyGeneration = 0.0F;
	public static final String NAME = "tileChemicalReactor";
	
	public TileEntityChemicalReactor()
	{
		this(0, 0, 0);
	}
	
	public TileEntityChemicalReactor(int maxEnergyGeneration, int maxEnergyTransfer, int capacity)
	{
		storage = new EnergyStorage(capacity, maxEnergyTransfer);
		this.maxEnergyGeneration = maxEnergyGeneration;
	}
	
	/**
	 * Updates entity. Generates RF, and transfer RF if possible.
	 */
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if (!worldObj.isRemote)
		{
			generateEnergy();
			
			if (storage.getEnergyStored() > 0)
			{
				transferEnergy();
			}
		}
	}
	
	public void readSyncableDataFromNBT(NBTTagCompound nbt) 
	{
        currentEnergyGeneration = nbt.getFloat(NBT_CURRENT_ENERGY_GENERATION);
    }
	
    public void writeSyncableDataToNBT(NBTTagCompound nbt) 
    {
        nbt.setFloat(NBT_CURRENT_ENERGY_GENERATION, currentEnergyGeneration);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt) 
    {
        super.readFromNBT(nbt);
        maxEnergyGeneration = nbt.getInteger(NBT_MAX_ENERGY_GENERATION);
        readSyncableDataFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) 
    {
        super.writeToNBT(nbt);
        nbt.setInteger(NBT_MAX_ENERGY_GENERATION, maxEnergyGeneration);
        writeSyncableDataToNBT(nbt);
        storage.writeToNBT(nbt);
    }
    
    @Override
    public Packet getDescriptionPacket() 
	{
        NBTTagCompound syncData = new NBTTagCompound();
        writeSyncableDataToNBT(syncData);

        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, syncData);
    }

    @Override
    public void onDataPacket(NetworkManager pNet, S35PacketUpdateTileEntity pPacket) 
    {
        readSyncableDataFromNBT(pPacket.func_148857_g());
    }
    
    public Item getElement1()
    {
    	
    }
    
    public Item getElement2()
    {
    	
    }
    
    public float getEnergyGeneration()
    {
    	
    	
    	return EnergyHelper.crBaseEnergy *;
    }
    
    /**
     * Max energy that can be produced
     * @return Maximum RF/t
     */
    public int getMaximumEnergyGeneration() 
    {
        return maxEnergyGeneration;
    }
    
    /**
     * The current rate of energy production in RF/t
     * @return The current rate of energy production
     */
    public float getCurrentEnergyGeneration() 
    {
        return currentEnergyGeneration;
    }
    
    /**
     * Gets the current energy generation at this tick and modifies the stored
     * energy by that value, as well as syncing the energy generation rate
     * between client and server.
     */
    private void generateEnergy() 
    {
        currentEnergyGeneration = getEnergyGeneration();
        
        // Amount of energy generated has changed so sync with server
        if ((int) currentEnergyGeneration != (int) oldEnergyGeneration) 
        {
            oldEnergyGeneration = currentEnergyGeneration;
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            markDirty();
        }
        
        storage.modifyEnergyStored(currentEnergyGeneration);
    }
}
