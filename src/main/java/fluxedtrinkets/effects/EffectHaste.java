package fluxedtrinkets.effects;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;

public class EffectHaste extends BaseEffect {

    private static final AttributeModifier speedMod = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed",  0.3f, 1);

	public EffectHaste() {
		super("haste", EffectProps.energyHaste);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
            IAttributeInstance moveInst = entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed);
            moveInst.removeModifier(speedMod);
                        
            if (hasEnergy(item, stack, getUsage())) {
                moveInst.applyModifier(speedMod);
            } else {
            	return 0;
            }

			if (entity.onGround && isMoving(entity)) {
                return getUsage();
			}
		}
		return 0;
	}

	private boolean isMoving(EntityLivingBase entity) {
		return Math.abs(entity.distanceWalkedModified - entity.prevDistanceWalkedModified) > 0;
	}

	public void onUnequipped(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).removeModifier(speedMod);
	}
}
