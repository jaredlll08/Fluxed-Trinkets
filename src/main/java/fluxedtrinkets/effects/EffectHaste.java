package fluxedtrinkets.effects;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectHaste extends BaseEffect {

    private static final AttributeModifier speedMod = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed",  0.3f, 1);

	public EffectHaste() {
		super("haste");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
            IAttributeInstance moveInst = entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed);
            moveInst.removeModifier(speedMod);
                        
            if (hasEnergy(item, stack, ConfigProps.energyHaste)) {
                moveInst.applyModifier(speedMod);
            } else {
            	return 0;
            }

			if (entity.onGround && isMoving(entity)) {
                return ConfigProps.energyHaste;
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
	
//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("While the wearer is");
//		list.add("on the ground they gain");
//		list.add("a speed boost.");
//		return list;
//	}
}
