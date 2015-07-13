package com.thexfactor117.ce.proxies;

import com.thexfactor117.ce.tiles.TileChemicalReactor;
import com.thexfactor117.ce.tiles.TileElementDiffuser;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileChemicalReactor.class, "chemicalReactor");
		GameRegistry.registerTileEntity(TileElementDiffuser.class, "elementDiffuser");
	}
}
