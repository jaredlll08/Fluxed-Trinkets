package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectAdvancedIce extends BaseEffect {

	public EffectAdvancedIce() {
		super("advancedIce");
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote) {

			entity.removePotionEffect(Potion.weakness.id);

			List<EntityCreature> entities = getEntitiesAround(entity, 8, EntityCreature.class);

			int energyUsed = 0;
			for (EntityCreature entityCreature : entities) {
				if (!entityCreature.isPotionActive(Potion.weakness) && hasEnergy(item, stack, ConfigProps.energyAdvancedIce + energyUsed)) {
					entityCreature.addPotionEffect(new PotionEffect(Potion.weakness.id, 400, 1));
					energyUsed += ConfigProps.energyAdvancedIce;
				}
			}
			return energyUsed;
		}
		return 0;
	}

//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Applied a weakness buff");
//		list.add("to nearby mobs.");
//		return list;
//	}
}
