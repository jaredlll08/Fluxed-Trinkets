package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cofh.api.energy.IEnergyContainerItem;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.config.ConfigProps;

public class EffectHaste implements IEffect {

    private static final AttributeModifier speedMod = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed",  0.3f, 1);

	@Override
	public String getEffectName() {
		return "haste";
	}

	@Override
	public int getUsage() {
		return ConfigProps.energyHaste;
	}

	@Override
	public boolean hasEquipEffect() {
		return true;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {

	}

	@Override
	public void onUnEquipped(World world, ItemStack stack, EntityLivingBase entity) {
	    entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).removeModifier(speedMod);
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer && !world.isRemote) {
			EntityPlayer player = (EntityPlayer) entity;
            IAttributeInstance moveInst = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed);
            moveInst.removeModifier(speedMod);
            
            boolean hasPower = ((IEnergyContainerItem)stack.getItem()).getEnergyStored(stack) > 0;
            
            if (hasPower) {
                moveInst.applyModifier(speedMod);
            }

			if (player.onGround && isMoving(player)) {
                return true;
			}
		}
		return false;
	}

	private boolean isMoving(EntityPlayer player)
	{
	    return Math.abs(player.distanceWalkedModified - player.prevDistanceWalkedModified) > 0;
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
		list.add("While the wearer is");
		list.add("on the ground they gain");
		list.add("a speed boost.");
		return list;
	}

}
