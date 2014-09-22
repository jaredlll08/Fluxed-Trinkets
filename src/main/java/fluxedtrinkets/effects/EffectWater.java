package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;

public class EffectWater implements IEffect {

	@Override
	public String getEffectName() {
		return "water";
	}
	
	@Override
	public int getUsage() {
		return 10;
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
			
					
			if (player.isBurning()) {
				player.extinguish();
			}
			for (int rangeX = -5; rangeX < 5; rangeX++) {
				for (int rangeY = -2; rangeY < 2; rangeY++) {
					for (int rangeZ = -5; rangeZ < 5; rangeZ++) {
							player.worldObj.extinguishFire(player, (int) x + rangeX, (int) y + rangeY, (int) z + rangeZ, 0);
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


}
