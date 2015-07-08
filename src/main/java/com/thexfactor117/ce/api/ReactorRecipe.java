package com.thexfactor117.ce.api;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ReactorRecipe 
{
	public final Object input;
	public final int energyMultiplier;
	public final int time;
	
	public ReactorRecipe(Object input, int energyMultiplier, int time)
	{
		this.input = input;
		this.energyMultiplier = energyMultiplier;
		this.time = time;
	}
	
	public static ArrayList<ReactorRecipe> recipeList = new ArrayList<ReactorRecipe>();
	
	/**
	 * Adds a recipe for all reactors (Chemical/Catalytic)
	 * @param output
	 * @param input
	 * @param energyMultiplier
	 * @param time
	 */
	public static void addRecipe(ItemStack output, Object input, int energyMultiplier, int time)
	{
		recipeList.add(new ReactorRecipe(input, 25 * energyMultiplier, time));
	}
	
	/**
	 * Finds a specific recipe.
	 * @param input
	 * @return
	 */
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
}
