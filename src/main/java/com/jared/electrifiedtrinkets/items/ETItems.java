package com.jared.electrifiedtrinkets.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.jared.electrifiedtrinkets.CreativeTabElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.equipment.ItemAmuletEmpty;
import com.jared.electrifiedtrinkets.items.equipment.ItemAmuletRespiratory;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltEmpty;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltFire;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltIce;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltJump;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltSpeed;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltStep;
import com.jared.electrifiedtrinkets.items.equipment.ItemRingEmpty;
import com.jared.electrifiedtrinkets.items.equipment.ItemRingFarming;
import com.jared.electrifiedtrinkets.items.equipment.ItemRingMiningSpeed;
import com.jared.electrifiedtrinkets.items.resources.ItemLeadWire;

import cpw.mods.fml.common.registry.GameRegistry;

public class ETItems {

	public static void init() {
		registerItems();
	}

	public static CreativeTabElectrifiedTrinkets tab = new CreativeTabElectrifiedTrinkets();

	/*
	 * circuits
	 */
	public static Item circuit = new ItemCircuit();
	public static Item circuitAir = new ItemCircuit();
	public static Item circuitEarth = new ItemCircuit();
	public static Item circuitFire = new ItemCircuit();
	public static Item circuitWater = new ItemCircuit();

	public static Item advancedCircuit = new ItemCircuit();
	public static Item advancedCircuitIce = new ItemCircuit();
	public static Item advancedCircuitLava = new ItemCircuit();
	public static Item advancedCircuitLife = new ItemCircuit();
	public static Item advancedCircuitLightning = new ItemCircuit();

	/*
	 * items
	 */
	public static Item speedCircuit = new ItemCircuit();

	public static Item jumpCircuit = new ItemCircuit();

	public static Item circuitAdvancedFire = new ItemCircuit();

	public static Item circuitAdvancedWater = new ItemCircuit();
	public static Item circtuitStep = new ItemCircuit();

	public static Item basicBattery = new ItemBattery();

	public static Item solderingIron = new ItemSolderingIron();

	public static Item leadWire = new ItemLeadWire();

	public static Item speedBelt = new ItemBeltSpeed(25000, 10);
	public static Item beltEmpty = new ItemBeltEmpty();
	public static Item beltFire = new ItemBeltFire(10000, 10);
	public static Item beltIce = new ItemBeltIce(30000, 5);
	public static Item beltJump = new ItemBeltJump(20000, 20);
	public static Item beltStep = new ItemBeltStep(10000, 20);

	public static Item amuletEmpty = new ItemAmuletEmpty();
	public static Item amuletRespiratory = new ItemAmuletRespiratory(25000, 5);

	public static Item ringEmpty = new ItemRingEmpty();
	public static Item ringMiningSpeed = new ItemRingMiningSpeed(25000, 10);
	public static Item ringFarming = new ItemRingFarming(20000, 500);

	public static ItemStack[] addons = new ItemStack[9];

	private static void registerItems() {
		addons[0] = new ItemStack(Items.sugar, 1, OreDictionary.WILDCARD_VALUE);
		addons[1] = new ItemStack(Items.feather, 1, OreDictionary.WILDCARD_VALUE);
		addons[2] = new ItemStack(Items.clay_ball, 1, OreDictionary.WILDCARD_VALUE);
		addons[3] = new ItemStack(Items.blaze_powder, 1, OreDictionary.WILDCARD_VALUE);
		addons[4] = new ItemStack(Items.fish, 1, OreDictionary.WILDCARD_VALUE);

		/*
		 * Circuits
		 */
		registerCircuit(circuitEarth, "Terrestrial Circuit", "Circuit_Earth");
		registerCircuit(circuitAir, "Atomospheric Circuit", "Circuit_Air");
		registerCircuit(circuitFire, "Scorched Circuit", "Circuit_Fire");
		registerCircuit(circuitWater, "Streaming Circuit", "Circuit_Water");
	
		registerCircuit(advancedCircuitIce, "Chilling Circuit", "Circuit_Advanced_Ice");
		registerCircuit(advancedCircuitLava, "Blazing Circuit", "Circuit_Advanced_Lava");
		registerCircuit(advancedCircuitLife, "Mending Circuit", "Circuit_Advanced_Life");
		registerCircuit(advancedCircuitLightning, "Thundering Circuit", "Circuit_Advanced_Lightning");
		
		
		/*
		 * ITems
		 */
		registerItem(solderingIron, "Soldering Iron", "Soldering_Iron");
		registerItem(basicBattery, "Basic Battery", "Battery_Basic");

		registerCircuit(circuit, "Empty Circuit", "Circuit");
		registerCircuit(speedCircuit, "Speed Circuit", "Circuit_Speed");
		registerCircuit(jumpCircuit, "Jumping Circuit", "Circuit_Jump");
		registerCircuit(circtuitStep, "Step Circuit", "Circuit_Step");

		registerCircuit(advancedCircuit, "Advanced Circuit Board", "Circuit_Advanced");
		registerCircuit(circuitAdvancedFire, "Advanced Fire Circuit", "Circuit_Advanced_Fire");
		registerCircuit(circuitAdvancedWater, "Advanced Ice Circuit", "Circuit_Advanced_water");

		registerItem(leadWire, "Lead Wire", "Lead_Wire");

		registerItem(beltEmpty, "Empty Belt", "Belt_Empty");
		registerItem(speedBelt, "Speed Belt", "Belt_Speed");
		registerItem(beltFire, "Fire Belt", "Belt_Fire");
		registerItem(beltIce, "Ice Belt", "Belt_Ice");
		registerItem(beltJump, "Jumping Belt", "Belt_Jump");
		registerItem(beltStep, "Stepping Belt", "Belt_Step");

		registerItem(amuletEmpty, "Empty Amulet", "Amulet_Empty");
		registerItem(amuletRespiratory, "Respiratory Amulet", "Amulet_Respiratory");

		registerItem(ringEmpty, "Empty Ring", "Ring_Blank");
		registerItem(ringMiningSpeed, "Mining Ring", "Ring_Mining_Speed");
		registerItem(ringFarming, "Farmers Ring", "Ring_Farming");
	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);
	}

	private static void registerCircuit(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":/Circuits/" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);
	}

}
