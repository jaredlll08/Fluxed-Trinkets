package com.jared.electrifiedtrinkets.client.render.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.ibm.icu.impl.duration.impl.DataRecord.ETimeDirection;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.util.StringUtils;

public class GuiEManual extends GuiScreen {
	String title;
	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;
	int middleX = (guiWidth / 2) - guiWidth;
	int middleY = (guiHeight / 2) - guiHeight;

	static ArrayList<Object[]> chapters = new ArrayList<Object[]>();
	static ArrayList<String> texts = new ArrayList<String>();

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Electricians_Manual.png");

	public static void addText(String text) {
		texts.add(StringUtils.translate("manual." + text));
	}

	public static void removeText(String text) {
		texts.remove(text);
	}

	public static void removeText(int number) {
		texts.remove(number);
	}

	public static String getText(int number) {
		return texts.get(number);
	}

	public static void removeAllText() {
		texts.clear();
	}

	public int getTexts() {
		return texts.size();
	}

	public static void addChapter(String title, int number) {

		chapters.add(new Object[] { StringUtils.translate("manual." + title), number });

	}

	public Object[] getChapter(int number) {
		return chapters.get(number);
	}

	public void removeChapters(String title) {
		chapters.remove(title);
	}

	public void removeChapter(int chapterNumber) {
		chapters.remove(chapterNumber);
	}

	public void removeAllChapters() {
		buttonList.clear();
		chapters.clear();
	}

	public int getChapters() {
		return chapters.size();
	}

	@Override
	public void initGui() {
		super.initGui();
		title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();

		this.left = (this.width / 2) - (guiWidth / 2);
		this.top = (this.height / 2) - (guiHeight / 2);
		removeAllChapters();
		Pages.mainPage();
		removeAllText();
		
	}

	public void handleKeyboardInput() {
		super.handleKeyboardInput();
		if (Keyboard.isKeyDown(Keyboard.KEY_BACK)) {
			removeAllChapters();
			removeAllText();
			Pages.mainPage();
		}

	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {

		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);

		super.drawScreen(par1, par2, par3);
		buttonList.clear();
		for (int i = 0; i < getChapters(); i++) {
			buttonList.add(new GuiButtonInvisible(Integer.parseInt(String.valueOf(getChapter(i)[1])), left + 10, (top + 15) + (10 * i), 100, 10, (String) getChapter(i)[0]));
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.advancedCircuit), left+10, (top + 15) + (10 * i));
		}

		for (int i = 0; i < getTexts(); i++) {
			drawString(fontRendererObj, getText(i), left + 10, (top + 15) + (10 * i), 0);
		
		}
	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 0:
			removeAllChapters();
			removeAllText();
			Pages.introductionText();
			break;
		case 1:
			removeAllChapters();
			Pages.TrinketsChapters();
			break;
		case 2:
			removeAllChapters();
			removeAllText();
			buttonList.clear();
			// Pages.TrinketsChapters();
			break;
		case 3:
			removeAllChapters();
			removeAllText();
			Pages.Amulets();

			break;

		default:
			break;
		}

	}

	public void drawString(FontRenderer font, String string, int x, int y, int color) {
		boolean unicode = font.getUnicodeFlag();
		font.setUnicodeFlag(true);
		font.drawSplitString(string, x, y, 125, color);
		font.setUnicodeFlag(unicode);
	}

	/**
	 * Renders the specified text to the screen, center-aligned.
	 */
	public void drawCenteredString(FontRenderer p_73732_1_, String p_73732_2_, int p_73732_3_, int p_73732_4_, int p_73732_5_) {
		p_73732_1_.drawString(p_73732_2_, p_73732_3_ - p_73732_1_.getStringWidth(p_73732_2_) / 2, p_73732_4_, p_73732_5_);

	}

	public boolean doesGuiPauseGame() {
		return false;
	}
}
