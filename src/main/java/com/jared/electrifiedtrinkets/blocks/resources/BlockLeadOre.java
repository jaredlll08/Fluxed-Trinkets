package com.jared.electrifiedtrinkets.blocks.resources;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLeadOre extends Block{

	public BlockLeadOre() {
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(1.5F);
	}

	
}
