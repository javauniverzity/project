package pojmenovavacTitulku;
/*
* program zatím umí jenom pojmenovat titulky v daném adresáøi podle souborù s videem
**/
import java.io.File;

public class PojmenovavacTitulkuApp {
	public static void main(String[] args) {
		Konfig.prectiKonfig();
		System.out.println(Konfig.path);
		SeznamFilu seznam1=new SeznamFilu();
		seznam1.setPath(Konfig.path);
		File[] filmy=seznam1.getFilmy();
		File[] titulky=seznam1.getTitulky();
		if(Preview.vypisPreview(filmy, titulky)){
			System.out.println("true");
			Pojmenovavac.pojmenujTitulky(filmy,titulky);
		}
				
		else{
			System.out.println("false");
		}
		
		
		
	}
}
