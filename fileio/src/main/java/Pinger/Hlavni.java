package Pinger;

import java.io.BufferedReader;
import java.io.FileReader;

public class Hlavni {

	public static void main(String[] args) {
		
		// na�ten� seznamu ip adres ze souboru a ulo�en� do Listu
				try (BufferedReader ctecka = new BufferedReader(new FileReader("IPAdresy.txt"))) {
				        String ip;
				        while ((ip = ctecka.readLine()) != null) {
				        	TestIP.otestuj(ip);	// Odesl�n� ip adresy k otestov�n�
				        }
				}
				catch (Exception e) {
				        System.err.println("Chyba p�i �ten� ze souboru IPAdresy.txt.");
				}
				
				
				// odesl�n� mailu se seznamem neodpov�daj�c�ch ip adres, pokud takov� existuj�
				if (TestIP.nedostupne != "") {
					System.out.println(TestIP.nedostupne);
					PosliMail.send();
				}

			
			}
		}
