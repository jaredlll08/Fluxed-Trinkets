package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;

public class EffectAdvancedEmpty extends BaseEffect {

	public EffectAdvancedEmpty() {
		super("advancedEmpty");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		return 0;
	}
}
