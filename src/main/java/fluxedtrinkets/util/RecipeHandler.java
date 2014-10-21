package fluxedtrinkets.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.api.SolderingRegistry;
import fluxedtrinkets.api.recipes.SolderingRecipe;
import fluxedtrinkets.blocks.FTBlocks;
import fluxedtrinkets.items.FTItems;

public class RecipeHandler {

	public static void init() {
		registerOreDict();
		registerRecipes();
		registerSolderingRecipes();
	}

	private static void registerSolderingRecipes() {
		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuit), new ItemStack(FTItems.circuitEarth), new ItemStack(Blocks.grass), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.sapling)));
		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuit), new ItemStack(FTItems.circuitAir), new ItemStack(Items.ghast_tear), new ItemStack(Blocks.leaves), new ItemStack(Blocks.deadbush), new ItemStack(Items.feather)));
		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuit), new ItemStack(FTItems.circuitFire), new ItemStack(Items.lava_bucket), new ItemStack(Blocks.coal_block), new ItemStack(Blocks.log), new ItemStack(Items.flint_and_steel)));
		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuit), new ItemStack(FTItems.circuitWater), new ItemStack(Items.water_bucket), new ItemStack(Blocks.ice), new ItemStack(Blocks.waterlily), new ItemStack(Items.dye)));

		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuitWater), new ItemStack(FTItems.advancedCircuitIce), new ItemStack(Blocks.snow), new ItemStack(Items.potionitem, 1, 8200), new ItemStack(Blocks.ice), new ItemStack(Items.cake)));
		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuitEarth), new ItemStack(FTItems.advancedCircuitLife), new ItemStack(Items.speckled_melon), new ItemStack(Items.potionitem, 1, 8197), new ItemStack(Items.potionitem, 1, 8257), new ItemStack(Items.golden_apple)));

		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuitEarth), new ItemStack(FTItems.advancedCircuitLightning), new ItemStack(Items.glowstone_dust), new ItemStack(Items.redstone), new ItemStack(Blocks.iron_bars), new ItemStack(FTItems.advancedCircuitLava)));
		SolderingRegistry.registerRecipe(new SolderingRecipe(new ItemStack(FTItems.circuitFire), new ItemStack(FTItems.advancedCircuitLava), new ItemStack(Items.potionitem, 1, 8195), new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_powder), new ItemStack(Blocks.netherrack)));

	}

	private static void registerOreDict() {
		OreDictionary.registerOre("wireLead", FTItems.leadWire);
		OreDictionary.registerOre("circuit", FTItems.circuit);
		OreDictionary.registerOre("circuitAdvanced", FTItems.advancedCircuit);
	}

	private static void registerRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.solderingStation, new Object[] { "gcg", "ili", "i i", 'l', "wireLead", 'g', "gearInvar", 'c', new ItemStack(Blocks.crafting_table), 'i', "ingotInvar" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.trinketAssembler, new Object[] { "gcg", "ili", "ici", 'l', "wireLead", 'g', "gearInvar", 'c', new ItemStack(Blocks.crafting_table), 'i', "ingotInvar" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FTItems.leadWire, 6), new Object[] { "l  ", "l  ", "l  ", 'l', "ingotLead" }));
		GameRegistry.addRecipe(new ItemStack(FTItems.modularBelt), new Object[] { "iii", "i i", "iii", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(FTItems.modularRing), new Object[] { " i ", "i i", " i ", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(FTItems.modularAmulet), new Object[] { " bb", "ibb", "ii ", 'i', new ItemStack(Items.iron_ingot), 'b', new ItemStack(Blocks.iron_bars) });
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.solderingIron, new Object[] { " ic", " li", "b  ", 'l', "wireLead", 'c', "ingotCopper", 'i', "nuggetIron", 'b', FTItems.basicBattery }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.basicBattery, new Object[] { " w ", "lrl", "lsl", 'w', "wireLead", 'l', "ingotLead", 'r', Items.redstone, 's', "dustSulfur" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.circuit, new Object[] { "sws", "ccc", "ooo", 's', "dustSulfur", 'w', Items.water_bucket, 'c', "dustCopper", 'o', "dustObsidian" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.advancedCircuit, new Object[] { "rsr", "scs", "rsr", 's', "nuggetSignalum", 'r', Items.redstone, 'c', FTItems.circuit }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.machineCube, new Object[] { "iei", "ece", "iei", 'i', "ingotInvar", 'e', "ingotIron", 'c', FTItems.circuit }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.heatGenerator, new Object[] { "iei", "ece", "iei", 'i', FTItems.circuitFire, 'e', Blocks.furnace, 'c', FTBlocks.machineCube }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.kineticGenerator, new Object[] { "iei", "ece", "iei", 'i', FTItems.circuitEarth, 'e', FTItems.circuitAir, 'c', FTBlocks.machineCube }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.ftWrench, new Object[] { "  i", " c ", "i  ", 'i', Items.iron_ingot, 'c', "ingotInvar" }));
		GameRegistry.addShapelessRecipe(new ItemStack(FTItems.manual), new ItemStack(FTItems.basicBattery), new ItemStack(Items.book));

	}

}
