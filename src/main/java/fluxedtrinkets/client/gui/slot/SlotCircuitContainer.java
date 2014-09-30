package fluxedtrinkets.client.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fluxedtrinkets.items.ItemCircuit;

public class SlotCircuitContainer extends Slot {

	public SlotCircuitContainer(IInventory arg0, int arg1, int arg2, int arg3) {
		super(arg0, arg1, arg2, arg3);
	}


	@Override
	public boolean isItemValid(ItemStack stack) {

		if (stack.getItem() instanceof ItemCircuit) {
			return true;

		}

		return false;
	}

}
