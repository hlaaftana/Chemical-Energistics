package com.thexfactor117.ce.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.thexfactor117.ce.gui.client.GuiChemicalReactor;
import com.thexfactor117.ce.gui.client.GuiElementDiffuser;
import com.thexfactor117.ce.gui.client.GuiElementExtractor;
import com.thexfactor117.ce.gui.containers.ContainerChemicalReactor;
import com.thexfactor117.ce.gui.containers.ContainerElementDiffuser;
import com.thexfactor117.ce.gui.containers.ContainerElementExtractor;
import com.thexfactor117.ce.tiles.machines.TileChemicalReactor;
import com.thexfactor117.ce.tiles.machines.TileElementDiffuser;
import com.thexfactor117.ce.tiles.machines.TileElementExtractor;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{		
		if (ID == 0)
		{
			TileChemicalReactor chemicalReactor = (TileChemicalReactor) world.getTileEntity(x, y, z);
			return new ContainerChemicalReactor(player, chemicalReactor);
		}
		
		if (ID == 1)
		{
			TileElementDiffuser elementDiffuser = (TileElementDiffuser) world.getTileEntity(x, y, z);
			return new ContainerElementDiffuser(player, elementDiffuser);
		}
		
		if (ID == 2)
		{
			TileElementExtractor elementExtractor = (TileElementExtractor) world.getTileEntity(x, y, z);
			return new ContainerElementExtractor(player, elementExtractor);
		}
		
		return null;
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{	
		if (ID == 0)
		{
			TileChemicalReactor chemicalReactor = (TileChemicalReactor) world.getTileEntity(x, y, z);
			return new GuiChemicalReactor(player, chemicalReactor);
		}
		
		if (ID == 1)
		{
			TileElementDiffuser elementDiffuser = (TileElementDiffuser) world.getTileEntity(x, y, z);
			return new GuiElementDiffuser(player, elementDiffuser);
		}
		
		if (ID == 2)
		{
			TileElementExtractor elementExtractor = (TileElementExtractor) world.getTileEntity(x, y, z);
			return new GuiElementExtractor(player, elementExtractor);
		}
		
		return null;
	}
}
