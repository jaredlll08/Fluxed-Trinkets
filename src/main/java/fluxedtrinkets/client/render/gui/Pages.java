package fluxedtrinkets.client.render.gui;

public class Pages {

	public static void mainPage() {
		GuiEManual.addChapter("title.0", 0);
		GuiEManual.addChapter("title.1", 1);
		GuiEManual.addChapter("title.2", 2);
		
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

		GuiEManual.addChapter("", -1);
		GuiEManual.addChapter("", -2);
		GuiEManual.addText("trinkets.1");

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
