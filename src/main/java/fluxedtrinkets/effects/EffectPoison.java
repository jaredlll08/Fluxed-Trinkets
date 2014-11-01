package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.config.Property;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectPoison extends BaseEffect {

	public EffectPoison() {
		super("poisionless", EffectProps.energyPoison);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {

		if (!entity.worldObj.isRemote)
			if (entity.isPotionActive(Potion.poison)) {
				entity.removePotionEffect(Potion.poison.id);
				return getUsage();
			}

		return 0;
	}
}
