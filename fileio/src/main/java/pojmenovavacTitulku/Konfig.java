package pojmenovavacTitulku;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Konfig {
	public static String path;

	// p�e�te informace z konfigura�n�ho souboru, moment�ln� pouze cestu, a
	// ulo�� je do prom�nn�ch
	static void prectiKonfig() {
		File config = new File("config.txt");
		try {
			List<String> conf = FileUtils.readLines(config);

			path = conf.get(1);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.lang.IndexOutOfBoundsException e1) {
			e1.printStackTrace();
		}
	}

}
