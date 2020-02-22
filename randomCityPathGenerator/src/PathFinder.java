package src;
import java.util.*;

public class PathFinder
{
    public static void main (final String[] args)
    {
        int k = 0;
        final Scanner cityInput = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.println("Enter the number of cities:");            
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
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Must be an integer between 4 and 9");
                cityInput.next();
                System.out.println();
                continue;
            }
        }
        System.out.print(k + " cities");
        cityInput.close();
    }
}