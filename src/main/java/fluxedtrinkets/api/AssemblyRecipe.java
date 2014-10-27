package fluxedtrinkets.api;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

public class AssemblyRecipe {
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

	public boolean equals(AssemblyRecipe otherRecipe) {
		if (otherRecipe.inputs.length == this.inputs.length) {
			for (IEffect effect : otherRecipe.inputs) {
				if (!ArrayUtils.contains(this.inputs, effect)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}