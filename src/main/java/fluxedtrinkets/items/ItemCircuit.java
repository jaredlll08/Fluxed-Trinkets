package fluxedtrinkets.items;

import java.util.List;

import fluxedtrinkets.api.CircuitTiers;
import fluxedtrinkets.api.ICircuit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCircuit extends Item implements ICircuit{
	String effect;

	public ItemCircuit(String effect) {
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.effect = effect;
	}
	
	@Override
	public CircuitTiers getTier() {
		return CircuitTiers.basic;
	}

	public String getEffect() {
		return effect;
	}

	

}
