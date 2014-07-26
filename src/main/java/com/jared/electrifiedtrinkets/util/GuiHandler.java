package com.jared.electrifiedtrinkets.util;

import com.jared.electrifiedtrinkets.ElectrifiedTrinkets;
import com.jared.electrifiedtrinkets.client.render.gui.ContainerSolderingStation;
import com.jared.electrifiedtrinkets.client.render.gui.Gui;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

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
					return new ContainerSolderingStation(player.inventory, (TileEntitySolderingStation)te);
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
					return new Gui(player.inventory, (TileEntitySolderingStation)te);
				}
			
				break;
		}


		return null;
	}

}
