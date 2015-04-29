package pojmenovavacTitulku;

import java.util.Scanner;

public class YesOrNo {
	
	public static boolean getYesOrNo(){
		System.out.println("y/n");
		Scanner scan=new Scanner(System.in);
		String odp=scan.next();
		scan.close();
		
		if(odp.equals("y")){
			return true;
			
		}
		else{
			return false;
		}
		
	}
}
