package fluxedtrinkets.client.render.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.api.ICircuit;
import fluxedtrinkets.items.ItemCircuit;

public class SlotCircuit extends Slot {

	public SlotCircuit(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public int getSlotStackLimit() {
		return 1;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {

		if (stack.getItem() instanceof ICircuit) {
			return true;

		}

		return false;
	}

}
