package fluxedtrinkets;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import fluxedtrinkets.api.SolderingRecipe;
import fluxedtrinkets.api.StringUtils;

public class RecipeHandlerSoldering extends TemplateRecipeHandler {

	public class CachedSolderingRecipe extends CachedRecipe {

		private PositionedStack input;
		private List<PositionedStack> addons;
		private PositionedStack output;

		public CachedSolderingRecipe(ItemStack circuitInput, ItemStack[] addons, ItemStack circuitOutPut) {
			this.input = new PositionedStack(circuitInput, 4, 13);
			this.output = new PositionedStack(circuitOutPut, 4, 53);
			for (int i = 0; i < addons.length; i++) {
				this.addons.add(new PositionedStack(addons[i], 4 * i, 47));
			}
		}

		@Override
		public PositionedStack getIngredient() {
			return this.input;
		}

		@Override
		public List<PositionedStack> getOtherStacks() {

			return this.addons;
		}

		@Override
		public PositionedStack getResult() {
			return this.output;
		}

	}

	@Override
	public String getRecipeName() {
		return StringUtils.localize("gui.nei.recipe.armoring");
	}

	@Override
	public String getGuiTexture() {
		return ModInfo.modid + ":textures/gui/Soldering_Station_Circuit.png";
	}

	@Override
	public int recipiesPerPage() {
		return 1;
	}

	@Override
	public void drawBackground(int recipe) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiDraw.changeTexture(this.getGuiTexture());
		if (this.arecipes.get(recipe) instanceof CachedSolderingRecipe) {
			GuiDraw.drawTexturedModalRect(6, 32, 13, 0, 13, 13);
			GuiDraw.drawTexturedModalRect(6, 67, 0, 0, 13, 20);
		} else {
			GuiDraw.drawTexturedModalRect(6, 31, 0, 0, 13, 20);
			GuiDraw.drawTexturedModalRect(6, 73, 13, 0, 13, 13);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		ArrayList<ItemStack[]> recipes = SolderingRecipe.getRecipe();
		for (int i = 0; i < SolderingRecipe.getRecipe().size(); i++) {
			this.arecipes.add(new CachedSolderingRecipe(recipes.get(i)[0], new ItemStack[] { recipes.get(i)[1], recipes.get(i)[2], recipes.get(i)[3], recipes.get(i)[4] }, recipes.get(i)[5]));
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		ArrayList<ItemStack[]> recipes = SolderingRecipe.getRecipe();
		for (int i = 0; i < SolderingRecipe.getRecipe().size(); i++) {
			this.arecipes.add(new CachedSolderingRecipe(recipes.get(i)[0], new ItemStack[] { recipes.get(i)[1], recipes.get(i)[2], recipes.get(i)[3], recipes.get(i)[4] }, recipes.get(i)[5]));
		}
	}


}