package com.jared.electrifiedtrinkets.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.CreativeTabElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.resources.ItemLeadWire;
import com.jared.electrifiedtrinkets.util.NBTHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class ETItems {

	public static void init() {
		registerItems();
		registerNBT();
	}

	public static CreativeTabElectrifiedTrinkets tab = new CreativeTabElectrifiedTrinkets();

	/*
	 * circuits
	 */
	public static Item circuit = new ItemCircuit("empty");
	public static Item circuitAir = new ItemCircuit("air");
	public static Item circuitEarth = new ItemCircuit("earth");
	public static Item circuitFire = new ItemCircuit("fire");
	public static Item circuitWater = new ItemCircuit("water");

	public static Item advancedCircuit = new ItemCircuit("advancedEmpty");
	public static Item advancedCircuitIce = new ItemCircuit("advancedIce");
	public static Item advancedCircuitLava = new ItemCircuit("advancedLava");
	public static Item advancedCircuitLife = new ItemCircuit("advancedLife");
	public static Item advancedCircuitLightning = new ItemCircuit("advancedLightning");

	/*
	 * items
	 */

	public static Item basicBattery = new ItemBattery();

	public static Item solderingIron = new ItemSolderingIron();

	public static Item leadWire = new ItemLeadWire();

	public static Item manual = new ItemManual();
	
	public static Item modularBelt = new ModularBelt();
	public static Item modularAmulet= new ModularAmulet();
	public static Item modularRing= new ModularRing();
	

	private static void registerItems() {

		/*
		 * Circuits
		 */
		registerCircuit(circuit, "Empty Circuit", "Circuit");
		registerCircuit(circuitEarth, "Terrestrial Circuit", "Circuit_Earth");
		registerCircuit(circuitAir, "Atmospheric Circuit", "Circuit_Air");
		registerCircuit(circuitFire, "Scorched Circuit", "Circuit_Fire");
		registerCircuit(circuitWater, "Streaming Circuit", "Circuit_Water");

		registerCircuit(advancedCircuit, "Advanced Circuit Board", "Circuit_Advanced");
		registerCircuit(advancedCircuitIce, "Chilling Circuit", "Circuit_Advanced_Ice");
		registerCircuit(advancedCircuitLava, "Blazing Circuit", "Circuit_Advanced_Lava");
		registerCircuit(advancedCircuitLife, "Mending Circuit", "Circuit_Advanced_Life");
		registerCircuit(advancedCircuitLightning, "Thundering Circuit", "Circuit_Advanced_Lightning");

		/*
		 * ITems
		 */
		registerItem(solderingIron, "Soldering Iron", "Soldering_Iron");
		registerItem(basicBattery, "Basic Battery", "Battery_Basic");

		registerItem(leadWire, "Lead Wire", "Lead_Wire");


		
		registerItem(manual, "Electricians Manual", "Electricians_Manual");
		
		registerItem(modularAmulet, "Modular Amulet", "Amulet_Empty");
		registerItem(modularBelt, "Modular Belt", "Belt_Empty");
		registerItem(modularRing, "Modular Ring", "Ring_Blank");
		
		
	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);
	}

	private static void registerCircuit(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);
	}
	
	private static void registerNBT(){
		NBTHelper.setString(new ItemStack(circuit), "ETEffect", "empty");
		NBTHelper.setString(new ItemStack(circuitAir), "ETEffect", "air");
		NBTHelper.setString(new ItemStack(circuitEarth), "ETEffect", "earth");
		NBTHelper.setString(new ItemStack(circuitFire), "ETEffect", "fire");
		NBTHelper.setString(new ItemStack(circuitWater), "ETEffect", "water");
		
		NBTHelper.setString(new ItemStack(advancedCircuit), "ETEffect", "advancedEmpty");
		NBTHelper.setString(new ItemStack(advancedCircuitIce), "ETEffect", "advancedIce");
		NBTHelper.setString(new ItemStack(advancedCircuitLava), "ETEffect", "advancedLava");
		NBTHelper.setString(new ItemStack(advancedCircuitLife), "ETEffect", "advancedLife");
		NBTHelper.setString(new ItemStack(advancedCircuitLightning), "ETEffect", "advancedLightning");
		
		
	}
	


}
