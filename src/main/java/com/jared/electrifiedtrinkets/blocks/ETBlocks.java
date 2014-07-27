package com.jared.electrifiedtrinkets.blocks;

import com.jared.electrifiedtrinkets.CreativeTabElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.items.ETItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ETBlocks {
	
	public static void init(){
		Block solderingStation = new BlockSolderingStation();
		solderingStation.setCreativeTab(ETItems.tab);
		GameRegistry.registerBlock(solderingStation, "Soldering_Station");
		
	}

}
