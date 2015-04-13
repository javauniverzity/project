package Pinger;

import java.io.BufferedReader;
import java.io.FileReader;

public class Hlavni {

	public static void main(String[] args) {
		
		// naètení seznamu ip adres ze souboru a uložení do Listu
				try (BufferedReader ctecka = new BufferedReader(new FileReader("IPAdresy.txt"))) {
				        String ip;
				        while ((ip = ctecka.readLine()) != null) {
				        	TestIP.otestuj(ip);	// Odeslání ip adresy k otestování
				        }
				}
				catch (Exception e) {
				        System.err.println("Chyba pøi ètení ze souboru IPAdresy.txt.");
				}
				
				
				// odeslání mailu se seznamem neodpovídajících ip adres, pokud takové existují
				if (TestIP.nedostupne != "") {
					System.out.println(TestIP.nedostupne);
					PosliMail.send();
				}

			
			}
		}
