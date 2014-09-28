package fluxedtrinkets.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fluxedtrinkets.FluxedTrinkets;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.tileEntity.TileEntityCompressor;

public class BlockCompressor extends BlockContainer {

	TileEntityCompressor tile;

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	@SideOnly(Side.CLIENT)
	private IIcon side;

	protected BlockCompressor() {
		super(Material.anvil);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float par7, float par8, float par9) {
		tile = (TileEntityCompressor) world.getTileEntity(x, y, z);
		player.openGui(FluxedTrinkets.instance, 2, world, x, y, z);

		return true;
	}

	public void registerBlockIcons(IIconRegister icon) {
		front = icon.registerIcon(ModInfo.modid + ":Machine_Compressor");
		top = icon.registerIcon(ModInfo.modid + ":Machine_Top");
		bottom = icon.registerIcon(ModInfo.modid + ":Machine_Bottom");
		side = icon.registerIcon(ModInfo.modid + ":Machine_Side");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if (side == 0) {
			return bottom;
		} else if (side == 1) {
			return top;
		} else if (side == 2) {
			return front;
		} else {
			return this.side;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityCompressor();
	}

}
