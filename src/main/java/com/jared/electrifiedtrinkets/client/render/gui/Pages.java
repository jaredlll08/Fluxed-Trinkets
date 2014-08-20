package com.jared.electrifiedtrinkets.client.render.gui;

import java.util.ArrayList;

public class Pages {

	public static void mainPage() {
		GuiEManual.addChapter("Introduction", 0);
		GuiEManual.addChapter("Trinkets", 1);
		GuiEManual.addChapter("Crafting", 2);
	}

	public static void introductionText() {
		GuiEManual.addText("Welcome to Electrified-Trinkets!");
		GuiEManual.addText("Electrified-Trinkets is a mod that adds RF-Powered Baubles.");
		GuiEManual.addText("");
		GuiEManual.addText("Once the Baubles have ran out of power they stop working.");

		GuiEManual.addText("");
		GuiEManual.addText("This mod uses a very intricate crafting system but dont worry, this book will explain it all.");
	}

	public static void TrinketsChapters() {

		GuiEManual.addText("Baubles this mod adds: ");
		GuiEManual.addChapter("", -1);
		GuiEManual.addChapter("", -2);
		GuiEManual.addChapter("Amulets", 3);
		GuiEManual.addChapter("Belts", 4);
		GuiEManual.addChapter("Rings", 5);

	}

	public static void Amulets() {
		GuiEManual.addChapter("Empty Amulet", 6);
		GuiEManual.addChapter("Respiratory Amulet", 7);
	}

	public static void Belts() {
		GuiEManual.addChapter("Empty Belt", 8);
		GuiEManual.addChapter("Hasty Belt", 9);
		GuiEManual.addChapter("Scorched Belt", 10);
		GuiEManual.addChapter("Chilling Belt", 11);
		GuiEManual.addChapter("Sprung Belt", 12);
		GuiEManual.addChapter("Pacing Belt", 13);
	}

	public static void Rings() {
		GuiEManual.addChapter("Empty Ring", 14);
		GuiEManual.addChapter("Excavation Ring", 15);
		GuiEManual.addChapter("Farmers Ring", 16);
	}

	public static void EmptyAmulet() {
		GuiEManual.addText("Empty Amulet");
		GuiEManual.addText("");
		GuiEManual.addText("The Empty Amulet is used as a crafting reagent for other Amulets.");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("");
		GuiEManual.addText("The recipe for the Empty Amulet is this:");
		
	}

}
