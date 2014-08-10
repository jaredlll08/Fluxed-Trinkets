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
		OreDictionary.registerOre("ingotCopper", ETItems.copperIngot);
		OreDictionary.registerOre("ingotLead", ETItems.leadIngot);
		OreDictionary.registerOre("wireLead", ETItems.leadWire);
		OreDictionary.registerOre("nuggetCopper", ETItems.copperNugget);
	}

	private static void registerRecipes() {

		GameRegistry.addRecipe(new ItemStack(ETItems.circuit), new Object[] { "ege", "gbg", "ege", 'e', new ItemStack(Items.emerald), 'g', new ItemStack(Items.dye, 1, 2), 'b', new ItemStack(Items.book) });
		GameRegistry.addRecipe(new ItemStack(ETItems.advancedCircuit), new Object[] { "lgl", "gbg", "lgl", 'l', new ItemStack(Blocks.lapis_block), 'g', new ItemStack(Items.paper), 'b', new ItemStack(ETItems.circuit) });

		GameRegistry.addRecipe(new ItemStack(ETBlocks.solderingStation), new Object[] { "lgl", "gbg", "lgl", 'l', new ItemStack(Items.emerald), 'g', new ItemStack(Items.diamond), 'b', new ItemStack(Blocks.crafting_table) });

		GameRegistry.addSmelting(ETBlocks.copperOre, new ItemStack(ETItems.copperIngot), 0.5F);
		GameRegistry.addSmelting(ETBlocks.leadOre, new ItemStack(ETItems.leadIngot), 0.5F);

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.copperNugget, 9), new Object[] { "c", 'c', "ingotCopper" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.leadWire, 6), new Object[] { "   ", "lll", "   ", 'l', "ingotLead" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ETItems.basicBattery), new Object[] { "ccc", "rrr", "rrr", 'c', "ingotCopper", 'r', new ItemStack(Items.redstone) }));

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

		GameRegistry.addRecipe(new ItemStack(ETItems.solderingIron), new Object[] { " cc", " ic", "i  ", 'i', new ItemStack(Items.iron_ingot), 'c', new ItemStack(Items.clay_ball) });

	}

}
