package com.jared.electrifiedtrinkets.client.render.gui;

import java.util.ArrayList;

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
		GuiEManual.addChapter("trinkets.1", 3);
		GuiEManual.addChapter("trinkets.2", 4);
		GuiEManual.addChapter("trinkets.3", 5);

	}

	public static void CircuitsChapters() {
		GuiEManual.addText("category.circuits.0");
		GuiEManual.addChapter("", -3);
		GuiEManual.addChapter("", -4);

		GuiEManual.addChapter("category.circuits.1", 17);
		GuiEManual.addChapter("category.circuits.2", 18);

	}

	public static void Amulets() {
		GuiEManual.addChapter("amulets.0", 6);
		GuiEManual.addChapter("amulets.1", 7);
	}

	public static void Belts() {
		GuiEManual.addChapter("belt.0", 8);
		GuiEManual.addChapter("belt.1", 9);
		GuiEManual.addChapter("belt.2", 10);
		GuiEManual.addChapter("belt.3", 11);
		GuiEManual.addChapter("belt.4", 12);
		GuiEManual.addChapter("belt.5", 13);
	}

	public static void Rings() {
		GuiEManual.addChapter("ring.0", 14);
		GuiEManual.addChapter("ring.1", 15);
		GuiEManual.addChapter("ring.2", 16);
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

	public static void ResipratoryAmulet() {
		GuiEManual.addText("amulets.1");
		GuiEManual.addText("");
		GuiEManual.addText("amulet.respiratory.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("amulet.respiratory.recipe");
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

	public static void BeltHasty() {
		GuiEManual.addText("belt.1");
		GuiEManual.addText("");
		GuiEManual.addText("belt.hasty.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("belt.hasty.recipe");

	}

	public static void BeltScorched() {
		GuiEManual.addText("belt.2");
		GuiEManual.addText("");
		GuiEManual.addText("belt.scorched.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("belt.scorched.recipe");
	}

	public static void BeltChilling() {
		GuiEManual.addText("belt.3");
		GuiEManual.addText("");
		GuiEManual.addText("belt.chilling.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("belt.chilling.recipe");
	}

	public static void BeltSprung() {
		GuiEManual.addText("belt.4");
		GuiEManual.addText("");
		GuiEManual.addText("belt.sprung.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("belt.sprung.recipe");
	}

	public static void BeltPacing() {
		GuiEManual.addText("belt.5");
		GuiEManual.addText("");
		GuiEManual.addText("belt.pacing.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("belt.pacing.recipe");
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

	public static void RingMining() {
		GuiEManual.addText("ring.1");
		GuiEManual.addText("");
		GuiEManual.addText("ring.mining.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("ring.mining.recipe");
	}
	
	public static void RingFarming() {
		GuiEManual.addText("ring.2");
		GuiEManual.addText("");
		GuiEManual.addText("ring.farming.info");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("ring.farming.recipe");
	}

}
