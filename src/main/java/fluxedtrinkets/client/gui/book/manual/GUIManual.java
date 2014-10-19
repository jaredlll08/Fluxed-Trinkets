package fluxedtrinkets.client.gui.book.manual;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.lwjgl.opengl.GL11;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.api.StringUtils;
import fluxedtrinkets.api.manual.PageBase;
import fluxedtrinkets.api.manual.PageRegistry;
import fluxedtrinkets.blocks.FTBlocks;
import fluxedtrinkets.client.gui.GuiButtonInvisible;
import fluxedtrinkets.items.FTItems;

public class GUIManual extends GuiScreen {

	private PageBase currentPage;
	private ArrayList<PageBase> chapters = new ArrayList<PageBase>();
	private ArrayList<String> content = new ArrayList<String>();

	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;
	int middleX = (guiWidth / 2) - guiWidth;
	int middleY = (guiHeight / 2) - guiHeight;

	static ArrayList<Object[]> chapter = new ArrayList<Object[]>();
	static ArrayList<String> texts = new ArrayList<String>();

	public static GUIManual INSTANCE;
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.modid, "textures/gui/Electricians_Manual.png");

	public static void addText(String text) {
		texts.add(StringUtils.localize("manual." + text));
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

		chapter.add(new Object[] { StringUtils.localize("manual." + title), number });

	}

	public Object[] getChapter(int number) {
		return chapter.get(number);
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

	public void drawScreen(int mouseX, int mouseY, float par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.left = (this.width / 2) - (guiWidth / 2);
		this.top = (this.height / 2) - (guiHeight / 2);

		if (mc.renderEngine != null) {
			mc.renderEngine.bindTexture(texture);
		}

		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);

		buttonList.clear();
		chapters.clear();
		// if (currentPage == null) {
		// for (int i = 0; i < PageRegistry.getPages().size(); i++) {
		// if (PageRegistry.getPages().get(i).getParentPage() == null) {
		// chapters.add(PageRegistry.getPages().get(i));
		// }
		// }

		// for (int j = 0; j < chapters.size(); j++) {
		// buttonList.add(new GuiButtonInvisible(j, left + 10, (top + 15) + (10
		// * j), 100, 10, chapters.get(j).getName(), true));
		// }
		// }
		showRecipe(this, fontRendererObj, left + 45, top + 94, new ShapedOreRecipe(FTBlocks.machineCube, new Object[] { "iei", "e e", "iei", 'i', Items.apple, 'e', Items.iron_ingot, 'c', FTItems.circuit }));
		super.drawScreen(mouseX, mouseY, par3);
	}

	protected void actionPerformed(GuiButton guibutton) {
		switch (guibutton.id) {
		default:

			// currentPage.get(guibutton.id).drawScreen(this, fontRendererObj,
			// left, top);
			PageBase page = chapters.get(guibutton.id);
			buttonList.clear();
			// chapters.add(page);
			currentPage = page;
			page.drawScreen(this, fontRendererObj, left + 20, top + 20);
			break;

		}
	}

	/**
	 * should be called in the drawScreen method.
	 * 
	 * @param recipe
	 */
	public static void showRecipe(GUIManual manual, FontRenderer font, int x, int y, ShapedOreRecipe recipe) {
		ItemStack[] input = new ItemStack[9];

		for (int i = 0; i < input.length; i++) {
			input[i] = (ItemStack) recipe.getInput()[i];
		}

		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		manual.drawTexturedModalRect(x, y, 0, 180, 54, 54);

		if (input[0] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[0], x + 1, y + 1);
		if (input[1] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[1], x + 1, y + 19);
		if (input[2] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[2], x + 1, y + 37);
		if (input[3] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[3], x + 19, y + 1);
		if (input[4] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[4], x + 19, y + 19);
		if (input[5] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[5], x + 19, y + 37);
		if (input[6] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[6], x + 37, y + 1);
		if (input[7] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[7], x + 37, y + 19);
		if (input[8] != null)
			itemRender.renderItemIntoGUI(font, Minecraft.getMinecraft().getTextureManager(), input[8], x + 37, y + 37);
	}

	// buttonList.add(new GuiButton(99, left + 34, top + 150, 75, 20,
	// "Toggle tooltip"));
	// if (renderToolTip) {
	// renderToolTip(new ItemStack(Items.iron_ingot), left + 63, top + 94);
	// }
}
