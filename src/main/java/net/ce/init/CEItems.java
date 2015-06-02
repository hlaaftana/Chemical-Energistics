package net.ce.init;

import net.ce.helpers.RegisterHelper;
import net.ce.items.ItemCE;
import net.ce.items.ItemGasCapsule;
import net.ce.items.ItemLiquidCapsule;
import net.minecraft.item.Item;

public class CEItems 
{
	// Valuables
	public static Item ingotAluminum = new ItemCE("ingotAluminum");
	public static Item ingotTungsten = new ItemCE("ingotTungsten");
	public static Item ingotIridium = new ItemCE("ingotIridium");
	public static Item ingotUranium = new ItemCE("ingotUranium");
	public static Item ingotLithium = new ItemCE("ingotLithium");
	public static Item ingotSilicon = new ItemCE("ingotSilicon");
	public static Item ingotIodine = new ItemCE("ingotIodine");
	public static Item ingotMercury = new ItemCE("ingotMercury");
	public static Item dustSulfur = new ItemCE("dustSulfur");
	public static Item dustAluminum = new ItemCE("dustAluminum");
	public static Item dustTungsten = new ItemCE("dustTungsten");
	public static Item dustSodium = new ItemCE("dustSodium");
	public static Item dustPhosphorus = new ItemCE("dustPhosphorus");
	public static Item carbonFiber = new ItemCE("carbonFiber");
	
	// Capsules
	public static Item capsule = new ItemCE("capsule");
	public static Item gasCapsule = new ItemGasCapsule("gasCapsule");
	public static Item liquidCapsule = new ItemLiquidCapsule("liquidCapsule");
	
	public static void registerItems()
	{
		// Valuables
		RegisterHelper.registerItem(ingotAluminum);
		RegisterHelper.registerItem(ingotTungsten);
		RegisterHelper.registerItem(ingotIridium);
		RegisterHelper.registerItem(ingotUranium);
		RegisterHelper.registerItem(ingotLithium);
		RegisterHelper.registerItem(ingotSilicon);
		RegisterHelper.registerItem(ingotIodine);
		RegisterHelper.registerItem(ingotMercury);
		RegisterHelper.registerItem(dustSulfur);
		RegisterHelper.registerItem(dustAluminum);
		RegisterHelper.registerItem(dustTungsten);
		RegisterHelper.registerItem(dustSodium);
		RegisterHelper.registerItem(dustPhosphorus);
		RegisterHelper.registerItem(carbonFiber);
		
		// Capsules
		RegisterHelper.registerItem(capsule);
		RegisterHelper.registerItem(gasCapsule);
		RegisterHelper.registerItem(liquidCapsule);
	}
}
