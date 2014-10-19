package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectRespiratory extends BaseEffect {

	public EffectRespiratory() {
		super("respiratory", EffectProps.energyRespiratory);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote && entity.worldObj.getTotalWorldTime() % 20 == 0) {
			if (entity.isInWater()) {
				entity.setAir(0);
				return getUsage();
			}
		}

		return 0;
	}
	@Override
	public void onPowerEmpty(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.motionY=0.2;
	}

}
