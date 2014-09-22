package fluxedtrinkets.items.equipment;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.StringUtils;

public class ItemRingFarming extends ModRing {

	public ItemRingFarming(int maxCapacity, int usage) {
		super(maxCapacity, usage);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(StringUtils.BRIGHT_GREEN + "A ring for the modern farmer!");
		super.addInformation(stack, player, list, par4);

	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.stackTagCompound.getInteger("energy") < -1) {
			itemstack.stackTagCompound.setInteger("energy", 0);
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
