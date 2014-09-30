package fluxedtrinkets.api;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class FluxedTrinketsAPI {

	private static ArrayList<String> effectNames = new ArrayList<String>();
	private static ArrayList<IEffect> effects = new ArrayList<IEffect>();

	/**
	 * Adds an effect to the effect list.
	 * 
	 * @param effect
	 */
	public static void addEffect(IEffect effect) {
		if (!hasEffect(effect) && !hasEffect(effect.getName())) {
			effects.add(effect);
			effectNames.add(effect.getName());
		}
	}

	/**
	 * Gets the List of effects.
	 * 
	 * @return a list of effects
	 */
	public static ArrayList<String> getEffectNames() {
		return effectNames;
	}
	
	public static int getEffectAmount() {
		return effects.size();
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
		return effectNames.contains(effect);
	}

	/**
	 * Checks if an effect exists in the effect list.
	 * 
	 * @param effect
	 * @return
	 */
	public static boolean hasEffect(IEffect effect) {
		return effects.contains(effect);
	}

	/**
	 * 
	 * @param name
	 * @return The effect that has the name provided
	 */
	public static IEffect getEffectFromName(String name) {
		for (int i = 0; i < effects.size(); i++) {
			if (effects.get(i).getName().equals(name)) {
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
		return effect.getName();
	}

}
