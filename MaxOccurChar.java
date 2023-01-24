import java.util.Scanner;

public class MaxOccurChar {
	static char getMaxOccurringChar(String str)
	{
		int len = str.length();
        int count[] = new int[256];
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;

		int max = -1; 
		char result = ' '; 

		for (int i = 0; i < len; i++) {
			if (max < count[str.charAt(i)]) {
				max = count[str.charAt(i)];
				result = str.charAt(i);
			}
		}

		return result;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String strr = sc.nextLine();
		System.out.println("Max occurring character is "+ getMaxOccurringChar(strr));
	}
}
