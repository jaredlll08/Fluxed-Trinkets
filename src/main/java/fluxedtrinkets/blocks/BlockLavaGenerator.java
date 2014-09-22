package fluxedtrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import fluxedtrinkets.tileEntity.TileEntityLavaGenerator;

public class BlockLavaGenerator extends Block implements ITileEntityProvider {

	protected BlockLavaGenerator() {
		super(Material.rock);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		TileEntityLavaGenerator tile = (TileEntityLavaGenerator) world.getTileEntity(x, y, z);
		if (entity instanceof EntityPlayer) {
				tile.player = (EntityPlayer) entity;
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntityLavaGenerator tile = (TileEntityLavaGenerator) world.getTileEntity(x, y, z);
		if (!world.isRemote) {
			tile.player = player;
			tile.generateLava();
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityLavaGenerator();
	}

	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}

}
