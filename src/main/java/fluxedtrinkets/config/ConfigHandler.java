package fluxedtrinkets.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler{
	
	
public static String categoryEnergy="Energy Values";
	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();
		
		ConfigProps.energyAdvancedIce = config.get(categoryEnergy, "Advanced Ice Energy", 30).getInt();
		ConfigProps.energyAdvancedLava = config.get(categoryEnergy, "Advanced Lava Energy", 30).getInt();
		ConfigProps.energyAdvancedLife = config.get(categoryEnergy, "Advanced Life Energy", 30).getInt();
		ConfigProps.energyAdvancedLightning = config.get(categoryEnergy, "Advanced Lightning Energy", 30).getInt();
		
		
		ConfigProps.energyAir= config.get(categoryEnergy, "Air Energy", 10).getInt();
		ConfigProps.energyEarth= config.get(categoryEnergy, "Earth Energy", 25).getInt();
		ConfigProps.energyFall= config.get(categoryEnergy, "Fall Energy", 5).getInt();
		ConfigProps.energyFeed= config.get(categoryEnergy, "Feed Energy", 20).getInt();
		ConfigProps.energyFire = config.get(categoryEnergy, "Fire Energy", 40).getInt();
		ConfigProps.energyHaste= config.get(categoryEnergy, "Haste Energy", 20).getInt();
		ConfigProps.energyRespiratory= config.get(categoryEnergy, "Respiratory Energy", 10).getInt();
		ConfigProps.energyStep= config.get(categoryEnergy, "Step Energy", 20).getInt();
		ConfigProps.energyWater= config.get(categoryEnergy, "Water Energy", 10).getInt();
		
		config.save();

	}
}