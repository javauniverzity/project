package pojmenovavacTitulku;

import java.io.File;
import java.io.FilenameFilter;

public class SeznamFilu {
	static String path;
	//nastav� cestu k adres��i
	void setPath(String p){
	path=p;
	}
	//vytvo�� a vr�t� array soubor� s videi
	File[] getFilmy(){
		File dir=new File(path);
		if(!dir.isDirectory()){
			System.out.println("�patn� cesta");
			System.exit(0);
		}
		FilenameFilter MovieFiltr=new FilenameFilter(){
			public boolean accept(File dir, String name){
				if(name.endsWith(".mkv") || name.endsWith(".avi") || name.endsWith(".mp4")){
				return true;
				}
				else{
					return false;
				}
			}
		};
		
		File[] seznamFilmu=dir.listFiles(MovieFiltr);
		
		return seznamFilmu;
	}
	//vytvo�� a vr�t� array soubor� s titulky
	File[] getTitulky(){	
		File dir=new File(path);
		FilenameFilter SubFiltr=new FilenameFilter(){
			public boolean accept(File dir, String name){
				if(name.endsWith(".srt") || name.endsWith(".sub") || name.endsWith(".txt")){
				return true;
				}
				else{
					return false;
				}
			}
		};
		
		File[] seznamTitulku=dir.listFiles(SubFiltr);
		
		return seznamTitulku;
	}
	
}