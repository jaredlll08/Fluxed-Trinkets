package fluxedtrinkets.effects;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectAdvancedLife implements IEffect {

	@Override
	public String getEffectName() {
		return "advancedLife";
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			double x = player.posX;
			double y = player.posY;
			double z = player.posZ;
			List<EntityTameable> entities = player.worldObj.getEntitiesWithinAABB(EntityTameable.class, AxisAlignedBB.getBoundingBox(x - 8, y - 8, z - 8, x + 8, y + 8, z + 8));
			for (EntityTameable entityTame : entities) {
				if (!player.worldObj.isRemote) {
					if (player.worldObj.rand.nextInt(60) == 0 && entityTame.isTamed()) {
						entityTame.heal(1);
						return true;
					}
				}
			}
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
