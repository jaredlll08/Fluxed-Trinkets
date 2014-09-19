package fluxedtrinkets.api;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Jared
 *
 */
public class SolderingRecipe {

	private static ArrayList<ItemStack[]> recipe = new ArrayList<ItemStack[]>();

	/**
	 * 
	 * @return The ItemStack array.
	 */
	public static ArrayList<ItemStack[]> getRecipe() {
		return recipe;
	}

	/**
	 * Used to add a recipe to the Solder Station.
	 * 
	 * @param circuitInput
	 * @param addon1
	 * @param addon2
	 * @param addon3
	 * @param addon4
	 * @param circuitOutPut
	 */
	public static void addRecipe(ItemStack circuitInput, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4, ItemStack circuitOutPut) {
		if (hasRecipe(circuitInput, addon1, addon2, addon3, addon4)) {
			recipe.add(new ItemStack[] { circuitInput, addon1, addon2, addon3, addon4, circuitOutPut, });

		}
	}

	/**
	 * Used to check if a recipe exists.
	 * 
	 * @param circuitInput
	 * @param addon1
	 * @param addon2
	 * @param addon3
	 * @param addon4
	 * @return true if the recipe is found.
	 */
	public static boolean hasRecipe(ItemStack circuitInput, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4) {
		for (int i = 0; i < getRecipe().size(); i++) {
			if (getRecipe().get(i)[0].getItem().equals(circuitInput.getItem())) {
				if (getRecipe().get(i)[1].getItem().equals(addon1.getItem())) {
					if (getRecipe().get(i)[2].getItem().equals(addon2.getItem())) {
						if (getRecipe().get(i)[3].getItem().equals(addon3.getItem())) {
							if (getRecipe().get(i)[4].getItem().equals(addon4.getItem())) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * gets the result of the given ItemStack. returns false if recipe is not
	 * found.
	 * 
	 * @param circuitInput
	 * @param addon1
	 * @param addon2
	 * @param addon3
	 * @param addon4
	 * @return Itemstack result
	 */
	public static ItemStack getOutPut(ItemStack circuitInput, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4) {
		for (int i = 0; i < getRecipe().size(); i++) {
			if (getRecipe().get(i)[0].getItem().equals(circuitInput.getItem())) {
				if (getRecipe().get(i)[1].getItem().equals(addon1.getItem())) {
					if (getRecipe().get(i)[2].getItem().equals(addon2.getItem())) {
						if (getRecipe().get(i)[3].getItem().equals(addon3.getItem())) {
							if (getRecipe().get(i)[4].getItem().equals(addon4.getItem())) {
								return getRecipe().get(i)[5];
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	
	

}
