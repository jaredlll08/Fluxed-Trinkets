package com.jared.electrifiedtrinkets.blocks.resources;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCopperOre extends Block{

	public BlockCopperOre() {
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(1.5F);
	}

	
}
