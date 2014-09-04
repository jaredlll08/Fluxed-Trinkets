package com.jared.electrifiedtrinkets.client.render.gui;


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

		GuiEManual.addText("trinkets.0");
		GuiEManual.addChapter("", -1);
		GuiEManual.addChapter("", -2);
		GuiEManual.addText("The trinkets in Electrified Trinkets are completely modular!");

	}

	public static void CircuitsChapters() {
		GuiEManual.addText("category.circuits.0");
		GuiEManual.addChapter("", -3);
		GuiEManual.addChapter("", -4);

		GuiEManual.addChapter("category.circuits.1", 17);
		GuiEManual.addChapter("category.circuits.2", 18);

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
		GuiEManual.addText("circuits.top.0");
		GuiEManual.addChapter("", -4);
		GuiEManual.addChapter("", -5);
		GuiEManual.addChapter("circuits.0", 19);
		GuiEManual.addChapter("circuits.1", 20);
		GuiEManual.addChapter("circuits.2", 12);
		GuiEManual.addChapter("circuits.3", 22);
		GuiEManual.addChapter("circuits.4", 23);
	}

	public static void AdvancedCircuits() {
		GuiEManual.addText("circuits.top.1");
		GuiEManual.addChapter("", -6);
		GuiEManual.addChapter("", -7);
		GuiEManual.addChapter("circuits.advanced.0", 24);
		GuiEManual.addChapter("circuits.advanced.1", 25);
		GuiEManual.addChapter("circuits.advanced.2", 26);
		GuiEManual.addChapter("circuits.advanced.3", 27);
		GuiEManual.addChapter("circuits.advanced.4", 28);
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

}
