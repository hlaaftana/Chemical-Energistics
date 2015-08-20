package com.thexfactor117.ce.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ConfigHandler 
{	
	// Categories
	public static final String WORLD_GEN = "worldgen";
	public static final String MACHINERY = "machinery";
	public static final String EXTRA = "extra";

	// worldgen
	public static boolean generateAluminum;
	public static boolean generateSulfur;
	public static boolean generateTungsten;
	public static boolean generateUranium;
	public static boolean generateIridium;
	public static boolean generateMercuryLakes;
	
	// machinery
	
	
	// extra
	public static int temperatureMeasure;
	
	public static void registerConfig(File file)
	{
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
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
}
