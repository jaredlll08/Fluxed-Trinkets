package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectEarth extends BaseEffect {

	public EffectEarth() {
		super("earth");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {
			if (hasEnergy(item, stack, ConfigProps.energyEarth) && entity.posY < 32 && entity.worldObj.rand.nextInt(600) == 0) {
				entity.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
				entity.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 400, 1));
				return ConfigProps.energyEarth;
			}
		}
		return 0;
	}
	
//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("while the player is below y=32");
//		list.add("a haste buff is applied to them.");
//		return list;
//	}
}
