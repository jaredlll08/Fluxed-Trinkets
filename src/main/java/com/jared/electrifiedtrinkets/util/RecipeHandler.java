package com.jared.electrifiedtrinkets.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.jared.electrifiedtrinkets.blocks.ETBlocks;
import com.jared.electrifiedtrinkets.items.ETItems;

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

		GameRegistry.addRecipe(new ShapedOreRecipe(ETBlocks.solderingStation, new Object[] { "gcg", "ili", "i i", 'l', "wireLead", 'g', "gearInvar", 'c', new ItemStack(Blocks.crafting_table), 'i', "ingotInvar" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.leadWire, 6), new Object[] { "   ", "lll", "   ", 'l', "ingotLead" }));

		GameRegistry.addRecipe(new ItemStack(ETItems.modularBelt), new Object[] { "iii", "i i", "iii", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ETItems.modularRing), new Object[] { " i ", "i i", " i ", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ETItems.modularAmulet), new Object[] { " bb", "ibb", "ii ", 'i', new ItemStack(Items.iron_ingot), 'b', new ItemStack(Blocks.iron_bars) });

		GameRegistry.addRecipe(new ItemStack(ETItems.circuit), new Object[] { "ege", "gbg", "ege", 'e', new ItemStack(Items.emerald), 'g', new ItemStack(Items.dye, 1, 2), 'b', new ItemStack(Items.book) });
		GameRegistry.addRecipe(new ItemStack(ETItems.advancedCircuit), new Object[] { "lgl", "gbg", "lgl", 'l', new ItemStack(Blocks.redstone_block), 'g', new ItemStack(Items.paper), 'b', new ItemStack(ETItems.circuit) });

		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.solderingIron, new Object[] { " ic", " li", "b  ", 'l', "wireLead", 'c', "ingotCopper", 'i', "nuggetIron", 'b', ETItems.basicBattery }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.basicBattery, new Object[] { " w ", "lrl", "lsl", 'w', "wireLead", 'l', "ingotLead", 'r', Items.redstone, 's', "dustSulfur" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.circuit, new Object[] { "sws", "ccc", "ooo", 's', "dustSulphur", 'w', Items.water_bucket, 'c', "dustCopper", 'o', "dustObsidian" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ETItems.advancedCircuit, new Object[] { "rsr", "scs", "rsr", 's', "nuggetSignalum", 'r', Items.redstone, 'c', ETItems.circuit }));

		GameRegistry.addShapelessRecipe(new ItemStack(ETItems.manual), new ItemStack(ETItems.basicBattery), new ItemStack(Items.book));

	}

}
