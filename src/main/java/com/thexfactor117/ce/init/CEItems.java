package com.thexfactor117.ce.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.thexfactor117.ce.helpers.RegisterHelper;
import com.thexfactor117.ce.items.*;
import com.thexfactor117.ce.enums.CompoundEnum;
import com.thexfactor117.ce.enums.ElementEnum;

/**
 * 
 * @author TheXFactor117
 * 
 */
public class CEItems 
{
	// Valuables
	public static Item ingotAluminum = new ItemCE("ingotAluminum");
	public static Item ingotIridium = new ItemCE("ingotIridium");
	public static Item ingotUranium = new ItemCE("ingotUranium");
	public static Item ingotSteel = new ItemCE("ingotSteel");
	public static Item ingotLithium = new ItemCE("ingotLithium");
	public static Item ingotSilicon = new ItemCE("ingotSilicon");
	public static Item ingotIodine = new ItemCE("ingotIodine");
	public static Item ingotMercury = new ItemCE("ingotMercury");
	public static Item dustSulfur = new ItemCE("dustSulfur");
	public static Item dustAluminum = new ItemCE("dustAluminum");
	public static Item dustSodium = new ItemCE("dustSodium");
	public static Item dustPhosphorus = new ItemCE("dustPhosphorus");
	public static Item carbonFiber = new ItemCE("carbonFiber");
	
	// Capsules
	public static Item capsule = new ItemCapsule("capsule");
	public static Item gasCapsule = new ItemGasCapsule("gasCapsule");
	public static Item liquidCapsule = new ItemLiquidCapsule("liquidCapsule");
	
	// Machinery Parts
	public static Item ironPanel = new ItemCE("ironPanel");
	public static Item aluminumPanel = new ItemCE("aluminumPanel");
	public static Item thermalPanel = new ItemCE("thermalPanel");
	public static Item steelPanel = new ItemCE("steelPanel");
	public static Item kineticTurbine = new ItemCE("kineticTurbine");
	
	// Miscellaneous Items
	public static Item ironHammer = new ItemIronHammer("ironHammer");
	public static Item aluminaCatalyst = new ItemAluminaCatalyst("aluminaCatalyst");
	
	// Testing
	public static Item iron = new ItemElement(ElementEnum.IRON);
	public static Item water = new ItemCompound(CompoundEnum.WATER);
	
	public static void registerItems()
	{
		// Valuables
		RegisterHelper.registerItem(ingotAluminum);
		RegisterHelper.registerItem(ingotIridium);
		RegisterHelper.registerItem(ingotUranium);
		RegisterHelper.registerItem(ingotSteel);
		RegisterHelper.registerItem(ingotLithium);
		RegisterHelper.registerItem(ingotSilicon);
		RegisterHelper.registerItem(ingotIodine);
		RegisterHelper.registerItem(ingotMercury);
		RegisterHelper.registerItem(dustSulfur);
		RegisterHelper.registerItem(dustAluminum);
		RegisterHelper.registerItem(dustSodium);
		RegisterHelper.registerItem(dustPhosphorus);
		RegisterHelper.registerItem(carbonFiber);
		
		// Capsules
		RegisterHelper.registerItem(capsule);
		RegisterHelper.registerItem(gasCapsule);
		RegisterHelper.registerItem(liquidCapsule);
		
		RegisterHelper.registerFluidCapsule(CEFluids.mercury, new ItemStack(liquidCapsule, 1, 12));
		// If you want it to register a specific amount of millibuckets for one capsule, do:
		// RegisterHelper.registerFluidCapsule(new FluidStack(CEFluids.mercury, (Amount of millibuckets here)), new ItemStack(liquidCapsule, 1, 12));
		
		// Machinery Parts
		RegisterHelper.registerItem(ironPanel);
		RegisterHelper.registerItem(aluminumPanel);
		RegisterHelper.registerItem(thermalPanel);
		RegisterHelper.registerItem(steelPanel);
		RegisterHelper.registerItem(kineticTurbine);
		
		// Miscellaneous Items
		RegisterHelper.registerItem(ironHammer);
		RegisterHelper.registerItem(aluminaCatalyst);
		
		// Testing
		RegisterHelper.registerItem(iron);
		RegisterHelper.registerItem(water);
	}
}