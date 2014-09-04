package com.jared.electrifiedtrinkets.client.render.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.util.StringUtils;

public class GuiEManual extends GuiScreen {
	int par1;
	int par2;
	float par3;
	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;
	int middleX = (guiWidth / 2) - guiWidth;
	int middleY = (guiHeight / 2) - guiHeight;
	boolean renderToolTip = false;
	boolean recipeBeltEmpty = false;
	boolean recipeAmuletEmpty = false;
	boolean recipeRingEmpty = false;
	boolean solderingEarth, solderingAir, solderingFire, solderingWater = false;

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

		this.left = (this.width / 2) - (guiWidth / 2);
		this.top = (this.height / 2) - (guiHeight / 2);
		removeAllChapters();
		removeAllText();

		recipeAmuletEmpty = false;

		recipeRingEmpty = false;

		recipeBeltEmpty = false;

		renderToolTip = false;
		
		solderingAir = false;
		solderingEarth = false;
		solderingFire = false;
		solderingWater = false;
		

		Pages.mainPage();

	}

	public void handleKeyboardInput() {
		super.handleKeyboardInput();
		if (Keyboard.isKeyDown(Keyboard.KEY_BACK)) {
			this.initGui();
		}

	}

	private static final ResourceLocation crafting = new ResourceLocation(ModInfo.modid, "textures/gui/crafting.png");

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.par1 = par1;
		this.par2 = par2;
		this.par3 = par3;

		if(mc.renderEngine!=null){
			mc.renderEngine.bindTexture(texture);	
		}
		
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		super.drawScreen(par1, par2, par3);
		buttonList.clear();

		for (int i = 0; i < getChapters(); i++) {
			buttonList.add(new GuiButtonInvisible(Integer.parseInt(String.valueOf(getChapter(i)[1])), left + 10, (top + 15) + (10 * i), 100, 10, (String) getChapter(i)[0], true));
		}

		for (int i = 0; i < getTexts(); i++) {
			drawString(fontRendererObj, getText(i), left + 10, (top + 15) + (10 * i), 0);
		}

		if (recipeAmuletEmpty) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 81, top + 94);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.iron_bars), left + 45, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 63, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 81, top + 112);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.iron_bars), left + 45, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.iron_bars), left + 63, top + 130);
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(Items.iron_ingot), left + 63, top + 94);
				renderToolTip(new ItemStack(Blocks.iron_bars), left + 63, top + 130);
			}
		}

		if (recipeBeltEmpty) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 81, top + 94);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 45, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 81, top + 112);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 45, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 63, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(Items.iron_ingot), left + 45, top + 130);
			}
		}


		if (recipeRingEmpty) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 81, top + 112);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 45, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.iron_ingot), left + 63, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(Items.iron_ingot), left + 63, top + 94);

			}
		}

	

		if (solderingEarth) {
			

			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 23, top + 120, 0, 180, 18, 18);

			drawTexturedModalRect(left + 63, top + 120, 0, 180, 18, 18);
			drawTexturedModalRect(left + 103, top + 120, 0, 180, 18, 18);
			ItemStack stack = OreDictionary.getOres("nuggetCopper").get(0);

			for (int i = 0; i < 7; i++) {
				drawTexturedModalRect(left + 10 + (18 * i), top + 90, 0, 180, 18, 18);
			}
			
			for (int i = 0; i < 4; i++) {
				drawTexturedModalRect(left + 10 + (18 * i), top + 63, 0, 180, 18, 18);
			}
			
			for (int i = 0; i < 7; i++) {
				itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 11 + (18 * i), top + 91);
			}
			
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			RenderHelper.enableGUIStandardItemLighting();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.leadWire), left + 104, top + 121);
			
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.grass), left + 24, top + 10);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.obsidian), left + 24, top + 28);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.iron_ore), left + 24, top + 46);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.sapling), left + 24, top + 58);
			
			
			GL11.glPopMatrix();
			
			
			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(ETItems.solderingIron).getDisplayName(), left + 33, top + 110,0);
				drawCenteredString(fontRendererObj, new ItemStack(ETItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(ETItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left+73, top+80, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
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
			Pages.CircuitsChapters();
			break;



		case 6:
			removeAllChapters();
			removeAllText();
			Pages.EmptyAmulet();
			recipeAmuletEmpty = true;

		case 8:
			removeAllChapters();
			removeAllText();
			Pages.BeltEmpty();
			recipeBeltEmpty = true;
			break;

		case 14:
			removeAllChapters();
			removeAllText();
			Pages.RingEmpty();
			recipeRingEmpty = true;
			break;

		case 17:
			removeAllChapters();
			removeAllText();
			Pages.BasicCircuits();

			break;

		case 18:
			removeAllChapters();
			removeAllText();
			Pages.AdvancedCircuits();
			break;

		case 20:

			removeAllChapters();
			removeAllText();
			solderingEarth = true;
			break;

		case 99:
			if (renderToolTip == true) {
				renderToolTip = false;
			} else {
				renderToolTip = true;
			}
			this.drawScreen(par1, par2, par3);

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
