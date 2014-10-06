package fluxedtrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fluxedtrinkets.tileEntity.TileEntityKineticGenerator;

public class BlockKineticGenerator extends Block implements ITileEntityProvider {

	protected BlockKineticGenerator() {
		super(Material.iron);
	}

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		TileEntityKineticGenerator tile = (TileEntityKineticGenerator) world.getTileEntity(x, y, z);
		if (entity instanceof EntityPlayer)
			tile.storage.receiveEnergy(world.rand.nextInt(50), false);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityKineticGenerator();
	}
}
