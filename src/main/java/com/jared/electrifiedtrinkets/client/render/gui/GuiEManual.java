package com.jared.electrifiedtrinkets.client.render.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiEManual extends GuiScreen {
	String title;
	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;
	int middleX = (guiWidth/2)-guiWidth;
	int middleY = (guiHeight/2)-guiHeight;
	
	ArrayList<String> lines = new ArrayList<String>();
	

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Electricians_Manual.png");

	
	public void addLine(String line){
		lines.add(line);
	}
	public String getLine(int number){
		return lines.get(number);
	}
	
	public void removeLine(String line){
		lines.remove(line);
	}
	public void removeLine(int lineNumber){
		lines.remove(lineNumber);
	}
	
	public void removeAllLines(){
		lines.clear();
	}
	public int getLines(){
		return lines.size();
	}
	@Override
	public void initGui() {
		super.initGui();
		title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();
		
		this.left = (this.width / 2) - (guiWidth / 2);
		this.top = (this.height / 2) - (guiHeight / 2);
		removeAllLines();
		addLine("1");
		addLine("2");
		addLine("3");
		addLine("4");
		
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {

		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		drawCenteredString(fontRendererObj, "Am I centered yet?!?!?!", left+(guiWidth/2), top + (guiHeight/2), 0);
		
		
		super.drawScreen(par1, par2, par3);
		for(int i = 0; i < getLines(); i++){
			drawCenteredString(fontRendererObj, getLine(i), left+30, (top+30) +(8*i), 0);
		}
	}
	
	/**
     * Renders the specified text to the screen, center-aligned.
     */
    public void drawCenteredString(FontRenderer p_73732_1_, String p_73732_2_, int p_73732_3_, int p_73732_4_, int p_73732_5_)
    {
        p_73732_1_.drawString(p_73732_2_, p_73732_3_ - p_73732_1_.getStringWidth(p_73732_2_) / 2, p_73732_4_, p_73732_5_);
    }
}
