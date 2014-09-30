package fluxedtrinkets.items;

import java.util.Random;

import net.minecraft.item.Item;
import fluxedtrinkets.api.CircuitTier;
import fluxedtrinkets.api.FluxedTrinketsAPI;
import fluxedtrinkets.api.ICircuit;
import fluxedtrinkets.api.IEffect;

public class ItemCircuit extends Item implements ICircuit {
	
	private IEffect effect;
	private CircuitTier tier;

	public ItemCircuit(String effect, CircuitTier tier) {
		this.effect = FluxedTrinketsAPI.getEffectFromName(effect);
		this.tier = tier;
	}
	
	public ItemCircuit(String effect) {
		this(effect, CircuitTier.basic);
	}

	@Override
	public CircuitTier getTier() {
		return tier;
	}

	public IEffect getEffect() {
		if (effect.equals("random")) {
			return FluxedTrinketsAPI.getEffects().get(new Random().nextInt(FluxedTrinketsAPI.getEffects().size()));
		}
		return effect;
	}

}
