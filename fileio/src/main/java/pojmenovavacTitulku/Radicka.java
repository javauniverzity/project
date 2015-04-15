package pojmenovavacTitulku;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

//�ad� soubory podle jm�na, zat�m zcela zbyte�n�
public class Radicka {
	public static void seradFily(File[] f){
		Comparator<File> radic=new Comparator<File>() {

			@Override
			public int compare(File f1, File f2) {
				
				return (f1.getName().compareTo(f2.getName()));
			}
			
		};
		Arrays.sort(f,radic);
		
	}

}
