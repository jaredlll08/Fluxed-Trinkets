package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectAdvancedLava extends BaseEffect {

	public EffectAdvancedLava() {
		super("advancedLava");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
			
			List<EntityCreature> entities = getEntitiesAround(entity, 8, EntityCreature.class);

			for (EntityCreature entityCreature : entities) {
				if (!entityCreature.isBurning() && hasEnergy(item, stack, ConfigProps.energyAdvancedLava)) {
					entityCreature.setFire(80);
					return ConfigProps.energyAdvancedLava;
				}
			}
		}
		return 0;
	}
}
