import java.util.Scanner;

public class DuplicatesInAString
{
   public static void main(String[] args) 
   {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a String");
    String n = sc.nextLine();
    char [] a = n.toCharArray();
    
    boolean c = false;

    for(int i=0;i<a.length;i++)
    {
      if(a[i] != -1)
      {
         for(int j= i+1;j<a.length;j++)
         {
            if(a[i]==a[j])
            {
               System.out.println("    The Duplicate Value is  " +a[i]);
               c=true;
               break;

            }
         }
      }
    }
    if(c==false)
    {
       System.out.println(" There is no Duplicate Value ");   
    }
    System.out.println();

   } 
}
