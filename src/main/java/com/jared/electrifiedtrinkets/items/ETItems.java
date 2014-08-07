package com.jared.electrifiedtrinkets.items;

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
import com.jared.electrifiedtrinkets.items.equipment.ItemAmuletEmpty;
import com.jared.electrifiedtrinkets.items.equipment.ItemAmuletRespiratory;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltEmpty;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltFire;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltIce;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltJump;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltSpeed;
import com.jared.electrifiedtrinkets.items.equipment.ItemBeltStep;
import com.jared.electrifiedtrinkets.items.resources.ItemCopperIngot;
import com.jared.electrifiedtrinkets.items.resources.ItemCopperNugget;
import com.jared.electrifiedtrinkets.items.resources.ItemLeadIngot;
import com.jared.electrifiedtrinkets.items.resources.ItemLeadWire;

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

	public static Item speedBelt = new ItemBeltSpeed(25000, 10);
	public static Item beltEmpty = new ItemBeltEmpty();
	public static Item beltFire = new ItemBeltFire(10000, 10);
	public static Item beltIce = new ItemBeltIce(35000, 5);
	public static Item beltJump = new ItemBeltJump(20000, 20);
	public static Item beltStep	= new ItemBeltStep(10000, 20);
	
	public static Item amuletEmpty = new ItemAmuletEmpty();
	public static Item amuletRespiratory = new ItemAmuletRespiratory(25000, 5);

	public static ItemStack[] addons = new ItemStack[9];

	private static void registerItems() {
		addons[0] = new ItemStack(Items.sugar, 1, OreDictionary.WILDCARD_VALUE);
		addons[1] = new ItemStack(Items.feather, 1, OreDictionary.WILDCARD_VALUE);
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
		registerItem(beltEmpty, "Empty Belt", "Belt_Empty");
		registerItem(amuletEmpty, "Empty Amulet", "Amulet_Empty");
		registerItem(amuletRespiratory, "Respiratory Amulet", "Amulet_Respiratory");
		registerItem(beltFire, "Fire Belt", "Belt_Fire");
		registerItem(beltIce, "Ice Belt", "Belt_Ice");
		registerItem(beltJump, "Jumping Belt", "Belt_Jump");
		registerItem(beltStep, "Stepping Belt", "Belt_Step");
	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);

	}

}
