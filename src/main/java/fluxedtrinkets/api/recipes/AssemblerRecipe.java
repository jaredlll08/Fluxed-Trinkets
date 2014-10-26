package fluxedtrinkets.api.recipes;

import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.IEffect;

public class AssemblerRecipe {

	private ItemStack output;
	private IEffect[] circuits;

	public AssemblerRecipe(ItemStack output, IEffect... stacks) {
		this.output = output;
		this.circuits = stacks;
	}

	public boolean matches(ItemStack[] inCombo) {
		int count = 0;
		String in = inCombo.toString();
		for (int i = 0; i < getCircuits().length; i++) {
			if (getCircuits()[0] != null && inCombo[0] != null)
				if (in.indexOf(getCircuits()[0].getName()) > 0) {
					in.replaceFirst(getCircuits()[0].getName(), "");
					count++;
				}
		}
		if (count == getCircuits().length) {
			return true;
		}

		return false;
	}

	public ItemStack getOutput() {
		return output;
	}

	public IEffect[] getCircuits() {
		return circuits;
	}
}
