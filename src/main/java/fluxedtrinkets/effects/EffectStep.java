package fluxedtrinkets.effects;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import fluxedtrinkets.api.IEffect;
import fluxedtrinkets.config.ConfigProps;

public class EffectStep extends BaseEffect {

	@Override
	public String getName() {
		return "step";
	}

	@Override
	public int getUsage() {
		return ConfigProps.energyStep;
	}

	@Override
	public boolean hasEquipEffect() {
		return true;
	}

	@Override
	public void onEquipped(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).stepHeight = 1.0F;
		}
	}

	@Override
	public void onRemoved(World world, ItemStack stack, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).stepHeight = 0.50001F;
		}
	}

	@Override
	public boolean onWornTick(World world, ItemStack stack, EntityLivingBase entity) {
		if (world.rand.nextInt(400) == 0) {
			if (stack.stackTagCompound == null) {
				stack.stackTagCompound = new NBTTagCompound();
			}
			stack.stackTagCompound.setInteger("energy", stack.stackTagCompound.getInteger("energy") - getUsage());
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
		list.add("Allows the player to walk");
		list.add("up 1-high blocks.");
		return list;
	}
}
