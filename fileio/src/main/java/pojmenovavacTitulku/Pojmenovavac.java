package pojmenovavacTitulku;

import java.io.File;

public class Pojmenovavac {
	//pøejmenuje soubory uložené v arrayi è2 podle jmen souborù v arrayi è1 pøièemž zachová jejich koncovku
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
