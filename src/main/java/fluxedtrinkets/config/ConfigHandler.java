package fluxedtrinkets.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler{
	
	

	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();

		config.save();

	}
}