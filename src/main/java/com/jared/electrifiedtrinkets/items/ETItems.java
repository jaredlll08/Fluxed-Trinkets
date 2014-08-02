package com.jared.electrifiedtrinkets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.CreativeTabElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.circuits.ItemCircuit;
import com.jared.electrifiedtrinkets.items.circuits.ItemSpeedCircuit;
import com.jared.electrifiedtrinkets.items.equipment.ItemSpeedBelt;
import com.jared.electrifiedtrinkets.items.resources.ItemBundleOfLeadWire;
import com.jared.electrifiedtrinkets.items.resources.ItemCopperIngot;
import com.jared.electrifiedtrinkets.items.resources.ItemCopperNugget;
import com.jared.electrifiedtrinkets.items.resources.ItemLeadIngot;
import com.jared.electrifiedtrinkets.items.resources.ItemLeadWire;
import com.jared.electrifiedtrinkets.util.NBTHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class ETItems {

	public static void init() {
		registerItems();
	}

	public static CreativeTabElectrifiedTrinkets tab = new CreativeTabElectrifiedTrinkets();

	public static Item kineticEnergyBelt = new ItemKineticEnergyBelt();
	public static Item speedCircuit = new ItemSpeedCircuit();
	public static Item circuit = new ItemCircuit();
	public static Item advancedCircuit = new ItemCircuit();

	public static Item basicBattery = new ItemBattery();

	public static Item solderingIron = new ItemSolderingIron();

	public static Item copperIngot = new ItemCopperIngot();
	public static Item copperNugget = new ItemCopperNugget();

	public static Item leadIngot = new ItemLeadIngot();
	public static Item leadWire = new ItemLeadWire();

	public static Item speedBelt = new ItemSpeedBelt(25000);

	private static void registerItems() {
		registerItem(kineticEnergyBelt, "Kinetic Energy Belt", "Kinetic_Energy_Belt_Empty");
		registerItem(speedCircuit, "Speed Circuit", "Speed_Circuit");
		registerItem(circuit, "Empty Circuit", "Circuit");
		registerItem(advancedCircuit, "Advanced Circuit Board", "Advanced_Circuit_Board");
		registerItem(basicBattery, "Basic Battery", "Basic_Battery");
		registerItem(solderingIron, "Soldering Iron", "Soldering_Iron");

		registerItem(copperIngot, "Copper Ingot", "Copper_Ingot");
		registerItem(copperNugget, "Copper Nugget", "Copper_Nugget");

		registerItem(leadIngot, "Lead Ingot", "Lead_Ingot");
		registerItem(leadWire, "Lead Wire", "Lead_Wire");
		
		registerItem(speedBelt, "Speed Belt", "Speed_Belt");
	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);

	}

}
