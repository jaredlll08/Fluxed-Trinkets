package fluxedtrinkets.api.manual;

import java.util.ArrayList;
import java.util.List;

public class PageRegistry {

	private static ArrayList<Object[]> categories = new ArrayList<Object[]>();
	private static ArrayList<String[]> entries = new ArrayList<String[]>();
	/**
	 * Adds a category to the list of registered categories to appear in the
	 * Lexicon.
	 */
	public static void addCategory(String categoryName, ArrayList<PageBase> pages) {
		categories.add(new Object[]{categoryName, pages});
	}

	/**
	 * Gets all registered categories.
	 */
	public static ArrayList<PageBase> getAllCategories() {
		ArrayList<PageBase>category = new ArrayList<PageBase>();
		for(int i = 0; i < categories.size();i++){
			category.add((PageBase)categories.get(i)[0]);
		}
		return category;
	}

	/**
	 * Gets all registered entries.
	 */
	public static ArrayList<String[]> getAllEntries() {
		return entries;
	}


}
