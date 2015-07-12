package com.thexfactor117.ce.handlers;

import com.thexfactor117.ce.gui.client.GuiChemicalReactor;
import com.thexfactor117.ce.gui.client.GuiPressurizedTank;
import com.thexfactor117.ce.gui.containers.ContainerChemicalReactor;
import com.thexfactor117.ce.gui.containers.ContainerPressurizedTank;
import com.thexfactor117.ce.tiles.TileChemicalReactor;
import com.thexfactor117.ce.tiles.TilePressurizedTank;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
		{
			TilePressurizedTank pressurizedTank = (TilePressurizedTank) world.getTileEntity(x, y, z);
			return new ContainerPressurizedTank(player, pressurizedTank);
		}
		
		if (ID == 1)
		{
			TileChemicalReactor chemicalReactor = (TileChemicalReactor) world.getTileEntity(x, y, z);
			return new ContainerChemicalReactor(player, chemicalReactor);
		}
		
		return null;
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == 0)
		{
			TilePressurizedTank pressurizedTank = (TilePressurizedTank) world.getTileEntity(x, y, z);
			return new GuiPressurizedTank(player, pressurizedTank);
		}
		
		if (ID == 1)
		{
			TileChemicalReactor chemicalReactor = (TileChemicalReactor) world.getTileEntity(x, y, z);
			return new GuiChemicalReactor(player, chemicalReactor);
		}
		
		return null;
	}
}
