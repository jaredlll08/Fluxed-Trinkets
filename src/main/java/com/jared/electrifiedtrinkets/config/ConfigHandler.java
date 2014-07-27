package com.jared.electrifiedtrinkets.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler{
	
	
	public static boolean copperGeneration, leadGeneration;

	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();

		String worldGen = "WORLD GEN";
		
		copperGeneration = config.getBoolean("Copper Ore", worldGen, true, "Disable the Copper Ore gen");
		leadGeneration = config.getBoolean("Lead Ore", worldGen, true, "Disable the Lead Ore gen");
		config.save();

	}
}