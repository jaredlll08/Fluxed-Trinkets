package com.jared.electrifiedtrinkets.proxy;

import net.minecraft.client.Minecraft;

import com.jared.electrifiedtrinkets.client.render.block.RenderSolderingStation;
import com.jared.electrifiedtrinkets.client.render.block.RenderTrinketAssembler;
import com.jared.electrifiedtrinkets.client.render.gui.GuiEManual;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;
import com.jared.electrifiedtrinkets.tileEntity.TileEntityTrinketAssembler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
