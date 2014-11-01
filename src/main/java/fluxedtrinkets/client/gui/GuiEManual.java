package fluxedtrinkets.client.gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.api.StringUtils;
import fluxedtrinkets.client.gui.book.manual.GUIManual;
import fluxedtrinkets.config.EffectProps;
import fluxedtrinkets.items.FTItems;

public class GuiEManual extends GuiScreen {
	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;
	int middleX = (guiWidth / 2) - guiWidth;
	int middleY = (guiHeight / 2) - guiHeight;
	boolean renderToolTip = false;
	boolean recipeBeltEmpty = false;
	boolean recipeAmuletEmpty = false;
	boolean recipeRingEmpty = false;
	boolean circuitEmpty = false;
	boolean circuitAdvancedEmpty = false;

	boolean solderingEarth, solderingAir, solderingFire, solderingWater = false;
	boolean solderingAdvancedIce, solderingAdvancedLava, solderingAdvancedLife, solderingAdvancedLightning = false;
	boolean solderingStation = false;

	static ArrayList<Object[]> chapters = new ArrayList<Object[]>();
	static ArrayList<String> texts = new ArrayList<String>();

	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Electricians_Manual.png");

	public static void addText(String text) {
		texts.add(StringUtils.localize("manual." + text));
	}

	public static void addText(String text, boolean localize) {
		texts.add(text);
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

		chapters.add(new Object[] { StringUtils.localize("manual." + title), number });

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
		solderingAdvancedIce = false;
		solderingAdvancedLava = false;
		solderingAdvancedLife = false;
		solderingAdvancedLightning = false;

		circuitAdvancedEmpty = false;
		circuitEmpty = false;

		solderingStation = false;

		Pages.mainPage();

	}

	public void handleKeyboardInput() {
		super.handleKeyboardInput();
		if (Keyboard.isKeyDown(Keyboard.KEY_BACK)) {
			this.initGui();
		}

	}

	public void handleMouseInput() {
		super.handleMouseInput();
		if (Mouse.isButtonDown(1)) {
			this.initGui();
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		if (mc.renderEngine != null) {

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
			drawString(fontRendererObj, new ItemStack(FTItems.modularAmulet).getDisplayName(), left + 11, top + 84, 0);
			drawString(fontRendererObj, new ItemStack(FTItems.modularBelt).getDisplayName(), left + 80, top + 84, 0);
			drawString(fontRendererObj, new ItemStack(FTItems.modularRing).getDisplayName(), left / 2 + left, top + 21, 0);

			showRecipe(left + 11, top + 93, new ShapedOreRecipe(new ItemStack(FTItems.modularAmulet), new Object[] { " bb", "ibb", "ii ", 'i', new ItemStack(Items.iron_ingot), 'b', new ItemStack(Blocks.iron_bars) }));
		}

		if (recipeBeltEmpty) {
			showRecipe(left + 80, top + 93, new ShapedOreRecipe(new ItemStack(FTItems.modularBelt), new Object[] { "iii", "i i", "iii", 'i', new ItemStack(Items.iron_ingot) }));
		}

		if (recipeRingEmpty) {
			showRecipe(left + (left / 2), top + 30, new ShapedOreRecipe(new ItemStack(FTItems.modularRing), new Object[] { " i ", "i i", " i ", 'i', new ItemStack(Items.iron_ingot) }));
		}

		if (circuitEmpty) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);

			ItemStack dustCopper = OreDictionary.getOres("dustCopper").get(0);
			ItemStack dustsulfur = OreDictionary.getOres("dustSulfur").get(0);
			ItemStack dustObsidian = OreDictionary.getOres("dustObsidian").get(0);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.water_bucket), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustCopper, left + 81, top + 112);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustCopper, left + 45, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustObsidian, left + 63, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustsulfur, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustObsidian, left + 45, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustsulfur, left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustObsidian, left + 81, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), dustCopper, left + 63, top + 112);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(dustsulfur, left + 45, top + 94);
				renderToolTip(dustCopper, left + 63, top + 112);
				renderToolTip(dustObsidian, left + 81, top + 130);
			}
		}
		if (circuitAdvancedEmpty) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);

			ItemStack nuggetSignalum = OreDictionary.getOres("nuggetSignalum").get(0);
			ItemStack dustsulfur = OreDictionary.getOres("dustSulfur").get(0);
			ItemStack dustObsidian = OreDictionary.getOres("dustObsidian").get(0);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.redstone), left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), nuggetSignalum, left + 45, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.redstone), left + 45, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), nuggetSignalum, left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 63, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), nuggetSignalum, left + 63, top + 130);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.redstone), left + 81, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), nuggetSignalum, left + 81, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.redstone), left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(nuggetSignalum, left + 63, top + 94);
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.grass), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.obsidian), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.iron_ore), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.sapling), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Blocks.grass).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Blocks.obsidian).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Blocks.iron_ore).getDisplayName(), left + 66, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Blocks.sapling).getDisplayName(), left + 80, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}
		if (solderingAir) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.ghast_tear), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.leaves), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.deadbush), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.feather), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(Items.ghast_tear).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Blocks.leaves).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Blocks.deadbush).getDisplayName(), left + 66, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.feather).getDisplayName(), left + 80, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}
		if (solderingFire) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.lava_bucket), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.coal_block), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.log), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.flint_and_steel), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(Items.lava_bucket).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Blocks.coal_block).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Blocks.log).getDisplayName(), left + 66, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.flint_and_steel).getDisplayName(), left + 20, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}
		if (solderingWater) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.water_bucket), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.ice), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.waterlily), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.dye), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(Items.water_bucket).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Blocks.ice).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Blocks.waterlily).getDisplayName(), left + 66, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.dye).getDisplayName(), left + 80, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}

		if (solderingAdvancedIce) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.snow), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.potionitem, 1, 8200), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.ice), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.cake), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(Blocks.snow).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.potionitem, 1, 8200).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Blocks.ice).getDisplayName(), left + 66, top + 35, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Items.cake).getDisplayName(), left + 80, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}

		if (solderingAdvancedLava) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuitFire), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.potionitem, 1, 8195), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.blaze_rod), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.blaze_powder), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuitFire).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.potionitem, 1, 8195).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Items.blaze_rod).getDisplayName(), left + 81, top + 35, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Items.blaze_powder).getDisplayName(), left + 108, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}

		if (solderingAdvancedLife) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuitEarth), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.speckled_melon), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.potionitem, 1, 8197), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.potionitem, 1, 8257), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuitEarth).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.speckled_melon).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Items.potionitem, 1, 8197).getDisplayName(), left + 101, top + 35, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Items.potionitem, 1, 8257).getDisplayName(), left + 108, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}
		if (solderingAdvancedLightning) {
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
				drawTexturedModalRect(left + 10 + (18 * i), top + 43, 0, 180, 18, 18);
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
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.solderingIron), left + 24, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.circuit), left + 64, top + 121);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 104, top + 121);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.glowstone_dust), left + 11, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Items.redstone), left + 29, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.iron_bars), left + 47, top + 44);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.advancedCircuitLava), left + 64, top + 44);

			GL11.glPopMatrix();

			RenderHelper.disableStandardItemLighting();
			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				boolean uni = fontRendererObj.getUnicodeFlag();
				fontRendererObj.setUnicodeFlag(true);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.solderingIron).getDisplayName(), left + 33, top + 110, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.circuit).getDisplayName(), left + 73, top + 138, 0);
				drawCenteredString(fontRendererObj, new ItemStack(FTItems.leadWire).getDisplayName(), left + 113, top + 110, 0);
				drawCenteredString(fontRendererObj, stack.getDisplayName(), left + 73, top + 80, 0);
				drawCenteredString(fontRendererObj, "Addons", left + 70, top + 20, 0);
				drawCenteredString(fontRendererObj, "Materials", left + 70, top + 70, 0);

				drawCenteredString(fontRendererObj, new ItemStack(Items.glowstone_dust).getDisplayName(), left + 28, top + 35, 0);
				drawCenteredString(fontRendererObj, new ItemStack(Items.redstone).getDisplayName(), left + 37, top + 60, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(Blocks.iron_bars).getDisplayName(), left + 75, top + 35, 0);
				drawCenteredString(fontRendererObj, "|" + new ItemStack(FTItems.advancedCircuitLava).getDisplayName(), left + 80, top + 60, 0);
				fontRendererObj.setUnicodeFlag(uni);
			}
		}

		if (solderingStation) {

			GL11.glColor4f(1F, 1F, 1F, 1F);
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			RenderHelper.enableGUIStandardItemLighting();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(left + 44, top + 93, 0, 180, 54, 54);

			ItemStack invarIngot = OreDictionary.getOres("ingotInvar").get(0);
			ItemStack invarGear = OreDictionary.getOres("gearInvar").get(0);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), invarGear, left + 45, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(Blocks.crafting_table), left + 63, top + 94);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), invarGear, left + 81, top + 94);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), invarIngot, left + 45, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), new ItemStack(FTItems.leadWire), left + 63, top + 112);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), invarIngot, left + 81, top + 112);

			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), invarIngot, left + 45, top + 130);
			itemRender.renderItemIntoGUI(fontRendererObj, mc.getTextureManager(), invarIngot, left + 81, top + 130);

			buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20, "Toggle tooltip"));
			if (renderToolTip) {
				renderToolTip(invarIngot, left + 63, top + 94);
				renderToolTip(invarGear, left + 45, top + 94);
			}
		}

	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		case 99:
			if (renderToolTip == true) {
				renderToolTip = false;
			} else {
				renderToolTip = true;
			}

			break;

		case 0:
			removeAllChapters();
			removeAllText();
			Pages.introductionText();
			break;
		case 1:
			removeAllChapters();
			removeAllText();
			Pages.TrinketsChapters();
			recipeAmuletEmpty = true;
			recipeBeltEmpty = true;
			recipeRingEmpty = true;
			break;
		case 2:
			removeAllChapters();
			removeAllText();
			Pages.CircuitsChapters();
			break;

		case 3:
			removeAllChapters();
			removeAllText();
			Pages.BasicCircuits();
			break;

		case 4:
			removeAllChapters();
			removeAllText();
			Pages.AdvancedCircuits();
			break;

		case 5:
			removeAllChapters();
			removeAllText();
			Pages.CircuitEmpty();
			circuitEmpty = true;
			break;

		case 6:
			removeAllChapters();
			removeAllText();
			solderingEarth = true;
			break;
		case 7:
			removeAllChapters();
			removeAllText();
			solderingAir = true;
			break;
		case 8:
			removeAllChapters();
			removeAllText();
			solderingFire = true;
			break;
		case 9:
			removeAllChapters();
			removeAllText();
			solderingWater = true;
			break;
		case 10:
			removeAllChapters();
			removeAllText();
			circuitAdvancedEmpty = true;
			Pages.AdvancedCircuit();
			break;
		case 11:
			removeAllChapters();
			removeAllText();
			solderingAdvancedIce = true;
			break;
		case 12:
			removeAllChapters();
			removeAllText();
			solderingAdvancedLava = true;
			break;

		case 13:
			removeAllChapters();
			removeAllText();
			solderingAdvancedLife = true;
			break;

		case 14:
			removeAllChapters();
			removeAllText();
			solderingAdvancedLightning = true;
			break;

		case 15:
			removeAllChapters();
			removeAllText();
			solderingStation = true;
			Pages.SolderingStation();
			break;
		case 16:
			removeAllChapters();
			removeAllText();
			Pages.SolderingIron();
			break;
		case 17:
			removeAllChapters();
			removeAllText();
			Pages.LeadWire();
			break;
		case 18:
			removeAllChapters();
			removeAllText();
			Pages.effectType();
			break;
		case 19:
			removeAllChapters();
			removeAllText();
			Pages.basicEffects();
			break;
		case 20:
			removeAllChapters();
			removeAllText();
			Pages.comboEffects();
			break;

		case 21:
			removeAllChapters();
			removeAllText();
			addText("effects.single.0");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyAir.getInt()) + "RF/t", false);
			addText("");
			addText("effect.air.desc");
			addText("");
			addText("");
			addText("effects.single.0.info");

			break;
		case 22:
			removeAllChapters();
			removeAllText();
			addText("effects.single.1");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyEarth.getInt()) + "RF/t", false);
			addText("");
			addText("effect.earth.desc");
			addText("");
			addText("");
			addText("effects.single.1.info");

			break;
		case 23:
			removeAllChapters();
			removeAllText();
			addText("effects.single.2");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyWater.getInt()) + "RF/t", false);
			addText("");
			addText("effect.water.desc");
			addText("");
			addText("");
			addText("effects.single.2.info");

			break;
		case 24:
			removeAllChapters();
			removeAllText();
			addText("effects.single.3");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyFire.getInt()) + "RF/t", false);
			addText("");
			addText("effect.fire.desc");
			addText("");
			addText("");
			addText("effects.single.3.info");

			break;
		case 25:
			removeAllChapters();
			removeAllText();
			addText("effects.single.4");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyAdvancedIce.getInt()) + "RF/t", false);
			addText("");
			addText("effect.advancedIce.desc");
			addText("");
			addText("");
			addText("effects.single.4.info");

			break;
		case 26:
			removeAllChapters();
			removeAllText();
			addText("effects.single.5");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyAdvancedLava.getInt()) + "RF/t", false);
			addText("");
			addText("effect.advancedLava.desc");
			addText("");
			addText("");
			addText("effects.single.5.info");

			break;
		case 27:
			removeAllChapters();
			removeAllText();
			addText("effects.single.6");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyAdvancedLife.getInt()) + "RF/t", false);
			addText("");
			addText("effect.advancedLife.desc");
			addText("");
			addText("");
			addText("effects.single.6.info");

			break;
		case 28:
			removeAllChapters();
			removeAllText();
			addText("effects.single.7");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyAdvancedLightning.getInt()) + "RF/t", false);
			addText("");
			addText("effect.advancedLightning.desc");
			addText("");
			addText("");
			addText("");
			addText("effects.single.7.info");

			break;

		case 29:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.0");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyStep.getInt()) + "RF/t", false);
			addText("");
			addText("effect.step.desc");
			addText("");
			addText("");
			addText("effects.combo.0.info");

			break;
		case 30:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.1");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyRespiratory.getInt()) + "RF/t", false);
			addText("");
			addText("effect.respiratory.desc");
			addText("");
			addText("");
			addText("effects.combo.1.info");

			break;
		case 31:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.2");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyHaste.getInt()) + "RF/t", false);
			addText("");
			addText("effect.haste.desc");
			addText("");
			addText("");
			addText("effects.combo.2.info");
			break;
		case 32:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.3");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyFeed.getInt()) + "RF/t", false);
			addText("");
			addText("effect.feed.desc");
			addText("");
			addText("");
			addText("effects.combo.3.info");

			break;
		case 33:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.4");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyFall.getInt()) + "RF/t", false);
			addText("");
			addText("effect.air.desc");
			addText("");
			addText("");
			addText("effects.combo.4.info");
			break;
		case 34:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.5");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyWither.getInt()) + "RF/t", false);
			addText("");
			addText("effect.witherless.desc");
			addText("");
			addText("");
			addText("effects.combo.5.info");
			break;
		case 35:
			removeAllChapters();
			removeAllText();
			addText("effects.combo.6");
			addText("");
			addText("Usage: " + String.valueOf(EffectProps.energyPoison.getInt()) + "RF/t", false);
			addText("");
			addText("effect.poisonless.desc");
			addText("");
			addText("");
			addText("effects.combo.6.info");
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

	public void showRecipe(int x, int y, ShapedOreRecipe recipe) {

		ItemStack[] input = new ItemStack[9];

		for (int i = 0; i < input.length; i++) {
			input[i] = (ItemStack) recipe.getInput()[i];
		}
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.enableGUIStandardItemLighting();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(x, y, 0, 180, 54, 54);

		if (input[0] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[0], x + 1, y + 1);
		if (input[1] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[1], x + 1, y + 19);
		if (input[2] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[2], x + 1, y + 37);
		if (input[3] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[3], x + 19, y + 1);
		if (input[4] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[4], x + 19, y + 19);
		if (input[5] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[5], x + 19, y + 37);
		if (input[6] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[6], x + 37, y + 1);
		if (input[7] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[7], x + 37, y + 19);
		if (input[8] != null)
			itemRender.renderItemIntoGUI(fontRendererObj, Minecraft.getMinecraft().getTextureManager(), input[8], x + 37, y + 37);

		GL11.glPopMatrix();
	}

}
