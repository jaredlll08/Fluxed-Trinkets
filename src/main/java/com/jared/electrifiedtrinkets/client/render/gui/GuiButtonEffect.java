package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;

public class GuiButtonEffect extends GuiButton {

	private int xOffset;
	private int yOffset;
	public GuiButtonEffect(int par1, int par2, int par3, int par4, int par5, String par6Str, int xOffset, int yOffset) {
		super(par1, par2, par3, par4, par5, par6Str);
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
		
	}
	
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/ButtonIcon.png");


	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
		int hoverState = getHoverState(field_146123_n);

		boolean unicode = par1Minecraft.fontRenderer.getUnicodeFlag();
		par1Minecraft.fontRenderer.setUnicodeFlag(true);
		par1Minecraft.renderEngine.bindTexture(texture);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		drawTexturedModalRect(xPosition, yPosition, xOffset, yOffset, 9, 9);
		if (hoverState == 2) {
			par1Minecraft.fontRenderer.drawString(displayString, xPosition-(width/2), yPosition - (height - 8) / 2-8 , 0);
		}

		par1Minecraft.fontRenderer.setUnicodeFlag(unicode);
	}

}