package src;
import java.util.*;

public class PathFinder
{
    private int k;
    private int n;

    PathFinder( int k, int n)
    {
        this.k = k;
        this.n = n;
    }

    public int getK()
    {
        final Scanner cityInput = new Scanner(System.in);

        //Input validation time!!
        System.out.println("Enter the number of cities between 4 and 9:");            

        do 
        {
            //Check if the user entered a string and then throw an error
            //If it is a string, try again
            while (!cityInput.hasNextInt()) 
            {
                String input = cityInput.next();
                System.out.println("Must be an integer between 4 and 9");
            }
            //Check if the integer the user finally entered is within the parameters
            //Try again if not
            k = cityInput.nextInt();
            if (k < 4 || k > 9)
            {
                System.out.println("Must be an integer between 4 and 9");
            }
        } while (k < 4 || k > 9);

        cityInput.close();
        return this.k;
    }

    public int getN()
    {
        final Scanner cityInput = new Scanner(System.in);
        System.out.println("Enter the length of one side of the square grid between 10 and 30:");            

        do 
        {
           //Same as above except for the grid dimension
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
       return this.n;
    }

    // public static void inputValidation (final String[] args)
    // {
    //     int k = 0;
    //     int n = 0;
    //     final Scanner cityInput = new Scanner(System.in);

    //     //Input validation time!!
    //     System.out.println("Enter the number of cities between 4 and 9:");            

    //     do 
    //     {
    //         //Check if the user entered a string and then throw an error
    //         //If it is a string, try again
    //         while (!cityInput.hasNextInt()) 
    //         {
    //             String input = cityInput.next();
    //             System.out.println("Must be an integer between 4 and 9");
    //         }
    //         //Check if the integer the user finally entered is within the parameters
    //         //Try again if not
    //         k = cityInput.nextInt();
    //         if (k < 4 || k > 9)
    //         {
    //             System.out.println("Must be an integer between 4 and 9");
    //         }
    //     } while (k < 4 || k > 9);

    //      System.out.println("Enter the length of one side of the square grid between 10 and 30:");            

    //      do 
    //      {
    //         //Same as above except for the grid dimension
    //         while (!cityInput.hasNextInt()) 
    //         {
    //             String input = cityInput.next();
    //             System.out.println("Must be an integer between 10 and 30");
    //         }
    //         n = cityInput.nextInt();
    //         if (n < 10 || n > 30 )
    //         {
    //             System.out.println("Must be an integer between 10 and 30");
    //         }
    //     } while (n < 10 || n > 30);

    //     cityInput.close();
    //     System.out.println(k + " cities");
    //     System.out.println(n + " length");
    // }
}