package fluxedtrinkets.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import fluxedtrinkets.FluxedTrinkets;
import fluxedtrinkets.client.gui.ContainerHeatGenerator;
import fluxedtrinkets.client.gui.ContainerSolderingStation;
import fluxedtrinkets.client.gui.ContainerTrinketAssembler;
import fluxedtrinkets.client.gui.GuiHeatGenerator;
import fluxedtrinkets.client.gui.GuiSolderingStationCircuit;
import fluxedtrinkets.client.gui.GuiTrinketAssembler;
import fluxedtrinkets.tileEntity.TileEntityHeatGenerator;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(FluxedTrinkets.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {

		case 0:
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntitySolderingStation) {
				return new ContainerSolderingStation(player.inventory, (TileEntitySolderingStation) te);
			}
			break;

		case 1:
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile != null && tile instanceof TileEntityTrinketAssembler) {
				return new ContainerTrinketAssembler(player.inventory, (TileEntityTrinketAssembler) tile);
			}
			break;

		case 2:
			TileEntity tec = world.getTileEntity(x, y, z);
			if (tec != null && tec instanceof TileEntityHeatGenerator) {
				return new ContainerHeatGenerator(player.inventory, (TileEntityHeatGenerator) tec);
			}
			break;

		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntitySolderingStation) {
				return new GuiSolderingStationCircuit(player.inventory, (TileEntitySolderingStation) te);
			}

			break;
		case 1:
			TileEntity tile = world.getTileEntity(x, y, z);
			if (tile != null && tile instanceof TileEntityTrinketAssembler) {
				return new GuiTrinketAssembler(player.inventory, (TileEntityTrinketAssembler) tile);
			}
			break;

		case 2:
			TileEntity tec = world.getTileEntity(x, y, z);
			if (tec != null && tec instanceof TileEntityHeatGenerator) {
				return new GuiHeatGenerator(player.inventory, (TileEntityHeatGenerator) tec);
			}
			break;
		}

		return null;
	}
}
