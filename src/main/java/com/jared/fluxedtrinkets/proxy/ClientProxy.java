package com.jared.fluxedtrinkets.proxy;

import net.minecraft.client.Minecraft;

import com.jared.fluxedtrinkets.client.render.block.RenderSolderingStation;
import com.jared.fluxedtrinkets.client.render.block.RenderTrinketAssembler;
import com.jared.fluxedtrinkets.client.render.gui.GuiEManual;
import com.jared.fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import com.jared.fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;
import com.jared.fluxedtrinkets.tileEntity.TileEntityWirelessCharger;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	public static int solderingStationID = RenderingRegistry.getNextAvailableRenderId();
	public static int trinketAssemblerID = RenderingRegistry.getNextAvailableRenderId();
	

	@Override
	public void registerRenderers() {


		RenderSolderingStation solderingStation = new RenderSolderingStation();
		RenderTrinketAssembler trinketAssembler = new RenderTrinketAssembler();
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolderingStation.class, solderingStation);
		ClientRegistry.registerTileEntity(TileEntitySolderingStation.class, "solderingStation", solderingStation);
		ClientRegistry.registerTileEntity(TileEntityTrinketAssembler.class, "trinketAssembler", trinketAssembler);
		}
	
	public static void openManual() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiEManual());
	}
}
