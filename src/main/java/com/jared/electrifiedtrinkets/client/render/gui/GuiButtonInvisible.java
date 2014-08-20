
package com.jared.electrifiedtrinkets.client.render.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiButtonInvisible extends GuiButton {

	public GuiButtonInvisible(int par1, int par2, int par3, int par4, int par5, String par6Str) {
		super(par1, par2, par3, par4, par5, par6Str);
	}

	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
		int k = getHoverState(field_146123_n);

		boolean unicode = par1Minecraft.fontRenderer.getUnicodeFlag();
		par1Minecraft.fontRenderer.setUnicodeFlag(true);
		
		if(k==2){
				par1Minecraft.fontRenderer.drawString(displayString, xPosition, yPosition, 255);	
		}
		if(k==1){
			par1Minecraft.fontRenderer.drawString(displayString, xPosition + (k == 2 ? 10 : 0), yPosition + (height - 8) / 2, 0);
		}
		par1Minecraft.fontRenderer.setUnicodeFlag(unicode);
	}

}