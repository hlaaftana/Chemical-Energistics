package com.thexfactor117.ce.init;

import net.minecraft.block.Block;

import com.thexfactor117.ce.blocks.BlockCE;
import com.thexfactor117.ce.blocks.machines.BlockCatalyticReactor;
import com.thexfactor117.ce.blocks.machines.BlockChemicalReactor;
import com.thexfactor117.ce.blocks.machines.BlockElementDiffuser;
import com.thexfactor117.ce.blocks.machines.BlockElementExtractor;
import com.thexfactor117.ce.helpers.RegisterHelper;

public class CEBlocks 
{
	// Naturally Generating Blocks
	public static Block oreAluminum = new BlockCE("oreAluminum", 2.0F, 5.0F, 2, 0F);
	public static Block oreSulfur = new BlockCE("oreSulfur", 2.5F, 4.0F, 1, 0F);
	public static Block oreIridium = new BlockCE("oreIridium", 3.5F, 7.0F, 3, 0F);
	public static Block oreUranium = new BlockCE("oreUranium", 3.0F, 6.0F, 2, 0F);
	
	// Machinery Parts
	public static Block machineFrame = new BlockCE("machineFrame", 1.5F, 3.0F, 2, 0F);
	
	// Machines
	public static Block chemicalReactor = new BlockChemicalReactor();
	public static Block catalyticReactor = new BlockCatalyticReactor();
	public static Block elementDiffuser = new BlockElementDiffuser();
	public static Block elementExtractor = new BlockElementExtractor();
	//public static Block elementFreezer = new BlockElementFreezer();
	//public static Block elementOven = new BlockElementOven();
	
	// Fluids
	public static Block blockFluidExample = new BlockFluidExample();
	
	public static void registerBlocks()
	{
		// Naturally Generating Blocks
		RegisterHelper.registerBlock(oreAluminum);
		RegisterHelper.registerBlock(oreSulfur);
		RegisterHelper.registerBlock(oreIridium);
		RegisterHelper.registerBlock(oreUranium);
		
		// Machinery Parts
		RegisterHelper.registerBlock(machineFrame);
		
		// Machines
		RegisterHelper.registerBlock(chemicalReactor);
		RegisterHelper.registerBlock(catalyticReactor);
		RegisterHelper.registerBlock(elementDiffuser);
		RegisterHelper.registerBlock(elementExtractor);
		//RegisterHelper.registerBlock(elementFreezer);
		//RegisterHelper.registerBlock(elementOven);
		
		RegisterHelper.registerBlock(blockFluidExample);
	}
}
