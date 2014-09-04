package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.network.MessageCircuitCrafting;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

public class GuiSolderingStationCircuit extends GuiContainer {

	private TileEntitySolderingStation tile;

	public GuiSolderingStationCircuit(InventoryPlayer invPlayer, TileEntitySolderingStation solderingStation) {
		super(new ContainerSolderingStation(invPlayer, solderingStation));

		xSize = 230;
		ySize = 219;
		this.tile = solderingStation;

	}

	public void updateScreen() {
		super.updateScreen();
	}


	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Soldering_Station_Circuit.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	

	public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(1, guiLeft+153, guiTop+108, 20, 20, "✔"));
		
	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 1:
			PacketHandler.INSTANCE.sendToServer(new MessageCircuitCrafting(tile.xCoord, tile.yCoord, tile.zCoord));
			break;
		case 2:
		}
	}

}
