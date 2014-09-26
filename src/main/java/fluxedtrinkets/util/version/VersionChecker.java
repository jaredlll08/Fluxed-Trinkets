package fluxedtrinkets.util.version;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import fluxedtrinkets.ModInfo;
import fluxedtrinkets.util.EventHandler;

public class VersionChecker {
	public static boolean upToDate = false;

	public static String version;

	public static String releaseVersion;

	public static void init() {
//		connect();
	}

	private static void connect() {
		try {
			URL versionFile = new URL("http://www.jaredlll08.info/version/FT.txt");
			URLConnection versionFileConnection = versionFile.openConnection();
			versionFileConnection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(versionFileConnection.getInputStream()));
			String inputLine = in.readLine();
			if (inputLine.equals(ModInfo.version)) {
				upToDate = true;
				releaseVersion = inputLine;
			} else {
				upToDate = false;
				releaseVersion = inputLine;
				System.out.println("new Fluxed Trinkets Version found!");
			}

			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
