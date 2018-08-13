package com.thexfactor117.ce.api.crafting;

import com.thexfactor117.ce.init.CEItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Use the methods provided in this class to add recipes to the Element Extractor. Example
 * implementation can be found at {@link TileElementExtractor}.
 * <p>
 * Most of this code is taken from Minecraft's FurnaceRecipes class. Use that as a reference if
 * needed.
 *
 * @author TheXFactor117
 */
public class ElementExtractorRecipes {
	private static final ElementExtractorRecipes BASE = new ElementExtractorRecipes();
	private Map<ItemStack, ItemStack> extractList = new HashMap<>();

	private ElementExtractorRecipes() {
		this.addExtractorRecipe(Items.redstone, new ItemStack(CEItems.ingotLithium));
		this.addExtractorRecipe(Blocks.stone, new ItemStack(CEItems.ingotSilicon, 4));
		this.addExtractorRecipe(Blocks.cobblestone, new ItemStack(CEItems.ingotSilicon, 1));
		this.addExtractorRecipe(Blocks.dirt, new ItemStack(CEItems.ingotSilicon, 1));
		this.addExtractorRecipe(Blocks.sand, new ItemStack(CEItems.ingotSilicon, 2));
		this.addExtractorRecipe(Blocks.gravel, new ItemStack(CEItems.ingotSilicon, 2));
		this.addExtractorRecipe(Blocks.clay, new ItemStack(CEItems.ingotSilicon, 4));
		this.addExtractorRecipe(Items.water_bucket, new ItemStack(CEItems.dustSodium));
		this.addExtractorRecipe(Items.bone, new ItemStack(CEItems.dustPhosphorus));
	}

	public static ElementExtractorRecipes extract() {
		return BASE;
	}

	/**
	 * Use this method for adding Block input recipes.
	 *
	 * @param input
	 * @param output
	 */
	public void addExtractorRecipe(Block input, ItemStack output) {
		this.addExtractorRecipe(Item.getItemFromBlock(input), output);
	}

	/**
	 * Use this method for adding Item input recipes.
	 *
	 * @param input
	 * @param output
	 */
	public void addExtractorRecipe(Item input, ItemStack output) {
		this.addExtractorRecipe(new ItemStack(input, 1, 32767), output);
	}

	public void addExtractorRecipe(ItemStack input, ItemStack output) {
		this.extractList.put(input, output);
	}

	/**
	 * Returns the ItemStack result of the item being processed.
	 *
	 * @param stack
	 * @return Output of the parameter.
	 */
	public ItemStack getExtractionResult(ItemStack stack) {
		Iterator iterator = this.extractList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		}
		while (!this.func_151397_a(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private static boolean func_151397_a(ItemStack stack, ItemStack stack2) {
		return stack2.getItem() == stack.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack.getItemDamage());
	}

	public Map<ItemStack, ItemStack> getExtractList() {
		return extractList;
	}
}
