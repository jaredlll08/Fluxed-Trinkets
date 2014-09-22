package fluxedtrinkets.blocks;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fluxedtrinkets.FluxedTrinkets;
import fluxedtrinkets.proxy.ClientProxy;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class BlockSolderingStation extends BlockContainer {
	TileEntitySolderingStation tile;

	protected BlockSolderingStation() {
		super(Material.iron);
		this.setBlockBounds(0, 0, 0, 1, 0.62F, 1);
		this.setHardness(1.0F);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float par7, float par8, float par9) {
		tile = (TileEntitySolderingStation) world.getTileEntity(x, y, z);
		player.openGui(FluxedTrinkets.instance, 0, world, x, y, z);

		return true;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.solderingStationID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TileEntitySolderingStation();
	}

	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {

		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(this));
		if (tile != null) {
			for (int i = 0; i < tile.getSizeInventory(); i++) {
				if (tile.getStackInSlot(i) != null)
					items.add(tile.getStackInSlot(i));
			}
		}
		return items;
	}
}
