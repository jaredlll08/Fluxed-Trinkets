package com.jared.electrifiedtrinkets.util;

import com.jared.electrifiedtrinkets.blocks.ETBlocks;
import com.jared.electrifiedtrinkets.items.ETItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

	public static void init() {

		registerOreDict();
		registerRecipes();

	}

	private static void registerOreDict() {
		OreDictionary.registerOre("wireLead", ETItems.leadWire);
		OreDictionary.registerOre("circuit", ETItems.circuit);
		OreDictionary.registerOre("circuitAdvanced", ETItems.advancedCircuit);

	}

	private static void registerRecipes() {

		// GameRegistry.addRecipe(new ItemStack(ETBlocks.solderingStation), new
		// Object[] { "lgl", "gbg", "lgl", 'l', new ItemStack(Items.emerald),
		// 'g', new ItemStack(Items.diamond), 'b', new
		// ItemStack(Blocks.crafting_table) });
		GameRegistry.addRecipe(new ShapedOreRecipe(ETBlocks.solderingStation, new Object[] { "gcg", "ili", "i i", 'l', "wireLead", 'g', "gearInvar", 'c', new ItemStack(Blocks.crafting_table), 'i', "ingotInvar" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.leadWire, 6), new Object[] { "   ", "lll", "   ", 'l', "ingotLead" }));

		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.speedBelt), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.speedCircuit), new ItemStack(ETItems.beltEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.beltJump), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.jumpCircuit), new ItemStack(ETItems.beltEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.beltStep), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.circtuitStep), new ItemStack(ETItems.beltEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.beltFire), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.circuitAdvancedFire), new ItemStack(ETItems.beltEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.beltIce), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.circuitAdvancedWater), new ItemStack(ETItems.beltEmpty));

		GameRegistry.addRecipe(new ItemStack(ETItems.beltEmpty), new Object[] { "iii", "i i", "iii", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ETItems.ringEmpty), new Object[] { " i ", "i i", " i ", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ETItems.amuletEmpty), new Object[] { " bb", "ibb", "ii ", 'i', new ItemStack(Items.iron_ingot), 'b', new ItemStack(Blocks.iron_bars) });

		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.amuletRespiratory), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.circuitAdvancedWater), new ItemStack(ETItems.amuletEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.ringMiningSpeed), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.speedCircuit), new ItemStack(ETItems.ringEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.ringFarming), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.basicBattery), new ItemStack(ETItems.circuitAdvancedWater), new ItemStack(ETItems.speedCircuit), new ItemStack(ETItems.ringEmpty));

		// GameRegistry.addRecipe(new ItemStack(ETItems.solderingIron), new
		// Object[] { " cc", " ic", "i  ", 'i', new ItemStack(Items.iron_ingot),
		// 'c', new ItemStack(Items.clay_ball) });

		GameRegistry.addRecipe(new ItemStack(ETItems.circuit), new Object[] { "ege", "gbg", "ege", 'e', new ItemStack(Items.emerald), 'g', new ItemStack(Items.dye, 1, 2), 'b', new ItemStack(Items.book) });
		GameRegistry.addRecipe(new ItemStack(ETItems.advancedCircuit), new Object[] { "lgl", "gbg", "lgl", 'l', new ItemStack(Blocks.redstone_block), 'g', new ItemStack(Items.paper), 'b', new ItemStack(ETItems.circuit) });

		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.solderingIron, new Object[] { " ic", " li", "b  ", 'l', "wireLead", 'c', "ingotCopper", 'i', "nuggetIron", 'b', ETItems.basicBattery }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.basicBattery, new Object[] { " w ", "lrl", "lsl", 'w', "wireLead", 'l', "ingotLead", 'r', Items.redstone, 's', "dustSulfur" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.circuit, new Object[] { "sws", "ccc", "ooo", 's', "dustSulphur", 'w', Items.water_bucket, 'c', "dustCopper", 'o', "dustObsidian" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.advancedCircuit, new Object[] { "rsr", "scs", "rsr", 's', "nuggetSignalum", 'r', Items.redstone, 'c', ETItems.circuit }));

		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.beltEmpty, new Object[] { "ewe", "wbw", "ewe", 'e', "ingotElectrum", 'w', "wireLead", 'b', ETItems.basicBattery }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ETItems.speedBelt, new Object[] { "gearElectrum", ETItems.beltEmpty, ETItems.speedCircuit }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ETItems.beltFire, new Object[] { "gearSignalum", ETItems.beltEmpty, ETItems.circuitAdvancedFire }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ETItems.beltIce, new Object[] { "gearElectrum", ETItems.beltEmpty, ETItems.circuitAdvancedWater }));
		

	}

}
