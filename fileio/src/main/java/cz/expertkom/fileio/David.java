package cz.expertkom.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;


public class David {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line = null;
        File file;
        
        try {
            Date aktualniCas = new Date();
            int hodin = aktualniCas.getHours(); //zaokrouhleni na nejblizsi 6hodinovku 
                if (hodin<4){ //od 22 do 03 pocitam UTC+2 hodiny + 2 hodiny na vygenerovani mapy
                    aktualniCas.setHours(0);
                }
                else if (hodin<10){ //od 04 do 09
                    aktualniCas.setHours(6);
                }
                else if (hodin<16){ //od 09 do 15
                    aktualniCas.setHours(12);
                }
                else if (hodin<22){ //od 16 do 21
                    aktualniCas.setHours(18);
                }
                DateFormat df = new SimpleDateFormat("yyyyMMddHH");
                String urlPart = df.format(aktualniCas);
                System.out.println(urlPart);
                
            String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date()); //tvorba nazvu ulozeneho obrazku
            url = new URL("http://www.chmi.cz/files/portal/docs/meteo/ov/aladin/results/public/mapy/data/" + urlPart +"/T2m_public_00.png");
            //System.out.println(url);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            file = new File(fileName); 
            FileUtils.copyURLToFile(url, file); //stahne obrazek do PC
            while ((line = br.readLine()) != null) {
                System.out.println(line); //vnitrni vykresleni Eclipse
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    }
}