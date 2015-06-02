package net.ce.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler 
{	
	public static void registerConfig(File file)
	{
		File mainFile = new File(file + "/ChemicalEnergistics.cfg");
		
		Configuration config = new Configuration(mainFile);
		config.load();
	}
}
