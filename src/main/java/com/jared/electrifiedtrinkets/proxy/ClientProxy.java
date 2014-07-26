package com.jared.electrifiedtrinkets.proxy;

import com.jared.electrifiedtrinkets.client.render.block.RenderSolderingStation;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public static int solderingStationID = RenderingRegistry.getNextAvailableRenderId();

	@Override
	public void registerRenderers() {


		RenderSolderingStation solderingStation = new RenderSolderingStation();
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolderingStation.class, solderingStation);
		ClientRegistry.registerTileEntity(TileEntitySolderingStation.class, "solderingStation", solderingStation);
	}
}
