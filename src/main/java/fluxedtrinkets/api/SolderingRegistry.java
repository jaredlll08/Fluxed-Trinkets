package fluxedtrinkets.api;

import java.util.ArrayList;

import fluxedtrinkets.api.recipes.SolderingRecipe;
import net.minecraft.item.ItemStack;

/**
 * @author Jared
 *
 */
public class SolderingRegistry {

	private static ArrayList<SolderingRecipe> recipe = new ArrayList<SolderingRecipe>();

	/**
	 * 
	 * @return The ItemStack array.
	 */
	public static ArrayList<SolderingRecipe> getRecipes() {
		return recipe;
	}

	/**
	 * Used to add a recipe to the Solder Station.
	 * 
	 */
	public static void registerRecipe(SolderingRecipe recipe) {
		SolderingRegistry.recipe.add(recipe);

	}

}
