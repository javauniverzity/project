package cz.expertkom.fileio;

public class Nelinina {

	public static void main(String[] args) {
		String response = new String("te\nxt");
		response = response.replace("\n", "");
		response = response.replace("\r", "");
		response = response.replace("\t", "");

		if (response.contains("ex")) {
			System.out.println("jo");
		} else {
			System.out.println("ne");
		}
	}
}
