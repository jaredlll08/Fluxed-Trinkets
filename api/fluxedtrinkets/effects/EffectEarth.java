package fluxedtrinkets.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectEarth implements IEffect {

	@Override
	public String getEffectName() {
		return "earth";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (player.posY < 32) {
				if (player.worldObj.rand.nextInt(600) == 0) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
					player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 400, 1));
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	@Override
	public int getUsage() {
		return 25;
	}
	@Override
	public boolean hasEquipEffect() {
		return false;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		
	}

	@Override
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		
	}
}
