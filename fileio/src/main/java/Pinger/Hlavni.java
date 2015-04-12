package Pinger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Hlavni {

	public static void main(String[] args) {
		
		List<String> ipadresy = new ArrayList<String>();
		
		
		// na�ten� seznamu ip adres ze souboru a ulo�en� do Listu
		try (BufferedReader ctecka = new BufferedReader(new FileReader("IPAdresy.txt"))) {
		        String ip;
		        while ((ip = ctecka.readLine()) != null) {
		        	ipadresy.add(ip);
		        }
		}
		catch (Exception e) {
		        System.err.println("Chyba p�i �ten� ze souboru.");
		}

		
		// na��t�n� ip adres z Listu a pos�l�n� k otestov�n�
		for (String ip : ipadresy) {			
			TestIP.otestuj(ip);
		}
		
		
		// odesl�n� mailu se seznamem neodpov�daj�c�ch ip adres, pokud takov� existuj�
		if (TestIP.nedostupne != "") {
			System.out.println(TestIP.nedostupne);
//			PosliMail.send();
		}

	
		
	}
}