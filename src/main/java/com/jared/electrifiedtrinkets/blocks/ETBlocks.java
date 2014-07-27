package com.jared.electrifiedtrinkets.blocks;

import net.minecraft.block.Block;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.blocks.resources.BlockCopperOre;
import com.jared.electrifiedtrinkets.blocks.resources.BlockLeadOre;
import com.jared.electrifiedtrinkets.items.ETItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ETBlocks {
	
	public static void init(){
		registerBlocks();
	}
	
	public static Block solderingStation = new BlockSolderingStation();
	public static Block copperOre = new BlockCopperOre();
	public static Block leadOre = new BlockLeadOre();
	
	private static void registerBlocks() {
		registerBlock(solderingStation, "Soldering Station", "Soldering_Station");
		registerBlock(copperOre, "Copper Ore", "Copper_Ore");
		registerBlock(leadOre, "Lead Ore", "Lead_Ore");
	}

	private static void registerBlock(Block block, String name, String key) {
		block.setBlockName(name).setBlockTextureName(ModInfo.modid + ":" + key).setCreativeTab(ETItems.tab);
		GameRegistry.registerBlock(block, key);
	}

}
