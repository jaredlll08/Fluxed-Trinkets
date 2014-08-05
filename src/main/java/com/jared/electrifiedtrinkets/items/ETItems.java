package com.jared.electrifiedtrinkets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.jared.electrifiedtrinkets.CreativeTabElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.circuits.ItemCircuit;
import com.jared.electrifiedtrinkets.items.circuits.ItemJumpCircuit;
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

	public static Item speedCircuit = new ItemSpeedCircuit();
	public static Item circuit = new ItemCircuit();
	public static Item jumpCircuit = new ItemJumpCircuit();

	public static Item advancedCircuit = new ItemCircuit();
	public static Item basicBattery = new ItemBattery();

	public static Item solderingIron = new ItemSolderingIron();

	public static Item copperIngot = new ItemCopperIngot();
	public static Item copperNugget = new ItemCopperNugget();

	public static Item leadIngot = new ItemLeadIngot();
	public static Item leadWire = new ItemLeadWire();

	public static Item speedBelt = new ItemSpeedBelt(25000);

	public static ItemStack[] addons = new ItemStack[9];

	private static void registerItems() {
		addons[0] = new ItemStack(Items.sugar, 1, OreDictionary.WILDCARD_VALUE);
		addons[1] = new ItemStack(Items.firework_charge, 1, OreDictionary.WILDCARD_VALUE);
		addons[2] = new ItemStack(Items.slime_ball, 1, OreDictionary.WILDCARD_VALUE);
		addons[3] = new ItemStack(Items.magma_cream, 1, OreDictionary.WILDCARD_VALUE);
		addons[4] = new ItemStack(Items.blaze_powder, 1, OreDictionary.WILDCARD_VALUE);
		addons[5] = new ItemStack(Items.fish, 1, OreDictionary.WILDCARD_VALUE);
		addons[6] = new ItemStack(Items.fishing_rod, 1, OreDictionary.WILDCARD_VALUE);
		addons[7] = new ItemStack(Items.clay_ball, 1, OreDictionary.WILDCARD_VALUE);
		addons[8] = new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE);

		registerItem(speedCircuit, "Speed Circuit", "Circuit_Speed");
		registerItem(jumpCircuit, "Jumping Circuit", "Circuit_Jump");
		registerItem(circuit, "Empty Circuit", "Circuit");
		registerItem(advancedCircuit, "Advanced Circuit Board", "Circuit_Advanced");
		registerItem(basicBattery, "Basic Battery", "Battery_Basic");
		registerItem(solderingIron, "Soldering Iron", "Soldering_Iron");

		registerItem(copperIngot, "Copper Ingot", "Copper_Ingot");
		registerItem(copperNugget, "Copper Nugget", "Copper_Nugget");

		registerItem(leadIngot, "Lead Ingot", "Lead_Ingot");
		registerItem(leadWire, "Lead Wire", "Lead_Wire");

		registerItem(speedBelt, "Speed Belt", "Belt_Speed");
	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);

	}

}
