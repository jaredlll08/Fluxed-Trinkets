package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;

public class EffectEmpty extends BaseEffect {

	public EffectEmpty() {
		super("empty");
	}
	
	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		return 0;
	}
}
