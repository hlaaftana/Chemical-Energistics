package com.thexfactor117.ce.proxies;

import com.thexfactor117.ce.tiles.TileChemicalReactor;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileChemicalReactor.class, "chemicalReactor");
	}
}
