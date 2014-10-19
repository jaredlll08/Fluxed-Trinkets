package fluxedtrinkets.client.gui;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.CraftingManager;

public class Pages {

	public static void mainPage() {
		GuiEManual.addChapter("title.0", 0);
		GuiEManual.addChapter("title.1", 1);
		GuiEManual.addChapter("title.2", 2);
		GuiEManual.addChapter("title.3", 18);
	}

	public static void effectType() {
		GuiEManual.addText("effects.category.0");
		GuiEManual.addChapter("", -1);
		GuiEManual.addChapter("effects.category.1", 19);
		GuiEManual.addChapter("effects.category.2", 20);
	}

	public static void basicEffects() {
		GuiEManual.addText("effects.category.1");
		GuiEManual.addChapter("", -1);
		GuiEManual.addChapter("", -2);
		GuiEManual.addChapter("effects.single.0", 21);
		GuiEManual.addChapter("effects.single.1", 22);
		GuiEManual.addChapter("effects.single.2", 23);
		GuiEManual.addChapter("effects.single.3", 24);
		GuiEManual.addChapter("effects.single.4", 25);
		GuiEManual.addChapter("effects.single.5", 26);
		GuiEManual.addChapter("effects.single.6", 27);
		GuiEManual.addChapter("effects.single.7", 28);
	}

	public static void comboEffects() {
		GuiEManual.addText("effects.category.2");
		GuiEManual.addChapter("", -1);
		GuiEManual.addChapter("", -2);
		GuiEManual.addChapter("effects.combo.0", 29);
		GuiEManual.addChapter("effects.combo.1", 30);
		GuiEManual.addChapter("effects.combo.2", 31);
		GuiEManual.addChapter("effects.combo.3", 32);
		GuiEManual.addChapter("effects.combo.4", 33);

	}

	public static void introductionText() {
		GuiEManual.addText("intro.0");
		GuiEManual.addText("intro.1");
		GuiEManual.addText("");
		GuiEManual.addText("intro.2");

		GuiEManual.addText("");
		GuiEManual.addText("intro.3");

	}

	public static void TrinketsChapters() {
		GuiEManual.addText("trinkets.0");
	}

	public static void CircuitsChapters() {
		GuiEManual.addText("circuits.category.0");
		GuiEManual.addChapter("", -3);
		GuiEManual.addChapter("", -4);

		GuiEManual.addChapter("circuits.category.1", 3);
		GuiEManual.addChapter("circuits.category.2", 4);
		GuiEManual.addChapter("circuits.category.3", 15);
		GuiEManual.addChapter("circuits.category.4", 16);
		GuiEManual.addChapter("circuits.category.5", 17);

	}

	public static void SolderingIron() {
		GuiEManual.addText("circuits.category.4");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("soldering.iron.info");
	}

	public static void LeadWire() {
		GuiEManual.addText("circuits.category.5");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("wire.lead.info");
	}

	public static void EmptyAmulet() {
		GuiEManual.addText("amulets.0");
		GuiEManual.addText("");
		GuiEManual.addText("amulet.empty.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("amulet.empty.recipe");
	}

	public static void BasicCircuits() {
		GuiEManual.addText("circuits.category.1");
		GuiEManual.addChapter("", -4);
		GuiEManual.addChapter("", -5);
		GuiEManual.addChapter("circuits.0", 5);
		GuiEManual.addChapter("circuits.1", 6);
		GuiEManual.addChapter("circuits.2", 7);
		GuiEManual.addChapter("circuits.3", 8);
		GuiEManual.addChapter("circuits.4", 9);
	}

	public static void CircuitEmpty() {
		GuiEManual.addText("circuits.0");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("circuit.basic.0.info");
	}

	public static void AdvancedCircuits() {
		GuiEManual.addText("circuits.category.2");
		GuiEManual.addChapter("", -6);
		GuiEManual.addChapter("", -7);
		GuiEManual.addChapter("circuits.advanced.0", 10);
		GuiEManual.addChapter("circuits.advanced.1", 11);
		GuiEManual.addChapter("circuits.advanced.2", 12);
		GuiEManual.addChapter("circuits.advanced.3", 13);
		GuiEManual.addChapter("circuits.advanced.4", 14);
	}

	public static void BeltEmpty() {
		GuiEManual.addText("belt.0");
		GuiEManual.addText("");
		GuiEManual.addText("belt.empty.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("belt.empty.recipe");
	}

	public static void RingEmpty() {
		GuiEManual.addText("ring.0");
		GuiEManual.addText("");
		GuiEManual.addText("ring.empty.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("ring.empty.recipe");
	}

	public static void SolderingStation() {
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("soldering.station.info");
	}

	public static void AdvancedCircuit() {
		GuiEManual.addText("circuits.advanced.0");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("circuits.advanced.0.info");
	}

}
