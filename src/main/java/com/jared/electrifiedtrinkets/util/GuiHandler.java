package com.jared.electrifiedtrinkets.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.jared.electrifiedtrinkets.ElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.client.render.gui.ContainerSolderingStation;
import com.jared.electrifiedtrinkets.client.render.gui.ContainerTrinketAssembler;
import com.jared.electrifiedtrinkets.client.render.gui.GuiEManual;
import com.jared.electrifiedtrinkets.client.render.gui.GuiSolderingStationCircuit;
import com.jared.electrifiedtrinkets.client.render.gui.GuiTrinketAssembler;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityTrinketAssembler;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler {
	
	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ElectrifiedTrinkets.instance, this);
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
		}

		return null;
	}
}
