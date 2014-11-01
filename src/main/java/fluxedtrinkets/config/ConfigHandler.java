package fluxedtrinkets.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static String categoryEnergy = "Energy Values";

	public static void init(File file) {
		Configuration config = new Configuration(file);
		config.load();

		EffectProps.energyAdvancedIce = config.get(categoryEnergy, "Advanced Ice Energy", 30);
		EffectProps.energyAdvancedLava = config.get(categoryEnergy, "Advanced Lava Energy", 30);
		EffectProps.energyAdvancedLife = config.get(categoryEnergy, "Advanced Life Energy", 30);
		EffectProps.energyAdvancedLightning = config.get(categoryEnergy, "Advanced Lightning Energy", 30);

		EffectProps.energyAir = config.get(categoryEnergy, "Air Energy", 10);
		EffectProps.energyEarth = config.get(categoryEnergy, "Earth Energy", 25);
		EffectProps.energyFall = config.get(categoryEnergy, "Fall Energy", 5);
		EffectProps.energyFeed = config.get(categoryEnergy, "Feed Energy", 20);
		EffectProps.energyFire = config.get(categoryEnergy, "Fire Energy", 40);
		EffectProps.energyHaste = config.get(categoryEnergy, "Haste Energy", 20);
		EffectProps.energyRespiratory = config.get(categoryEnergy, "Respiratory Energy", 10);
		EffectProps.energyStep = config.get(categoryEnergy, "Step Energy", 20);
		EffectProps.energyWater = config.get(categoryEnergy, "Water Energy", 10);
		
		EffectProps.energyHealth = config.get(categoryEnergy, "Health Boost Energy", 600);
		EffectProps.energyWither = config.get(categoryEnergy, "Witherless Energy", 400);
		EffectProps.energyPoison= config.get(categoryEnergy, "Poisonless Energy", 200);
		

		config.save();
	}
}