package fluxedtrinkets.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.client.gui.slot.SlotCircuit;
import fluxedtrinkets.client.gui.slot.SlotTrinket;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class ContainerTrinketAssembler extends Container {

	public ContainerTrinketAssembler(InventoryPlayer invPlayer, TileEntityTrinketAssembler tile) {
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}
		
		addSlotToContainer(new SlotTrinket(tile, 0, 80, 34));
		
		addSlotToContainer(new SlotCircuit(tile, 1, 5, 5));
		addSlotToContainer(new SlotCircuit(tile, 2, 155, 5));
		addSlotToContainer(new SlotCircuit(tile, 3, 5, 65));
		addSlotToContainer(new SlotCircuit(tile, 4, 155, 65));

	}

	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return true;

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		return null;
	}

}