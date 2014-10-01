package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectAdvancedLightning extends BaseEffect{

	public EffectAdvancedLightning() {
		super("advancedLightning", EffectProps.energyAdvancedLightning);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (entity.worldObj.isRemote) {

			List<EntityLightningBolt> bolts = getEntitiesAround(entity, 48, EntityLightningBolt.class);

			if (!bolts.isEmpty() && hasEnergy(item, stack, getUsage())) {
				entity.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 1, true));
				entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 1, true));
				return getUsage();
			}
		}

		return 0;
	}
}
