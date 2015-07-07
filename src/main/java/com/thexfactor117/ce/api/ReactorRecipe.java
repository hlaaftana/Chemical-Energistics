package com.thexfactor117.ce.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ReactorRecipe 
{
	public final Object input;
	public final ItemStack output;
	public final int time;
	
	public ReactorRecipe(ItemStack output, Object input, int time)
	{
		this.input = input;
		this.output = output;
		this.time = time;
	}
	
	public static ArrayList<ReactorRecipe> recipeList = new ArrayList<ReactorRecipe>();
	
	public static void addRecipe(ItemStack output, Object input, int time)
	{
		recipeList.add(new ReactorRecipe(output, input, time));
	}
	
	public static ReactorRecipe findRecipe(ItemStack input)
	{
		for (ReactorRecipe recipe : recipeList)
		{
			if (recipe.input instanceof ItemStack && OreDictionary.itemMatches((ItemStack)recipe.input, input, false))
			{
				return recipe;
			}
			else if (recipe.input instanceof String && ApiHelpers.compareToOreName(input, (String)recipe.input))
			{
				return recipe;
			}
		}
		
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<ReactorRecipe> removeRecipes(ItemStack stack)
	{
		List<ReactorRecipe> list = new ArrayList();
		Iterator<ReactorRecipe> it = recipeList.iterator();
		
		while(it.hasNext())
		{
			ReactorRecipe ir = it.next();
			
			if(OreDictionary.itemMatches(ir.output, stack, true))
			{
				list.add(ir);
				it.remove();
			}
		}
		return list;
	}
}
