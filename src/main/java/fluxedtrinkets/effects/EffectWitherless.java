package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.config.Property;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectWitherless extends BaseEffect {

	public EffectWitherless() {
		super("witherless", EffectProps.energyWither);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {

		if (!entity.worldObj.isRemote)
			if (entity.isPotionActive(Potion.wither)) {
				entity.removePotionEffect(Potion.wither.id);
				return getUsage();
			}

		return 0;
	}
}
