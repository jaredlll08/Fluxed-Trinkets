package fluxedtrinkets.api;

import java.util.ArrayList;

public class FluxedTrinketsAPI {

	private static ArrayList<String> effectName = new ArrayList<String>();
	private static ArrayList<IEffect> effects = new ArrayList<IEffect>();

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
}
