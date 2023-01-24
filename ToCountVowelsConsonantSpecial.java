import java.util.Scanner;

public class ToCountVowelsConsonantSpecial {

	static void countCharacter(String str)
	{
		int vo = 0, co = 0, sp = 0,in = 0;
	
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
	
			if ( (ch >= 'a' && ch <= 'z') ||
				(ch >= 'A' && ch <= 'Z') ) {
	
				
				ch = Character.toLowerCase(ch);
	
				if (ch == 'a' || ch == 'e' || ch == 'i' ||
					ch == 'o' || ch == 'u')
					vo++;
				else
					co++;
			}
			else if (ch >= '0' && ch <= '9')
				in++;
			else
				sp++;
		}
		
		System.out.println(" No. of Vowels: " + vo);
		System.out.println(" No. of Consonant: " + co);
		System.out.println(" No. of Digit: " + in);
		System.out.println(" No. of Special Character: " + sp);
	}
	static public void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String strr = sc.nextLine();
		
		countCharacter(strr);
	}
}