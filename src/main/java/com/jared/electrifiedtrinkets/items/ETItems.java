package com.jared.electrifiedtrinkets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.circuits.ItemCircuit;
import com.jared.electrifiedtrinkets.items.circuits.ItemSpeedCircuit;
import com.jared.electrifiedtrinkets.util.NBTHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class ETItems {

	public static void init() {
		registerItems();
		registerRecipes();
	}

	public static Item kineticEnergyBelt = new ItemKineticEnergyBelt();
	public static Item speedCircuit = new ItemSpeedCircuit();
	public static Item circuit = new ItemCircuit();
	public static Item advancedCircuit = new ItemCircuit();

	public static Item basicBattery = new ItemBattery();

	public static Item solderingIron = new ItemSolderingIron();

	private static void registerItems() {
		registerItem(kineticEnergyBelt, "Kinetic Energy Belt", "Kinetic_Energy_Belt_Empty");
		registerItem(speedCircuit, "Speed Circuit", "Speed_Circuit");
		registerItem(circuit, "Empty Circuit", "Circuit");
		registerItem(advancedCircuit, "Advanced Circuit Board", "Advanced_Circuit_Board");
		registerItem(basicBattery, "Basic Battery", "Basic_Battery");
		registerItem(solderingIron, "Soldering Iron", "Soldering_Iron");
	}

	private static void registerRecipes() {
		ItemStack kineticBeltBattery = new ItemStack(kineticEnergyBelt);
		ItemStack kineticBeltSpeed = new ItemStack(kineticEnergyBelt);
		NBTHelper.setBoolean(kineticBeltBattery, "Battery", true);
		NBTHelper.setBoolean(kineticBeltBattery, "Speed", true);
		
		NBTHelper.setBoolean(kineticBeltSpeed, "Speed", true);
		

		GameRegistry.addRecipe(kineticBeltSpeed, new Object[] { "c", "k", 'c', new ItemStack(speedCircuit), 'k', new ItemStack(kineticEnergyBelt) });
		GameRegistry.addRecipe(kineticBeltBattery, new Object[] { "c", "k", 'c', new ItemStack(basicBattery), 'k', kineticBeltSpeed });

		GameRegistry.addRecipe(new ItemStack(circuit), new Object[] { " g ", "gbg", " g ", 'g', new ItemStack(Items.dye, 1, 2), 'b', new ItemStack(Items.book) });
		GameRegistry.addRecipe(new ItemStack(advancedCircuit), new Object[] { " g ", "gbg", " g ", 'g', new ItemStack(Items.dye, 1, 4), 'b', new ItemStack(Items.book) });

	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerItem(item, key);

	}

}
