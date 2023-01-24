import java.util.Scanner;

class UniqueCharString {
	boolean uniqueChar(String str)
	{
		for (int i = 0; i < str.length(); i++)
			for (int j = i + 1; j < str.length(); j++)
				if (str.charAt(i) == str.charAt(j))
					return false;
		return true;
	}

	public static void main(String args[])
	{
		UniqueCharString obj = new UniqueCharString();
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String strr = sc.nextLine();

		if (obj.uniqueChar(strr))
			System.out.println("The String " + strr + " has all unique characters");
		else
			System.out.println("The String " + strr + " has duplicate characters");
	}
}

