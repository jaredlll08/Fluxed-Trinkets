package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectStep extends BaseEffect {

	private static final float defaultStep = 0.50001F;
	
	public EffectStep() {
		super("step", EffectProps.energyStep);
	}

	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.stepHeight = 1.0F;
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.stepHeight = defaultStep;
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
			if (hasEnergy(item, stack, getUsage())) {
				return entity.worldObj.getTotalWorldTime() % 400 == 0 ? getUsage() : 0;
			} else {
				entity.stepHeight = defaultStep;
			}
		}
		return 0;
	}
}
