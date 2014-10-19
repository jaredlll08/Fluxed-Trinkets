package fluxedtrinkets.api.manual;

import net.minecraft.client.gui.FontRenderer;
import fluxedtrinkets.client.gui.book.manual.GUIManual;

public class Page implements PageBase {

	@Override
	public PageBase getParentPage() {
		return null;
	}

	@Override
	public String getName() {
		return "initial page";
	}

	@Override
	public void drawScreen(GUIManual guiManual, FontRenderer font, int x, int y) {
		font.drawString("hello", x, y, 0);
	}

}
