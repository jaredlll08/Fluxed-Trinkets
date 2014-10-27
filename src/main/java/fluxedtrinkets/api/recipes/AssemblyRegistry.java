package fluxedtrinkets.api.recipes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.ImmutableSet;

import fluxedtrinkets.api.FluxedTrinketsAPI;
import fluxedtrinkets.api.IEffect;

public class AssemblyRegistry {
	
	public static class AssemblyRecipe {
		IEffect[] inputs;
		IEffect output;

		public AssemblyRecipe(IEffect output, IEffect... inputs) {
			this.output = output;
			this.inputs = inputs;
		}

		public IEffect getOutput() {
			return output;
		}

		public ArrayList<String> getEffects(ArrayList<String> currentEffects) {
			int count = 0;
			for (int i = 0; i < inputs.length; i++) {
				System.out.println(i);
				if (currentEffects.contains(inputs[i].getName())) {
					currentEffects.remove(inputs[i].getName());
					count++;
				}
			}
			if (count == inputs.length) {
				currentEffects.add(output.getName());
				return currentEffects;
			}
			return currentEffects;
		}

		public boolean matches(IEffect[] effects) {
			if (effects.length == this.inputs.length) {
				for (IEffect effect : effects) {
					if (!ArrayUtils.contains(this.inputs, effect)) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
	}
	
	private static Set<AssemblyRecipe> recipes = new HashSet<AssemblyRecipe>();
	
	public static void addAssemblyRecipe(IEffect result, IEffect... inputs) {
		recipes.add(new AssemblyRecipe(result, inputs));
	}
	
	public static void addAssemblyRecipe(String result, IEffect... inputs) {
		addAssemblyRecipe(FluxedTrinketsAPI.getEffectFromName(result), inputs);
	}
	
	public static void addAssemblyRecipe(String result, String... inputs) {
		IEffect[] effects = new IEffect[inputs.length];
		for (int i = 0; i < effects.length; i++) {
			effects[i] = FluxedTrinketsAPI.getEffectFromName(inputs[i]);
		}
		
		addAssemblyRecipe(result, effects);
	}

	public static Set<AssemblyRecipe> getRecipes() {
		return ImmutableSet.copyOf(recipes);
	}
}
