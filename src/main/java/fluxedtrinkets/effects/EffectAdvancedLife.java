package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.config.ConfigProps;

public class EffectAdvancedLife implements IEffect {

	@Override
	public String getEffectName() {
		return "advancedLife";
	}

	@Override
	public int getUsage() {
		return ConfigProps.energyAdvancedLife;
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
			List<EntityTameable> entities = player.worldObj.getEntitiesWithinAABB(EntityTameable.class, AxisAlignedBB.getBoundingBox(x - 8, y - 2, z - 8, x + 8, y + 2, z + 8));
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
	public boolean canEquip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(World world, ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public ArrayList<String> getDescription() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Heals any nearby pets");
		return list;
	}

}
