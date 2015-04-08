package cz.expertkom.fileio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {
		File file = new File("test.txt");
		try {
			FileUtils.readLines(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
