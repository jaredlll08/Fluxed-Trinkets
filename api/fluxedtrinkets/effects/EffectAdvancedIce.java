package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectAdvancedIce implements IEffect {

	@Override
	public String getEffectName() {
		return "advancedIce";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			double x = player.posX;
			double y = player.posY;
			double z = player.posZ;
			player.removePotionEffect(Potion.weakness.id);
			List<EntityCreature> entities = player.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(x - 8, y - 8, z - 8, x + 8, y + 8, z + 8));
			for (EntityCreature entityCreature : entities) {
				if (!player.worldObj.isRemote) {
					if (!entityCreature.isPotionActive(Potion.weakness)) {
						entityCreature.addPotionEffect(new PotionEffect(Potion.weakness.id, 400, 1));
						return true;
					}
				}
			}
			return true;
		}
		return false;
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
}
