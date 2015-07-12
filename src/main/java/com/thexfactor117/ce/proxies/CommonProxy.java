package com.thexfactor117.ce.proxies;

import com.thexfactor117.ce.tiles.TileChemicalReactor;
import com.thexfactor117.ce.tiles.TilePressurizedTank;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TilePressurizedTank.class, "pressurizedTank");
		GameRegistry.registerTileEntity(TileChemicalReactor.class, "chemicalReactor");
	}
}
