package fluxedtrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class BlockMachineCube extends Block {

	protected BlockMachineCube() {
		super(Material.iron);
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return false;
	}
}
