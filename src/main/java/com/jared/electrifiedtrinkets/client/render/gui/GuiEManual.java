package com.jared.electrifiedtrinkets.client.render.gui;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiEManual extends GuiScreen {
	String title;
	int guiWidth = 84;
	int guiHeight = 117;
	int left, top;

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Electricians_Manual.png");

	@Override
	public void initGui() {
		super.initGui();
		title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();

		this.left = (this.width / 2) - (guiWidth / 2);
		this.top = (this.height / 2) - (guiHeight / 2);

	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {

		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);

		super.drawScreen(par1, par2, par3);
	}
}
