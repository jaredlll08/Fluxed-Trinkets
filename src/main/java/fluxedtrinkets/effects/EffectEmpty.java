package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;

public class EffectEmpty extends BaseEffect {

	public EffectEmpty() {
		super("empty");
	}

	// public ArrayList<String> getDescription() {
	// ArrayList<String>list = new ArrayList<String>();
	// list.add("No Effect.");
	// return list;
	// }

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		return 0;
	}
}
