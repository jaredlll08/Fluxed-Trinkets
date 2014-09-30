package fluxedtrinkets.client.gui;

import fluxedtrinkets.client.gui.slot.SlotAddon;
import fluxedtrinkets.client.gui.slot.SlotCircuit;
import fluxedtrinkets.client.gui.slot.SlotCopperNugget;
import fluxedtrinkets.client.gui.slot.SlotLeadWire;
import fluxedtrinkets.client.gui.slot.SlotSolderingIron;
import fluxedtrinkets.tileEntity.TileEntityCompressor;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityCommandBlock;

public class ContainerCompressor extends Container{
	
	
	public ContainerCompressor(InventoryPlayer invPlayer, TileEntityCompressor compressor) {
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}

		
		addSlotToContainer(new Slot(compressor, 0, 56, 26));
		addSlotToContainer(new Slot(compressor, 1, 8, 53));
		addSlotToContainer(new Slot(compressor, 2, 116, 35));
		
		

	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

	
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        return null;
    }
}
