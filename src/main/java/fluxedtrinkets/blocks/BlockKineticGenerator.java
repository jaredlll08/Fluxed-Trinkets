package fluxedtrinkets.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.network.MessageEnergyUpdate;
import fluxedtrinkets.network.PacketHandler;
import fluxedtrinkets.tileEntity.TileEntityKineticGenerator;

public class BlockKineticGenerator extends Block implements ITileEntityProvider {
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	@SideOnly(Side.CLIENT)
	private IIcon side;

	protected BlockKineticGenerator() {
		super(Material.iron);
	}

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		TileEntityKineticGenerator tile = (TileEntityKineticGenerator) world.getTileEntity(x, y, z);
		if (entity instanceof EntityPlayer) {
			if (!world.isRemote) {
				int energy = new Random().nextInt(50);
				tile.generateEnergy(energy);
			}

		}

	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityKineticGenerator();
	}

	public void registerBlockIcons(IIconRegister icon) {
		top = icon.registerIcon(ModInfo.modid + ":KineticGenerator_Top");
//		bottom = icon.registerIcon(ModInfo.modid + ":Machine_Bottom");
		side = icon.registerIcon(ModInfo.modid + ":Machine_Side");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if (side == 1) {
			return top;
		} else {
			return this.side;
		}
	}
}
