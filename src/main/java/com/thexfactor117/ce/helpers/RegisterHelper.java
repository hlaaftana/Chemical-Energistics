package com.thexfactor117.ce.helpers;

import com.thexfactor117.ce.init.CEItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RegisterHelper {
	/**
	 * @author TheXFactor117
	 * these 2 methods
	 */

	/**
	 * Registers the specified block.
	 *
	 * @param block - block to be registered.
	 */
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the specified item.
	 *
	 * @param item - item to be registered.
	 */
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	/**
	 * @author Hlaaftana
	 * from here on down
	 */

	/**
	 * Registers the 2 specified blocks.
	 *
	 * @param block1 The first block.
	 * @param block2 The second block.
	 */
	public static void register2Blocks(Block block1, Block block2) {
		GameRegistry.registerBlock(block1, block1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block2, block2.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the 3 specified blocks.
	 *
	 * @param block1 The first block.
	 * @param block2 The second block.
	 * @param block3 The third block.
	 */
	public static void register3Blocks(Block block1, Block block2, Block block3) {
		GameRegistry.registerBlock(block1, block1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block2, block2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block3, block3.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the 4 specified blocks.
	 *
	 * @param block1 The first block.
	 * @param block2 The second block.
	 * @param block3 The third block.
	 * @param block4 The fourth block.
	 */
	public static void register4Blocks(Block block1, Block block2, Block block3, Block block4) {
		GameRegistry.registerBlock(block1, block1.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block2, block2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block3, block3.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(block4, block4.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the 2 specified items.
	 *
	 * @param item1 The first item.
	 * @param item2 The second item.
	 */
	public static void register2Items(Item item1, Item item2) {
		GameRegistry.registerItem(item1, item1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item2, item2.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the 3 specified items.
	 *
	 * @param item1 The first item.
	 * @param item2 The second item.
	 * @param item3 The third item.
	 */
	public static void register3Items(Item item1, Item item2, Item item3) {
		GameRegistry.registerItem(item1, item1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item2, item2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item3, item3.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the 4 specified items.
	 *
	 * @param item1 The first item.
	 * @param item2 The second item.
	 * @param item3 The third item.
	 * @param item4 The fourth item.
	 */
	public static void register4Items(Item item1, Item item2, Item item3, Item item4) {
		GameRegistry.registerItem(item1, item1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item2, item2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item3, item3.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(item4, item4.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers the specified fluid.
	 *
	 * @param fluid The fluid.
	 */
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
	}

	/**
	 * Registers a bucket as a container for a fluid.
	 *
	 * @param fluid  The fluid.
	 * @param bucket The filled bucket item.
	 */
	public static void registerFluidBucket(Fluid fluid, Item bucket) {
		FluidContainerRegistry.registerFluidContainer(fluid, new ItemStack(bucket), new ItemStack(Items.bucket));
	}

	/**
	 * Registers a bottle as a container for a fluid.
	 *
	 * @param fluid  The fluid.
	 * @param bottle The filled bottle item.
	 */
	public static void registerFluidBottle(Fluid fluid, Item bottle) {
		FluidContainerRegistry.registerFluidContainer(fluid, new ItemStack(bottle), new ItemStack(Items.glass_bottle));
	}

	/**
	 * Registers a capsule as a container for a fluid.
	 *
	 * @param fluid   The fluid.
	 * @param capsule The filled capsule item.
	 */
	public static void registerFluidCapsule(Fluid fluid, ItemStack capsule) {
		FluidContainerRegistry.registerFluidContainer(fluid, capsule, new ItemStack(CEItems.capsule));
	}

	/**
	 * Registers a capsule as a container for a fluid.
	 *
	 * @param fluid   The FluidStack type fluid.
	 * @param capsule The filled capsule item.
	 */
	public static void registerFluidCapsule(FluidStack fluid, ItemStack capsule) {
		FluidContainerRegistry.registerFluidContainer(fluid, capsule, new ItemStack(CEItems.capsule));
	}

	/**
	 * Returns the unlocalized name of the block.
	 *
	 * @param block The block.
	 * @return The name of the block.
	 */
	public static String blockToString(Block block) {
		return block.getUnlocalizedName().substring(5);
	}

	/**
	 * Returns the unlocalized name of the item.
	 *
	 * @param item The item.
	 * @return The name of the item.
	 */
	public static String itemToString(Item item) {
		return item.getUnlocalizedName().substring(5);
	}
}
