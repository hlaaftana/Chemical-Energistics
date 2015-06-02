package net.ce.proxies;

import net.ce.machines.tiles.TileEntityPressurizedTank;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityPressurizedTank.class, "pressurizedTank");
	}
}
