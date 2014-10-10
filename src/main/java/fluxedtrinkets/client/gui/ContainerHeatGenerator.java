package fluxedtrinkets.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.tileEntity.TileEntityHeatGenerator;

public class ContainerHeatGenerator extends Container {

	public ContainerHeatGenerator(InventoryPlayer invPlayer, TileEntityHeatGenerator compressor) {
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}

		addSlotToContainer(new Slot(compressor, 0, 81, 32));

	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		return null;
	}
}
