package pojmenovavacTitulku;

import java.io.File;

public class Preview {
	//vypíše preview pøejmenování souborù a v pøíkazové øádce požádá o schválení, v pøípadì chyby vrací false
	public static boolean vypisPreview(File[] filmy,File[] titulky){
		if(filmy.length >0 && titulky.length > 0){
			for(int i=0;i<filmy.length;i++){
				if(titulky.length>i){
					String jmeno=filmy[i].getName();
					String zkraceneJmeno=jmeno.substring(0,jmeno.lastIndexOf("."));
					String pripona=titulky[i].getName().substring(titulky[i].getName().lastIndexOf("." ));
					System.out.println("pøejmenovat "+titulky[i].getName()+" na:" + zkraceneJmeno+pripona+"?");
					
				}
			}	
			return YesOrNo.getYesOrNo();
		}
		else{
			System.out.println("Špatná cesta/žádné filmy èi titulky");
			return false;
		}
	}
}