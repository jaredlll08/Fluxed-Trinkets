package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectWater extends BaseEffect {

	public EffectWater() {
		super("water");
	}


	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		int energyUsed = 0;
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			double x = player.posX;
			double y = player.posY;
			double z = player.posZ;

			if (player.isBurning()) {
				player.extinguish();
				energyUsed += ConfigProps.energyWater;
			}
			for (int rangeX = -5; rangeX < 5; rangeX++) {
				for (int rangeY = -2; rangeY < 2; rangeY++) {
					for (int rangeZ = -5; rangeZ < 5; rangeZ++) {
						if (player.worldObj.extinguishFire(player, (int) x + rangeX, (int) y + rangeY, (int) z + rangeZ, 0)) {
							energyUsed += ConfigProps.energyWater;
						}
					}
				}
			}
		}
		return energyUsed;
	}

	// @Override
	// public ArrayList<String> getDescription() {
	// ArrayList<String> list = new ArrayList<String>();
	// list.add("Extinguishes any nearby");
	// list.add("fires within a 5 block radius.");
	// return list;
	// }

}
