package com.jared.electrifiedtrinkets.blocks;

import net.minecraft.block.Block;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.ETItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ETBlocks {
	
	public static void init(){
		registerBlocks();
	}
	
	public static Block solderingStation = new BlockSolderingStation();
	public static Block trinketAssembler = new BlockTrinketAssembler();
	
	
	private static void registerBlocks() {
		registerBlock(solderingStation, "Soldering Station", "Soldering_Station");
		registerBlock(trinketAssembler, "Trinket Assembler", "Trinket_Assembler");
	}

	private static void registerBlock(Block block, String name, String key) {
		block.setBlockName(name).setBlockTextureName(ModInfo.modid + ":" + key).setCreativeTab(ETItems.tab);
		GameRegistry.registerBlock(block, key);
	}

}
