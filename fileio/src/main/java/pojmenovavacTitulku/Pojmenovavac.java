package pojmenovavacTitulku;

import java.io.File;

public class Pojmenovavac {
	//p�ejmenuje soubory ulo�en� v arrayi �2 podle jmen soubor� v arrayi �1 p�i�em� zachov� jejich koncovku
	public static void pojmenujTitulky(File[] filmy,File[] titulky){
		for(int i=0;i<filmy.length;i++){
			if(titulky.length>i){	
				String jmeno=filmy[i].getName();
				String zkraceneJmeno=jmeno.substring(0,jmeno.lastIndexOf("."));
				System.out.println(zkraceneJmeno);
				String pripona=titulky[i].getName().substring(titulky[i].getName().lastIndexOf("." ));
				File novy=new File(SeznamFilu.path+zkraceneJmeno+pripona);
				titulky[i].renameTo(novy);
		
			}
	
		}
	}	
}
