package com.jared.fluxedtrinkets.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @author dmillerw
 */
public class BaublesPotionEffect extends PotionEffect {

	public BaublesPotionEffect(int id, int amplifier) {
		super(id, Integer.MAX_VALUE, amplifier, true);
	}

	@Override
	public boolean onUpdate(EntityLivingBase par1EntityLivingBase) {
		if (getDuration() > 0) {
			if (Potion.potionTypes[getPotionID()].isReady(getDuration(), getAmplifier())) {
				this.performEffect(par1EntityLivingBase);
			}
		}

		return true;
	}

	@Override
	public boolean getIsPotionDurationMax() {
		return true;
	}

	@Override
	public void combine(PotionEffect effect) {
		// NO COMBINING
	}

	@Override
	public boolean isCurativeItem(ItemStack stack) {
		// NO CURING
		return false;
	}
}