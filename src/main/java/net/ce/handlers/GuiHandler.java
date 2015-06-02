package net.ce.handlers;

import net.ce.gui.ContainerPressurizedTank;
import net.ce.gui.GuiPressurizedTank;
import net.ce.helpers.LogHelper;
import net.ce.machines.tiles.TileEntityPressurizedTank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		LogHelper.info("Hello Server 1?");
		if (ID == 0)
		{
			TileEntityPressurizedTank pressurizedTank = (TileEntityPressurizedTank) world.getTileEntity(x, y, z);
			return new ContainerPressurizedTank(player, pressurizedTank);
		}
		
		return null;
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		LogHelper.info("Hello Client 1?");
		if (ID == 0)
		{
			TileEntityPressurizedTank pressurizedTank = (TileEntityPressurizedTank) world.getTileEntity(x, y, z);
			return new GuiPressurizedTank(player, pressurizedTank);
		}
		
		return null;
	}
}
