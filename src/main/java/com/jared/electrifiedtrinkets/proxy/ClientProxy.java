package com.jared.electrifiedtrinkets.proxy;

import net.minecraft.client.Minecraft;

import com.jared.electrifiedtrinkets.client.render.block.RenderSolderingStation;
import com.jared.electrifiedtrinkets.client.render.block.RenderTrinketAssembler;
import com.jared.electrifiedtrinkets.client.render.gui.GuiEManual;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityTrinketAssembler;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityWirelessCharger;

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
		GameRegistry.registerTileEntity(TileEntityWirelessCharger.class, "wirelessCharger");
		}
	
	public static void openManual() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiEManual());
	}
}
