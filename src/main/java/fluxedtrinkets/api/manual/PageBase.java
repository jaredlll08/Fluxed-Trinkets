package fluxedtrinkets.api.manual;

import net.minecraft.client.gui.FontRenderer;
import fluxedtrinkets.client.gui.book.manual.GUIManual;

public interface PageBase {

	/**
	 * 
	 * @return the parent page, null for the main page.
	 */
	public  PageBase getParentPage();

	public void drawScreen(GUIManual guiManual, FontRenderer font, int x, int y);

	public String getName();

}
