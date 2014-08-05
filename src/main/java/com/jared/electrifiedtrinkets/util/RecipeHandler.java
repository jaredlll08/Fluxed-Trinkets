package com.jared.electrifiedtrinkets.util;

import com.jared.electrifiedtrinkets.blocks.ETBlocks;
import com.jared.electrifiedtrinkets.items.ETItems;

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
		OreDictionary.registerOre("ingotCopper", ETItems.copperIngot);
		OreDictionary.registerOre("ingotLead", ETItems.leadIngot);
		OreDictionary.registerOre("wireLead", ETItems.leadWire);
		OreDictionary.registerOre("nuggetCopper", ETItems.copperNugget);

	}

	private static void registerRecipes() {

		GameRegistry.addRecipe(new ItemStack(ETItems.circuit), new Object[] { " g ", "gbg", " g ", 'g', new ItemStack(Items.dye, 1, 2), 'b', new ItemStack(Items.book) });
		GameRegistry.addRecipe(new ItemStack(ETItems.advancedCircuit), new Object[] { " g ", "gbg", " g ", 'g', new ItemStack(Items.dye, 1, 4), 'b', new ItemStack(Items.book) });

		GameRegistry.addSmelting(ETBlocks.copperOre, new ItemStack(ETItems.copperIngot), 0.5F);
		GameRegistry.addSmelting(ETBlocks.leadOre, new ItemStack(ETItems.leadIngot), 0.5F);

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.copperNugget, 9), new Object[] { "c", 'c', "ingotCopper" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.leadWire, 6), new Object[] { "   ", "lll", "   ", 'l', "ingotLead" }));

	}

}
