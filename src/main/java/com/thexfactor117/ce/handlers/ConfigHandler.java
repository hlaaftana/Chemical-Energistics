package com.thexfactor117.ce.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * @author TheXFactor117
 */
public class ConfigHandler {
	// Categories
	public static final String WORLD_GEN = "worldgen", MACHINERY = "machinery", EXTRA = "extra";

	// worldgen
	public static boolean generateAluminum, generateSulfur, generateTungsten,
			generateUranium, generateIridium, generateMercuryLakes;

	// machinery


	// extra
	public static int temperatureMeasure;

	public static void registerConfig(File file) {
		File mainFile = new File(file + "/ChemicalEnergistics.cfg");

		Configuration config = new Configuration(mainFile);
		config.load();

		// worldgen
		generateAluminum = config.get(WORLD_GEN, "generateAluminum", true, "Should Aluminum Ore generate?").getBoolean();
		generateSulfur = config.get(WORLD_GEN, "generateSulfur", true, "Should Sulfur Ore generate?").getBoolean();
		generateUranium = config.get(WORLD_GEN, "generateUranium", true, "Should Uranium Ore generate?").getBoolean();
		generateIridium = config.get(WORLD_GEN, "generateIridium", true, "Should Iridium Ore generate").getBoolean();
		generateMercuryLakes = config.get(WORLD_GEN, "generateMercuryLakes", true, "Should mercury lakes generate?").getBoolean();

		// machinery


		// extra
		temperatureMeasure = config.get(EXTRA, "temperatureMeasure", 0, "What is your temperature measure of choice? 0 for Kelvin, 1 for Celsius, 2 for Fahrenheit. Anything else will be Rankine.").getInt();

		if (config.hasChanged()) config.save();
	}
}
