package fluxedtrinkets.nei;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.opengl.GL11;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import fluxedtrinkets.ModInfo;
import fluxedtrinkets.api.SolderingRegistry;
import fluxedtrinkets.api.recipes.SolderingRecipe;
import fluxedtrinkets.items.FTItems;

public class SolderingHandler extends TemplateRecipeHandler {

	@Override
	public String getGuiTexture() {
		return ModInfo.modid + ":textures/gui/SolderingNEI.png";
	}

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal(ModInfo.localizing + ".gui.nei.SolderingStation");
	}

	@Override
	public int recipiesPerPage() {
		return 1;
	}

	@Override
	public void drawBackground(int recipe) {
		GL11.glScalef(0.70f, 0.65f, 0.59f);
		GuiDraw.changeTexture(getGuiTexture());
		GuiDraw.drawTexturedModalRect(0, 0, 0, 0, 52, 55);

		GuiDraw.drawTexturedModalRect(106, 115, 0, 56, 28, 28);
		
		GuiDraw.drawTexturedModalRect(151, 0, 177, 0, 79, 83);

		GuiDraw.drawTexturedModalRect(1, 150, 53, 0, 28, 28);
		GuiDraw.drawTexturedModalRect(210, 150, 53, 0, 28, 28);
		GuiDraw.drawTexturedModalRect(106, 150, 53, 0, 28, 28);
		GuiDraw.drawTexturedModalRect(106, 80, 53, 0, 28, 28);
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	public void drawForeground(int recipe) {
		super.drawForeground(recipe);
	}

	@Override
	public void drawExtras(int recipe) {
		CachedSolderingRecipe r = (CachedSolderingRecipe) arecipes.get(recipe);
		int coords2[] = { 0, 0 };
		GL11.glScalef(.08f, .08f, .08f);
		GL11.glEnable(GL11.GL_BLEND);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glScalef(15.625f, 15.625f, 15.625f);
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		ArrayList<SolderingRecipe> recipes = SolderingRegistry.getRecipes();

		for (int j = 0; j < recipes.size(); j++) {
			SolderingRecipe recipe = recipes.get(j);
			if (recipe.getOutput().isItemEqual(result)) {
				this.arecipes.add(new CachedSolderingRecipe(recipe));
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {

		ArrayList<SolderingRecipe> recipes = SolderingRegistry.getRecipes();
		ArrayList<ItemStack> copper = OreDictionary.getOres("nuggetCopper");

		for (int j = 0; j < recipes.size(); j++) {
			SolderingRecipe recipe = recipes.get(j);
			for (int i = 0; i < recipe.getAddons().length; i++) {
				if (recipe.getAddons()[i].isItemEqual(ingredient) || ingredient.isItemEqual(copper.get(0)) || recipe.getInput().isItemEqual(ingredient)) {
					if (checkDupe(recipe))
						this.arecipes.add(new CachedSolderingRecipe(recipe));

				}
			}
		}
	}

	private boolean checkDupe(SolderingRecipe recipe) {
		for (Object o : this.arecipes.toArray()) {
			if (o instanceof CachedSolderingRecipe) {
				CachedSolderingRecipe r = (CachedSolderingRecipe) o;
				if (r.recipe.getInput() == recipe.getInput()) {
					if (r.recipe.getOutput().isItemEqual(recipe.getOutput())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public class CachedSolderingRecipe extends CachedRecipe {

		private PositionedStack output;
		private PositionedStack inputs;
		private List<PositionedStack> other = new ArrayList<PositionedStack>();
		private List<Integer> copperPos = new ArrayList<Integer>();

		public SolderingRecipe recipe;

		public CachedSolderingRecipe(SolderingRecipe recipe) {
			this.output = new PositionedStack(recipe.getOutput(), 75, 53);
			this.recipe = recipe;
			this.inputs = new PositionedStack(recipe.getInput(), 75, 98);
			this.other.add(new PositionedStack(recipe.getAddons()[0], 1, 1));
			this.other.add(new PositionedStack(recipe.getAddons()[1], 1, 19));
			this.other.add(new PositionedStack(recipe.getAddons()[2], 19, 1));
			this.other.add(new PositionedStack(recipe.getAddons()[3], 19, 19));

			this.other.add(new PositionedStack(new ItemStack(FTItems.solderingIron), 1, 98));
			this.other.add(new PositionedStack(new ItemStack(FTItems.leadWire), 148, 98));
			ArrayList<ItemStack> copper = OreDictionary.getOres("nuggetCopper");

			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 126, 1));
			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 108, 19));
			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 126, 19));
			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 144, 19));
			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 144, 1));
			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 126, 37));
			other.add(new PositionedStack(copper.get(new Random().nextInt(copper.size())), 144, 37));

			for (int i = 0; i < 8; i++) {
			}

		}

		@Override
		public PositionedStack getResult() {
			return this.output;
		}

		@Override
		public PositionedStack getIngredient() {
			return this.inputs;
		}

		@Override
		public List<PositionedStack> getOtherStacks() {
			return other;
		}
	}

	@Override
	public String getOverlayIdentifier() {
		return "SolderingStation";
	}
}