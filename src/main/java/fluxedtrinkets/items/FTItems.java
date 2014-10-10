package fluxedtrinkets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import baubles.api.BaubleType;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.CreativeTabFluxedTrinkets;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.items.ingredient.ItemBattery;
import fluxedtrinkets.items.ingredient.ItemLeadWire;
import fluxedtrinkets.items.ingredient.ItemSolderingIron;

public class FTItems {

	public static void init() {
		registerItems();
		registerNBT();
	}

	public static CreativeTabFluxedTrinkets tab = new CreativeTabFluxedTrinkets();

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

	public static Item jadedLungs = new ItemJadedLungs();


	// public static Item silicon = new ItemSilicon();

	/*
	 * items
	 */

	public static Item basicBattery = new ItemBattery();

	public static Item solderingIron = new ItemSolderingIron();

	public static Item leadWire = new ItemLeadWire();

	public static Item manual = new ItemManual();

	public static Item modularBelt = new ModularTrinketItem(25000, BaubleType.BELT);
	public static Item modularAmulet = new ModularTrinketItem(15000, BaubleType.AMULET);
	public static Item modularRing = new ModularTrinketItem(10000, BaubleType.RING);

	private static void registerItems() {
		// FluxedTrinketsAPI.addEffect("empty");
		// FluxedTrinketsAPI.addEffect("water");
		// FluxedTrinketsAPI.addEffect("fire");
		// FluxedTrinketsAPI.addEffect("air");
		// FluxedTrinketsAPI.addEffect("earth");

		/*
		 * Circuits
		 */
		registerCircuit(circuit, "Empty Circuit", "Circuit");
		registerCircuit(circuitEarth, "Terrestrial Circuit", "Circuit_Earth");
		registerCircuit(circuitAir, "Atmospheric Circuit", "Circuit_Air");
		registerCircuit(circuitFire, "Scorched Circuit", "Circuit_Fire");
		registerCircuit(circuitWater, "Streaming Circuit", "Circuit_Water");

		registerItem(jadedLungs, "Jaded's Spare Lungs", "JadedLungs", CreativeTabs.tabMisc);

		registerCircuit(advancedCircuit, "Advanced Circuit Board", "Circuit_Advanced");
		registerCircuit(advancedCircuitIce, "Chilling Circuit", "Circuit_Advanced_Ice");
		registerCircuit(advancedCircuitLava, "Blazing Circuit", "Circuit_Advanced_Lava");
		registerCircuit(advancedCircuitLife, "Mending Circuit", "Circuit_Advanced_Life");
		registerCircuit(advancedCircuitLightning, "Thundering Circuit", "Circuit_Advanced_Lightning");

		/*
		 * Items
		 */
		registerItem(solderingIron, "Soldering Iron", "Soldering_Iron");
		registerItem(basicBattery, "Basic Battery", "Battery_Basic");

		registerItem(leadWire, "Lead Wire", "Lead_Wire");

		registerItem(manual, "Electricians Manual", "Electricians_Manual");

		registerItem(modularAmulet, "Modular Amulet", "Amulet_Empty");
		registerItem(modularBelt, "Modular Belt", "Belt_Empty");
		registerItem(modularRing, "Modular Ring", "Ring_Blank");
		// registerItem(brokenTrinket, "Broken Trinket Metal",
		// "Broken_Trinket");

		// registerItem(silicon, "Silicon", "Silicon");

	}

	private static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);
	}

	private static void registerItem(Item item, String name, String key, CreativeTabs tabs) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tabs);
		GameRegistry.registerItem(item, key);
	}

	private static void registerCircuit(Item item, String name, String key) {
		item.setUnlocalizedName(key).setTextureName(ModInfo.modid + ":" + key).setCreativeTab(tab);
		GameRegistry.registerItem(item, key);
	}

	private static void registerNBT() {

	}

}
