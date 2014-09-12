package com.jared.fluxedtrinkets.blocks;

import net.minecraft.block.Block;

import com.jared.fluxedtrinkets.ModInfo;
import com.jared.fluxedtrinkets.items.FTItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class FTBlocks {
	
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
		block.setBlockName(name).setBlockTextureName(ModInfo.modid + ":" + key).setCreativeTab(FTItems.tab);
		GameRegistry.registerBlock(block, key);
	}

}
