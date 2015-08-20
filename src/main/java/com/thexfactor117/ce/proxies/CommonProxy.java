package com.thexfactor117.ce.proxies;

import com.thexfactor117.ce.tiles.machines.TileCatalyticReactor;
import com.thexfactor117.ce.tiles.machines.TileChemicalReactor;
import com.thexfactor117.ce.tiles.machines.TileElementDiffuser;
import com.thexfactor117.ce.tiles.machines.TileElementExtractor;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * @author TheXFactor117
 *
 */
public class CommonProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileChemicalReactor.class, "chemicalReactor");
		GameRegistry.registerTileEntity(TileCatalyticReactor.class, "catalyticReactor");
		GameRegistry.registerTileEntity(TileElementDiffuser.class, "elementDiffuser");
		GameRegistry.registerTileEntity(TileElementExtractor.class, "elementExtractor");
	}
}
