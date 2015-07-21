package com.thexfactor117.ce.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler 
{	
	// Categories
	public static final String WORLD_GEN = "worldgen";
	public static final String MACHINERY = "machinery";

	// worldgen
	public static boolean generateAluminum;
	public static boolean generateSulfur;
	public static boolean generateTungsten;
	public static boolean generateUranium;
	public static boolean generateIridium;
	
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
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
}
