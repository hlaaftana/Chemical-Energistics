package com.thexfactor117.ce.proxies;

import com.thexfactor117.ce.tiles.TileEntityChemicalReactor;
import com.thexfactor117.ce.tiles.TileEntityPressurizedTank;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityPressurizedTank.class, "pressurizedTank");
		GameRegistry.registerTileEntity(TileEntityChemicalReactor.class, "chemicalReactor");
	}
}
