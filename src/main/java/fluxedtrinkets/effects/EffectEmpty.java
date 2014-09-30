package fluxedtrinkets.effects;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.api.ITrinket;

public class EffectEmpty extends BaseEffect {

	public EffectEmpty(String name) {
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
