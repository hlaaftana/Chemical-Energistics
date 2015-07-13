package com.thexfactor117.ce.api.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.thexfactor117.ce.init.CEItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ElementExtractorRecipes 
{
	private static final ElementExtractorRecipes BASE = new ElementExtractorRecipes();
	@SuppressWarnings("rawtypes")
	private Map extractList = new HashMap();
	
	public static ElementExtractorRecipes extract()
	{
		return BASE;
	}
	
	private ElementExtractorRecipes()
	{
		this.addExtractorRecipe(Items.redstone, new ItemStack(CEItems.ingotLithium));
		this.addExtractorRecipe(Blocks.stone, new ItemStack(CEItems.ingotSilicon, 4));
		this.addExtractorRecipe(Blocks.cobblestone, new ItemStack(CEItems.ingotSilicon, 1));
		this.addExtractorRecipe(Blocks.dirt, new ItemStack(CEItems.ingotSilicon, 1));
		this.addExtractorRecipe(Blocks.sand, new ItemStack(CEItems.ingotSilicon, 2));
		this.addExtractorRecipe(Blocks.gravel, new ItemStack(CEItems.ingotSilicon, 2));
		this.addExtractorRecipe(Blocks.clay, new ItemStack(CEItems.ingotSilicon, 4));
		this.addExtractorRecipe(Items.water_bucket, new ItemStack(CEItems.ingotIodine));
	}
	
	public void addExtractorRecipe(Block input, ItemStack output)
	{
		this.addExtractorRecipe(Item.getItemFromBlock(input), output);
	}
	
	public void addExtractorRecipe(Item input, ItemStack output)
	{
		this.addExtractorRecipe(new ItemStack(input, 1, 32767), output);
	}
	
	@SuppressWarnings("unchecked")
	public void addExtractorRecipe(ItemStack input, ItemStack output)
	{
		this.extractList.put(input, output);
	}
	
	@SuppressWarnings("rawtypes")
	public ItemStack getExtractionResult(ItemStack stack)
	{
		Iterator iterator = this.extractList.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
			{
				return null;
			}
			
			entry = (Entry) iterator.next();
		}
		while (!this.func_151397_a(stack, (ItemStack)entry.getKey()));
		
		return (ItemStack)entry.getValue();
	}
	
	private boolean func_151397_a(ItemStack stack, ItemStack stack2)
    {
        return stack2.getItem() == stack.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack.getItemDamage());
    }
	
	@SuppressWarnings("rawtypes")
	public Map getExtractList()
	{
		return extractList;
	}
}
