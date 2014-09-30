package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;
import fluxedtrinkets.util.EffectHelper;

public class EffectFire extends BaseEffect {

	public EffectFire() {
		super("fire");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			int powerUsed = 0;
			if (player.isBurning() && hasEnergy(item, stack, ConfigProps.energyFire)) {
				player.extinguish();
				powerUsed += ConfigProps.energyFire;
			}
			
			if (hasEnergy(item, stack, ConfigProps.energyFire + powerUsed)) {
				EffectHelper.setFireImmune(entity, true);
				powerUsed += ConfigProps.energyFire; // TODO find a better way to draw power
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
	
//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Makes the player");
//		list.add("immune to heat.");
//		return list;
//	}
}
