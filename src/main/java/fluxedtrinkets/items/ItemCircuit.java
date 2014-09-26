package fluxedtrinkets.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import fluxedtrinkets.api.CircuitTiers;
import fluxedtrinkets.api.FluxedTrinketsAPI;
import fluxedtrinkets.api.ICircuit;

public class ItemCircuit extends Item implements ICircuit {
	String effect;

	public ItemCircuit(String effect) {
		this.effect = effect;
	}

	@Override
	public CircuitTiers getTier() {
		return CircuitTiers.basic;
	}

	public String getEffect() {
		if (effect.equals("random")) {
			return FluxedTrinketsAPI.getEffectNames().get(new Random().nextInt(FluxedTrinketsAPI.getEffectNames().size()));
		}
		return effect;
	}

}
