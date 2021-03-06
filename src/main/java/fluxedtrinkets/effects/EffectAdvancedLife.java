package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectAdvancedLife extends BaseEffect {

	public EffectAdvancedLife() {
		super("advancedLife", EffectProps.energyAdvancedLife);
	}

	@Override
	public String getName() {
		return "advancedLife";
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {

			List<EntityTameable> entities = getEntitiesAround(entity, 8, EntityTameable.class);

			for (EntityTameable entityTame : entities) {

				if (entity.worldObj.rand.nextInt(60) == 0 && entityTame.isTamed() && hasEnergy(item, stack, getUsage())) {
					entityTame.heal(1);
					return getUsage();
				}
			}
		}
		return 0;
	}

	@Override
	public void onPowerEmpty(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {

			List<EntityTameable> entities = getEntitiesAround(entity, 8, EntityTameable.class);

			for (EntityTameable entityTame : entities) {

				if (entity.worldObj.rand.nextInt(60) == 0 && entityTame.isTamed() && hasEnergy(item, stack, getUsage())) {
					entityTame.setHealth(entityTame.getHealth() - 0.5F);
				}
			}
		}
	}

}
