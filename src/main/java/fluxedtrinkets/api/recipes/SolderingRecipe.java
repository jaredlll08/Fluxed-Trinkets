package fluxedtrinkets.api.recipes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class SolderingRecipe {

	private ItemStack output;
	private ItemStack input;
	private ItemStack[] addons;

	public SolderingRecipe(ItemStack input, ItemStack output, ItemStack...stacks) {
		this.input = input;
		this.output = output;
		this.addons = stacks;
	}

	public boolean matches(ItemStack input, ItemStack... stacks) {
		if (this.input.getItem() == input.getItem()) {
			for (int i = 0; i < addons.length; i++) {
				if (this.getAddons()[i].getItem() == stacks[i].getItem()) {
					return true;
				}
			}
		}

		return false;
	}

	public ItemStack getOutput() {
		return output;
	}

	public ItemStack getInput() {
		return input;
	}

	public ItemStack[] getAddons() {
		return addons;
	}
}
