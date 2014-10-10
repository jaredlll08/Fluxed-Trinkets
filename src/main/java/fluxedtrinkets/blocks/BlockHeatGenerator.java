package fluxedtrinkets.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fluxedtrinkets.FluxedTrinkets;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.tileEntity.TileEntityHeatGenerator;

public class BlockHeatGenerator extends BlockContainer {

	TileEntityHeatGenerator tile;

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;

	protected BlockHeatGenerator() {
		super(Material.anvil);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float par7, float par8, float par9) {
		tile = (TileEntityHeatGenerator) world.getTileEntity(x, y, z);
		player.openGui(FluxedTrinkets.instance, 2, world, x, y, z);
		return true;
	}


	public void registerBlockIcons(IIconRegister icon) {
		top = icon.registerIcon(ModInfo.modid + ":Machine_Cube");
		side = icon.registerIcon(ModInfo.modid + ":Heat_Generator");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		if (side == 0) {
			return top;
		} else if (side == 1) {
			return top;
		} else {
			return this.side;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHeatGenerator();
	}

}
