package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectEarth extends BaseEffect {

	public EffectEarth() {
		super("earth", EffectProps.energyEarth);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
			if (hasEnergy(item, stack, getUsage())) {
				entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
				entity.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 400, 1));
				return getUsage();
			}
		}
		return 0;
	}
}
