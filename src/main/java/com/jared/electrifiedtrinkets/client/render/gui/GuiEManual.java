package com.jared.electrifiedtrinkets.client.render.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesArmor;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import scala.tools.nsc.interpreter.Javap.Showable;

import com.ibm.icu.impl.duration.impl.DataRecord.ETimeDirection;
import com.jared.electrifiedtrinkets.ModInfo;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.util.StringUtils;

public class GuiEManual extends GuiScreen {
	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;
	int middleX = (guiWidth / 2) - guiWidth;
	int middleY = (guiHeight / 2) - guiHeight;
	boolean renderToolTip = false;
	boolean recipeBeltEmpty, recipeBeltSpeed, recipeBeltFire, recipeBeltIce, recipeBeltJump, recipeBeltStep = false;
	boolean recipeAmuletEmpty, recipeAmuletRespiratory = false;
	boolean recipeRingEmpty, recipeRingMining, recipeRingFarming = false;

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
		recipeAmuletRespiratory = false;

		recipeRingEmpty = false;
		recipeRingFarming = false;
		recipeRingMining = false;

		recipeBeltEmpty = false;
		recipeBeltFire = false;
		recipeBeltIce = false;
		recipeBeltJump = false;
		recipeBeltSpeed = false;
		recipeBeltStep = false;

		renderToolTip = false;

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

		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		super.drawScreen(par1, par2, par3);
		buttonList.clear();

		for (int i = 0; i < getChapters(); i++) {
			buttonList.add(new GuiButtonInvisible(Integer.parseInt(String.valueOf(getChapter(i)[1])), left + 10, (top + 15) + (10 * i), 100, 10, (String) getChapter(i)[0] + ":" + getChapter(i)[1]));
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
		if (recipeAmuletRespiratory) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			ItemStack stack = OreDictionary.getOres("gearElectrum").get(0);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitAir), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitWater), left + 45, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.amuletEmpty), left + 81, top + 94);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.basicBattery), left + 81, top + 94);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(ETItems.circuitAir), left + 63, top + 94);
				renderToolTip(new ItemStack(ETItems.circuitWater), left + 45, top + 130);
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
		if (recipeBeltFire) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			ItemStack stack = OreDictionary.getOres("gearElectrum").get(0);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitFire), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.advancedCircuitLava), left + 45, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.basicBattery), left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.beltEmpty), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(ETItems.circuitFire), left + 63, top + 94);
				renderToolTip(new ItemStack(ETItems.advancedCircuitLava), left + 45, top + 130);
			}
		}

		if (recipeBeltSpeed) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			ItemStack stack = OreDictionary.getOres("gearElectrum").get(0);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitAir), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitEarth), left + 45, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitAir), left + 81, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.basicBattery), left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.beltEmpty), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(ETItems.circuitAir), left + 63, top + 94);
				renderToolTip(new ItemStack(ETItems.circuitEarth), left + 45, top + 130);

			}
		}
		
		if (recipeBeltIce) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			ItemStack stack = OreDictionary.getOres("gearElectrum").get(0);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.advancedCircuitIce), left + 63, top + 94);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.basicBattery), left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.beltEmpty), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(ETItems.advancedCircuitIce), left + 63, top + 94);

			}
		}
		if (recipeBeltJump) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			ItemStack stack = OreDictionary.getOres("gearElectrum").get(0);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitAir), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitEarth), left + 63, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.basicBattery), left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.beltEmpty), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(ETItems.circuitAir), left + 63, top + 94);
				renderToolTip(new ItemStack(ETItems.circuitEarth), left + 63, top + 130);

			}
		}
		if (recipeBeltStep) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);
			ItemStack stack = OreDictionary.getOres("gearElectrum").get(0);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), stack, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitAir), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitEarth), left + 63, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.circuitEarth), left + 81, top + 112);

			
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.basicBattery), left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(ETItems.beltEmpty), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(new ItemStack(ETItems.circuitAir), left + 63, top + 94);
				renderToolTip(new ItemStack(ETItems.circuitEarth), left + 63, top + 130);

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
		case 3:
			removeAllChapters();
			removeAllText();
			Pages.Amulets();

			break;

		case 4:
			removeAllChapters();
			removeAllText();
			Pages.Rings();
			break;

		case 5:
			removeAllChapters();
			removeAllText();
			Pages.Belts();
			break;

		case 6:
			removeAllChapters();
			removeAllText();
			Pages.EmptyAmulet();
			recipeAmuletEmpty = true;

			break;
		case 7:
			removeAllChapters();
			removeAllText();
			Pages.ResipratoryAmulet();
			recipeAmuletRespiratory = true;

			break;

		case 8:
			removeAllChapters();
			removeAllText();
			Pages.BeltEmpty();
			recipeBeltEmpty = true;
			break;

		case 9:
			removeAllChapters();
			removeAllText();
			Pages.BeltHasty();
			recipeBeltSpeed = true;
			break;
			
		case 10:
			removeAllChapters();
			removeAllText();
			Pages.BeltScorched();
			recipeBeltFire= true;
			break;
		case 11:
			removeAllChapters();
			removeAllText();
			Pages.BeltChilling();
			recipeBeltIce= true;
			break;
			
		case 12:
			removeAllChapters();
			removeAllText();
			Pages.BeltSprung();
			recipeBeltJump= true;
			break;
			
		case 13:
			removeAllChapters();
			removeAllText();
			Pages.BeltPacing();
			recipeBeltStep = true;
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

		case 99:
			renderToolTip = true;

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
