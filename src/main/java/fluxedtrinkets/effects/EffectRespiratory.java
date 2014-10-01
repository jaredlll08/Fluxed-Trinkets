package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectRespiratory extends BaseEffect {

	public EffectRespiratory() {
		super("respiratory");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote && entity.worldObj.getTotalWorldTime() % 20 == 0) {
			if (entity.isInWater()) {
				entity.setAir(0);
				return ConfigProps.energyWater;
			}
		}

		return 0;
	}
}
