package src;
import java.util.*;

public class PathFinder
{
    public static void main (final String[] args)
    {
        int k = 0;
        int n = 0;
        final Scanner cityInput = new Scanner(System.in);

        System.out.println("Enter the number of cities between 4 and 9:");            

        do 
        {
            while (!cityInput.hasNextInt()) 
            {
                String input = cityInput.next();
                System.out.println("Must be an integer between 4 and 9");
            }
            k = cityInput.nextInt();
            if (k < 4 || k > 9)
            {
                System.out.println("Must be an integer between 4 and 9");
            }
        } while (k < 4 || k > 9);

         System.out.println("Enter the length of one side of the square grid between 10 and 30:");            

         do 
         {
            while (!cityInput.hasNextInt()) 
            {
                String input = cityInput.next();
                System.out.println("Must be an integer between 10 and 30");
            }
            n = cityInput.nextInt();
            if (n < 10 || n > 30 )
            {
                System.out.println("Must be an integer between 10 and 30");
            }
        } while (n < 10 || n > 30);

        cityInput.close();
        System.out.println(k + " cities");
        System.out.println(n + " length");
    }
}