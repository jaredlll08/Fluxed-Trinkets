package fluxedtrinkets.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fluxedtrinkets.proxy.ClientProxy;

public class ItemManual extends Item {

	public ItemManual() {
		this.setMaxStackSize(1);
		this.setFull3D();
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			ClientProxy.openManual();
		}
		
		return stack;
	}

}
