package com.thexfactor117.ce.init;

import net.minecraft.item.Item;

import com.thexfactor117.ce.helpers.RegisterHelper;
import com.thexfactor117.ce.items.*;

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
	public static Item capsule = new ItemCE("capsule");
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
		
		// Machinery Parts
		RegisterHelper.registerItem(ironPanel);
		RegisterHelper.registerItem(aluminumPanel);
		RegisterHelper.registerItem(thermalPanel);
		RegisterHelper.registerItem(steelPanel);
		RegisterHelper.registerItem(kineticTurbine);
		
		// Miscellaneous Items
		RegisterHelper.registerItem(ironHammer);
		RegisterHelper.registerItem(aluminaCatalyst);
	}
}
