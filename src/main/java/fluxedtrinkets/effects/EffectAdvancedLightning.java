package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectAdvancedLightning implements IEffect {

	@Override
	public String getEffectName() {
		return "advancedLightning";
	}

	@Override
	public int getUsage() {
		return 30;
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

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			double x = player.posX;
			double y = player.posY;
			double z = player.posZ;

			List<EntityLightningBolt> bolts = player.worldObj.getEntitiesWithinAABB(EntityLightningBolt.class, AxisAlignedBB.getBoundingBox(x - 48, y - 48, z - 48, x + 48, y + 48, z + 48));
			for (EntityLightningBolt bolt : bolts) {
				if (!player.worldObj.isRemote) {
					player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 1, true));
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 1, true));
				}
			}
		}

		return false;
	}

	@Override
	public boolean canEquip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	
}
