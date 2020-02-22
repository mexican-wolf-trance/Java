package src;
import java.util.*;

public class PathFinder
{
    public static void main (final String[] args)
    {
        int k = 0;
        int n = 0;
        final Scanner cityInput = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.println("Enter the number of cities between 4 and 9:");            
                k = cityInput.nextInt();
                if(k >= 4 && k <= 9)
                    break;
                else
                {
                    System.out.println("That is an integer, but it must be between 4 and 9");
                    cityInput.next();
                    System.out.println();
                    continue;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Must be an integer between 4 and 9");
                cityInput.next();
                System.out.println();
                continue;
            }
        }
        while(true)
        {
            try
            {
                System.out.println("Enter the length of one side of the square grid between 10 and 30:");            
                n = cityInput.nextInt();
                if(n >= 10 && n <= 30)
                    break;
                else
                {
                    System.out.println("That is an integer, but it must be between 10 and 30");
                    cityInput.next();
                    System.out.println();
                    continue;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Must be an integer between 10 and 30");
                cityInput.next();
                System.out.println();
                continue;
            }
        }
        cityInput.close();
        System.out.println(k + " cities");
        System.out.println(n + "length");
    }
}