import java.util.Arrays;

public class Anagram {
    public static void main(String[] args){

        String s1="a gentle Man";
		String s2="elegant Man";
		
		s1=s1.replace(" ", "");
		s2=s2.replace(" ", "");
		
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		
		char[] ch1=s1.toCharArray();
		char[] ch2=s2.toCharArray();
		
		for (int i = 0; i < ch1.length; i++) {
            for (int j = 1; j < ch1.length - i; j++) {
                if (ch1[j] < ch1[j - 1]) {
                    char Var = ch1[j];
                    ch1[j] = ch1[j - 1];
                    ch1[j - 1] = Var;
                }
            }
        }
		for (int i = 0; i < ch2.length; i++) {
            for (int j = 1; j < ch2.length - i; j++) {
                if (ch2[j] < ch2[j - 1]) {
                    char Var = ch2[j];
                    ch2[j] = ch2[j - 1];
                    ch2[j - 1] = Var;
                }
            }
        }
		

		
		if(Arrays.equals(ch1, ch2))
		{
			System.out.println("It's Anagram");
		}
		else
		{
			System.out.println("It's not Anagram");
		}
    }   
		
    
}
