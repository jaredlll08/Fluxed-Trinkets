package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.config.Property;
import fluxedtrinkets.api.BaseEffect;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.EffectProps;
import fluxedtrinkets.potion.BaublePotionHelper;
import fluxedtrinkets.potion.BaublesPotionEffect;

public class EffectHealth extends BaseEffect {

	public EffectHealth() {
		super("health", EffectProps.energyHealth);
	}

	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote)
			if (!entity.isPotionActive(Potion.field_76434_w))
				BaublePotionHelper.addPotionEffect((EntityPlayer) entity, new BaublesPotionEffect(Potion.field_76434_w.id, 4));
		if(entity.worldObj.getWorldTime()%200==0){
			return 600;
		}
		return 0;
	}

	public void onUnequipped(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote)
			BaublePotionHelper.removePotionEffect((EntityPlayer) entity, new BaublesPotionEffect(Potion.field_76434_w.id, 4));
	}

	public void onEquipped(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (!entity.worldObj.isRemote)
			BaublePotionHelper.addPotionEffect((EntityPlayer) entity, new BaublesPotionEffect(Potion.field_76434_w.id, 4));
	}
}
