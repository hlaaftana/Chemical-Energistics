package net.ce.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper 
{
	/**
	 * Registers the specified block.
	 * @param block - block to be registered.
	 */
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the specified item.
	 * @param item - item to be registered.
	 */
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	
	// Regsitration with CE is still being worked out for an efficient way.
}
