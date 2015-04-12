package Pinger;

import java.net.InetAddress;

public class TestIP {
	
	static String nedostupne = "";
	
	public static void otestuj (String ip) {
		
		try {
		       InetAddress address = InetAddress.getByName(ip);
		       
		       if (address.isReachable(3000) == false) {
		    	   
		    	   nedostupne += ip + "\n";
		       }
		       
		     }
		     catch (Exception e) {
		       System.err.println("Chyba");
		     }

		

	}
}
