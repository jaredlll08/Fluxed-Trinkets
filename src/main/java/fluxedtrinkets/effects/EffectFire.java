package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;
import fluxedtrinkets.util.EffectHelper;

public class EffectFire extends BaseEffect {

	public EffectFire() {
		super("fire", EffectProps.energyFire);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			int powerUsed = 0;
			if (player.isBurning() && hasEnergy(item, stack, getUsage())) {
				player.extinguish();
				powerUsed += getUsage();
			}

			if (hasEnergy(item, stack, getUsage())) {
				EffectHelper.setFireImmune(entity, true);
				powerUsed += getUsage();
			} else {
				EffectHelper.setFireImmune(entity, false);
			}
			return powerUsed;
		}
		return 0;
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		EffectHelper.setFireImmune(entity, false);
	}

	@Override
	public void onPowerEmpty(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.setFire(entity.worldObj.rand.nextInt(100));
	}

}
