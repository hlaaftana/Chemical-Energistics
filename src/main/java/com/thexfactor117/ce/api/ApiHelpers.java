package com.thexfactor117.ce.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameData;

public class ApiHelpers 
{
	public static boolean compareToOreName(ItemStack stack, String oreName)
	{
		for(int id : OreDictionary.getOreIDs(stack))
		{
			if (OreDictionary.getOreName(id).equals(oreName))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static String nameFromStack(ItemStack stack)
	{
		if(stack==null)
		{
			return "";
		}
		
		try
		{
			return GameData.getItemRegistry().getNameForObject(stack.getItem());
		}
		catch (NullPointerException e) {}
		
		return "";
	}
}
