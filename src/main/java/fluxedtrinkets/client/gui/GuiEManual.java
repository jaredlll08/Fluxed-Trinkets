package fluxedtrinkets.client.gui;

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
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.api.StringUtils;
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

	
	public void handleMouseInput(){
		super.handleMouseInput();
		if(Mouse.isButtonDown(1)){
			initGui();
		}
	}
	private static final ResourceLocation crafting = new ResourceLocation(ModInfo.modid, "textures/gui/crafting.png");

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
