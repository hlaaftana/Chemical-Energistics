package net.ce.tiles.basic;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class BasicTileEntity extends TileEntity
{
	@Override
    public Packet getDescriptionPacket() 
	{
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) 
    {
        readFromNBT(packet.func_148857_g());
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
    
    
}
