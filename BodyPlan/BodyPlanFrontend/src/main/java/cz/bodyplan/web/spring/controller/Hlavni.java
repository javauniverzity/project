package cz.bodyplan.web.spring.controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class Hlavni {

	public static void main(String[] args) {
		
		// na�ten� seznamu ip adres ze souboru a ulo�en� do Listu
				try (BufferedReader ctecka = new BufferedReader(new FileReader("C://IPAdresy.txt"))) {
				        String ip;
				        while ((ip = ctecka.readLine()) != null) {
				        	TestIP.otestuj(ip);	// Odesl�n� ip adresy k otestov�n�
				        }
				}
				catch (Exception e) {
				        System.err.println("Chyba p�i �ten� ze souboru IPAdresy.txt.");
				}

			}
		}
