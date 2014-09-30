package fluxedtrinkets.effects;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ITrinket;
import fluxedtrinkets.config.ConfigProps;

public class EffectAir extends BaseEffect {

	public EffectAir() {
		super("air");
	}
	
	@Override
	public int onWornTick(ItemStack stack, EntityLivingBase entity, ITrinket item) {
		if (entity instanceof EntityPlayer && !entity.worldObj.isRemote) {
			EntityPlayer player = (EntityPlayer) entity;
			if (hasEnergy(item, stack, ConfigProps.energyAir) && isPlayerInAir(player)) {
				player.moveFlying(0F, 1F, player.capabilities.isFlying ? 0.02F : 0.02F * 2);
				return ConfigProps.energyAir;
			}
		}
		return 0;
	}
	
	private boolean isPlayerInAir(EntityPlayer player) {
		return !player.onGround && player.moveForward > 0F && !player.isInWater() && !player.isInsideOfMaterial(Material.web) && !player.isInsideOfMaterial(Material.lava);
	}

//	@Override
//	public ArrayList<String> getDescription() {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Allows the player to move");
//		list.add("faster while airborne.");
//		return list;
//	}
}
