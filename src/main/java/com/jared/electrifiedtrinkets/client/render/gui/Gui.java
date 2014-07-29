package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.network.PacketHandler;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

public class Gui extends GuiContainer {
	
	
	public Gui(InventoryPlayer invPlayer, TileEntitySolderingStation solderingStation) {
		super(new ContainerSolderingStation(invPlayer, solderingStation));

		xSize = 230;
		ySize = 219;

	}

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Soldering_Station.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(1, 10, 52, 20, 20, "+"));
		buttonList.add(new GuiButton(2, 40, 72, 20, 20, "-"));

	}

	protected void actionPerformed(GuiButton guibutton) {
		TileEntitySolderingStation tile = new TileEntitySolderingStation();

		// id is the id you give your button
		switch (guibutton.id) {
		case 1:
			for (int i = 0; i < tile.items.length; i++) {
				tile.setInventorySlotContents(i, new ItemStack(ETItems.speedCircuit));
			}
			// i += 1;
			break;
		case 2:
			// i -= 1;
		}
		Object packet;
		// Packet code here
//		 PacketDispatcher.sendPacketToServer(packet); //send packet
	}
	
	
}
