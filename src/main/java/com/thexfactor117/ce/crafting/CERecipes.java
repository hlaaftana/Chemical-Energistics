package com.thexfactor117.ce.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.thexfactor117.ce.init.CEBlocks;
import com.thexfactor117.ce.init.CEItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CERecipes 
{
	public static void registerRecipes()
	{
		// OreDictionary
		OreDictionary.registerOre("oreAluminum", new ItemStack(CEBlocks.oreAluminum));
		OreDictionary.registerOre("oreSulfur", new ItemStack(CEBlocks.oreSulfur));
		OreDictionary.registerOre("oreTungsten", new ItemStack(CEBlocks.oreTungsten));
		OreDictionary.registerOre("oreIridium", new ItemStack(CEBlocks.oreIridium));
		OreDictionary.registerOre("oreUranium", new ItemStack(CEBlocks.oreUranium));
		OreDictionary.registerOre("ingotAluminum", new ItemStack(CEItems.ingotAluminum));
		OreDictionary.registerOre("ingotTungsten", new ItemStack(CEItems.ingotTungsten));
		OreDictionary.registerOre("ingotIridium", new ItemStack(CEItems.ingotIridium));
		OreDictionary.registerOre("ingotUranium", new ItemStack(CEItems.ingotUranium));
		OreDictionary.registerOre("ingotLithium", new ItemStack(CEItems.ingotLithium));
		OreDictionary.registerOre("ingotSilicon", new ItemStack(CEItems.ingotSilicon));
		OreDictionary.registerOre("ingotIodine", new ItemStack(CEItems.ingotIodine));
		OreDictionary.registerOre("ingotMercury", new ItemStack(CEItems.ingotMercury));
		OreDictionary.registerOre("ingotQuicksilver", new ItemStack(CEItems.ingotMercury));
		OreDictionary.registerOre("dustSulfur", new ItemStack(CEItems.dustSulfur));
		OreDictionary.registerOre("dustAluminum", new ItemStack(CEItems.dustAluminum));
		OreDictionary.registerOre("dustTungsten", new ItemStack(CEItems.dustTungsten));
		OreDictionary.registerOre("dustSodium", new ItemStack(CEItems.dustSodium));
		OreDictionary.registerOre("dustPhosphorus", new ItemStack(CEItems.dustPhosphorus));
		OreDictionary.registerOre("plateIron", new ItemStack(CEItems.ironPanel));
		OreDictionary.registerOre("plateAluminum", new ItemStack(CEItems.aluminumPanel));
		OreDictionary.registerOre("plateThermal", new ItemStack(CEItems.thermalPanel));
		
		// Smelting
		GameRegistry.addSmelting(CEBlocks.oreAluminum, new ItemStack(CEItems.ingotAluminum), 0.8F);
		GameRegistry.addSmelting(CEBlocks.oreTungsten, new ItemStack(CEItems.ingotTungsten), 0.8F);
		
		// Recipes
		GameRegistry.addShapedRecipe(new ItemStack(CEItems.capsule), new Object[] { " A ", "A A", " A ", 'A', Items.iron_ingot });
		GameRegistry.addShapedRecipe(new ItemStack(CEItems.ironPanel, 2), new Object[] { "AAA", 'A', Items.iron_ingot });
		GameRegistry.addShapedRecipe(new ItemStack(CEItems.aluminumPanel, 2), new Object[] { "AAA", 'A', CEItems.ingotAluminum });
		//GameRegistry.addShapedRecipe(new ItemStack(CEItems.thermalPanel), new Object[] { "AAA", 'A', CEItems.alloyThermal });
		GameRegistry.addShapedRecipe(new ItemStack(CEItems.kineticTurbine), new Object[] { "ABA", " A ", "ABA", 'A', Items.iron_ingot, 'B', Blocks.redstone_block });
		GameRegistry.addShapedRecipe(new ItemStack(CEBlocks.machineFrame), new Object[] { "ABA", "B B", "ABA", 'A', CEItems.aluminumPanel, 'B', CEItems.ironPanel });
		
		GameRegistry.addShapedRecipe(new ItemStack(CEBlocks.chemicalReactor), new Object[] { "ABA", "ACA", "ABA", 'A', CEItems.ironPanel, 'B', CEItems.capsule, 'C', CEBlocks.machineFrame });
	}
}
