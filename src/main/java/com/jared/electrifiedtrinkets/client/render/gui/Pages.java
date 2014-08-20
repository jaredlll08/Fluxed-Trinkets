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
		GuiEManual.addChapter("Rings", 4);
		GuiEManual.addChapter("Belts", 5);

	}

	public static void Amulets() {
		GuiEManual.addChapter("Empty Amulet", 6);
		GuiEManual.addChapter("Respiratory Amulet", 7);
	}
	
	public static void Belts(){
		GuiEManual.addChapter("Empty Belt", 8);
	}

}
