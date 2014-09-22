package fluxedtrinkets.api;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class FluxedTrinketsAPI {

	private static ArrayList<String> effectName = new ArrayList<String>();
	private static ArrayList<IEffect> effects = new ArrayList<IEffect>();

	private static ArrayList<ArrayList<IEffect>> effectCombo2 = new ArrayList<ArrayList<IEffect>>();

	/**
	 * Adds an effect to the effect list.
	 * 
	 * @param effect
	 */
	public static void addEffect(IEffect effect) {
		if (!hasEffect(effect) && !hasEffect(effect.getEffectName())) {
			effects.add(effect);
			effectName.add(effect.getEffectName());
		}
	}

	/**
	 * Gets the List of effects.
	 * 
	 * @return a list of effects
	 */
	public static ArrayList<String> getEffectNames() {
		return effectName;
	}

	/**
	 * Gets the List of effects.
	 * 
	 * @return a list of effects
	 */
	public static ArrayList<IEffect> getEffects() {
		return effects;
	}

	/**
	 * Checks if an effect exists in the effect list.
	 * 
	 * @param effect
	 * @return
	 */
	public static boolean hasEffect(String effect) {
		if (effectName.contains(effect)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if an effect exists in the effect list.
	 * 
	 * @param effect
	 * @return
	 */
	public static boolean hasEffect(IEffect effect) {
		if (effects.contains(effect)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param name
	 * @return The effect that has the name provided
	 */
	public static IEffect getEffectFromName(String name) {
		for (int i = 0; i < effects.size(); i++) {
			if (effects.get(i).getEffectName().equals(name)) {
				return effects.get(i);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param effect
	 * @return the name of the effect
	 */
	public static String getNameFromEffect(IEffect effect) {
		return effect.getEffectName();
	}

}
