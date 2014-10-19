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
	private String name;

	public ItemCircuit(String name, CircuitTier tier, IEffect effect) {
		this.name = effect.getName();
		this.tier = tier;
		this.effect = effect;
	}
	
	public ItemCircuit(String name, IEffect effect) {
		this(name, CircuitTier.basic, effect);
	}
	

	@Override
	public CircuitTier getTier() {
		return tier;
	}

	public IEffect getEffect() {
		return effect;
	}


}
