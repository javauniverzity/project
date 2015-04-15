package pojmenovavacTitulku;

import java.io.File;

public class Preview {
	//vyp�e preview p�ejmenov�n� soubor� a v p��kazov� ��dce po��d� o schv�len�, v p��pad� chyby vrac� false
	public static boolean vypisPreview(File[] filmy,File[] titulky){
		if(filmy.length >0 && titulky.length > 0){
			for(int i=0;i<filmy.length;i++){
				if(titulky.length>i){
					String jmeno=filmy[i].getName();
					String zkraceneJmeno=jmeno.substring(0,jmeno.lastIndexOf("."));
					String pripona=titulky[i].getName().substring(titulky[i].getName().lastIndexOf("." ));
					System.out.println("p�ejmenovat "+titulky[i].getName()+" na:" + zkraceneJmeno+pripona+"?");
					
				}
			}	
			return YesOrNo.getYesOrNo();
		}
		else{
			System.out.println("�patn� cesta/��dn� filmy �i titulky");
			return false;
		}
	}
}