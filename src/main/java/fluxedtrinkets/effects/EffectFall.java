package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectFall extends BaseEffect {

	public EffectFall() {
		super("fall");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			if (!player.onGround && player.motionY < 0 && !player.isSneaking()) {
				player.motionY = -0.1;
				player.fallDistance = -1;
				return ConfigProps.energyFall;
			}
		}
		return 0;
	}

//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("while the player is not");
//		list.add("holding shift, the player");
//		list.add("will fall slower than normal.");
//		return list;
//	}
}
