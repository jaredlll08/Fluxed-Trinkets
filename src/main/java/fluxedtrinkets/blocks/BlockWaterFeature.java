package fluxedtrinkets.blocks;

import fluxedtrinkets.tileEntity.TileEntityWaterFeature;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWaterFeature extends Block implements ITileEntityProvider {


	public BlockWaterFeature() {
		super(Material.anvil);
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return new TileEntityWaterFeature();
	}

}
