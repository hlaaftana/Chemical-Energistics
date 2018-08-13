package com.thexfactor117.ce.init;

import com.thexfactor117.ce.enums.CompoundEnum;
import com.thexfactor117.ce.enums.ElementEnum;
import com.thexfactor117.ce.helpers.RegisterHelper;
import com.thexfactor117.ce.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author TheXFactor117
 */
public class CEItems {
	// Valuables
	public static Item ingotAluminum = new ItemCE("ingotAluminum"),
		ingotIridium = new ItemCE("ingotIridium"),
		ingotUranium = new ItemCE("ingotUranium"),
		ingotSteel = new ItemCE("ingotSteel"),
		ingotLithium = new ItemCE("ingotLithium"),
		ingotSilicon = new ItemCE("ingotSilicon"),
		ingotIodine = new ItemCE("ingotIodine"),
		ingotMercury = new ItemCE("ingotMercury"),
		dustSulfur = new ItemCE("dustSulfur"),
		dustAluminum = new ItemCE("dustAluminum"),
		dustSodium = new ItemCE("dustSodium"),
		dustPhosphorus = new ItemCE("dustPhosphorus"),
		carbonFiber = new ItemCE("carbonFiber");

	// Capsules
	public static Item capsule = new ItemCapsule("capsule"),
		gasCapsule = new ItemGasCapsule("gasCapsule"),
		liquidCapsule = new ItemLiquidCapsule("liquidCapsule");

	// Machinery Parts
	public static Item ironPanel = new ItemCE("ironPanel"),
		aluminumPanel = new ItemCE("aluminumPanel"),
		thermalPanel = new ItemCE("thermalPanel"),
		steelPanel = new ItemCE("steelPanel"),
		kineticTurbine = new ItemCE("kineticTurbine");

	// Miscellaneous Items
	public static Item ironHammer = new ItemIronHammer("ironHammer"),
		aluminaCatalyst = new ItemAluminaCatalyst("aluminaCatalyst");

	// Testing
	public static Item iron = new ItemElement(ElementEnum.IRON),
		water = new ItemCompound(CompoundEnum.WATER);

	public static void registerItems() {
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