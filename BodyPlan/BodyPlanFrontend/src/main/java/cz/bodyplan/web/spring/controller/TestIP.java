package cz.bodyplan.web.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestIP {
	
	static String nedostupne = "";

	public static void otestuj (String ip) {
		
        String pingResult = "";
        String pingCmd = "ping " + ip;
        
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
            	
            	System.out.println(inputLine);
                pingResult += inputLine;
            }
            
            in.close();

        } catch (IOException e) {
            System.err.println(e);
        }
        
        if (pingResult.contains("100%")) {
    		nedostupne += ip + " - ztráta 100%\n";
    	} else if (pingResult.contains("75%")) {
    		nedostupne += ip + " - ztráta 75%\n";
    	} else if (pingResult.contains("50%")) {
    		nedostupne += ip + " - ztráta 50%\n";
    	} else if (pingResult.contains("25%")) {
    		nedostupne += ip + " - ztráta 25%\n";
    	} else if (pingResult.contains("0%")) {
    	} else {
    		nedostupne += "Hostitele s adresou " + ip + " se nepodaøilo nalézt, zkontrolujte adresu\n";
    	}
    
        
	}
}
