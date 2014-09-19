package fluxedtrinkets.client.render.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import fluxedtrinkets.client.render.gui.slot.SlotAddon;
import fluxedtrinkets.client.render.gui.slot.SlotCircuit;
import fluxedtrinkets.client.render.gui.slot.SlotCopperNugget;
import fluxedtrinkets.client.render.gui.slot.SlotLeadWire;
import fluxedtrinkets.client.render.gui.slot.SlotSolderingIron;
import fluxedtrinkets.tileEntity.TileEntitySolderingStation;

public class ContainerSolderingStation extends Container {

	public ContainerSolderingStation(InventoryPlayer invPlayer, TileEntitySolderingStation solderingStation) {
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
			}
		}

		addSlotToContainer(new SlotSolderingIron(solderingStation, 0, 8, 62));
		addSlotToContainer(new SlotCircuit(solderingStation, 1, 80, 62));
		addSlotToContainer(new SlotLeadWire(solderingStation, 2, 152, 62));

		addSlotToContainer(new SlotAddon(solderingStation, 3, 5, 5));
		addSlotToContainer(new SlotAddon(solderingStation, 4, 5, 23));
		addSlotToContainer(new SlotAddon(solderingStation, 5, 23, 5));
		addSlotToContainer(new SlotAddon(solderingStation, 6, 23, 23));

		addSlotToContainer(new SlotCopperNugget(solderingStation, 7, 137, 5));
		addSlotToContainer(new SlotCopperNugget(solderingStation, 8, 155, 5));
		addSlotToContainer(new SlotCopperNugget(solderingStation, 9, 119, 23));
		addSlotToContainer(new SlotCopperNugget(solderingStation, 10, 137, 23));
		addSlotToContainer(new SlotCopperNugget(solderingStation, 11, 155, 23));
		addSlotToContainer(new SlotCopperNugget(solderingStation, 12, 137, 41));
		addSlotToContainer(new SlotCopperNugget(solderingStation, 13, 155, 41));

	}

	@Override
	public boolean canInteractWith(EntityPlayer arg0) {
		return true;

	}

	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

}
