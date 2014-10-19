package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectAdvancedLava extends BaseEffect {

	public EffectAdvancedLava() {
		super("advancedLava", EffectProps.energyAdvancedLava);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
			
			List<EntityCreature> entities = getEntitiesAround(entity, 8, EntityCreature.class);

			for (EntityCreature entityCreature : entities) {
				if (!entityCreature.isBurning() && hasEnergy(item, stack, getUsage())) {
					entityCreature.setFire(80);
					return getUsage();
				}
			}
		}
		return 0;
	}
	@Override
	public void onPowerEmpty(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.setFire(80);
	}

}
