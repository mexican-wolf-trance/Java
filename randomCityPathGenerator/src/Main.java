/* Homework 3 - Analyzing a Random TSP
 * CS 4500 - 02
 * February 28, 2020
 * Authors: Jared Hunsaker - jthp73@mail.umsl.edu
 *          Jordan Lanius  - jwlq89@mail.umsl.edu
 *          Charles Wyatt  - cwdh4@mail.umsl.edu
 *
 * - Analyzing a Random TSP -
 * This program finds the shortest path between K cities in a N x N grid.
 *
 * Project Files: > Main.java <, PathFinder.java, Order.java, Grid.java, City.java
 * External Files Required: N/A
 * External Files Created: N/A
 *
 * Resources Used: N/A
 */

package src;
import java.util.*;

public class Main
{
    public static void main (String[] args)
    {
        int k, n;
        Scanner input = new Scanner(System.in);

        System.out.println("How many cities does the salesperson need to travel to?");
        k = inputInteger(input,4, 9);
        System.out.println("\nHow large is the area that these cities exist in?");
        n = inputInteger(input,10, 30);
        System.out.println();

        PathFinder pathfinder = new PathFinder(k,n);
        pathfinder.calcDistances();

        pathfinder.outputGrid();
        pathfinder.outputDistances();

        pathfinder.outputPathways();
	}

	public static int inputInteger(Scanner input, int min, int max) {
        int intInput;

        do
        {
            System.out.print("Enter an integer within " + min + " and " + max + ": ");

            //Check if the user entered a string and then throw an error
            //If it is a string, try again
            while (!input.hasNextInt())
            {
                input.next();
                System.out.println("  ERROR: Input is not an integer.");
                System.out.print("Enter an integer within " + min + " and " + max + ": ");
            }
            //Check if the integer the user finally entered is within the parameters
            //Try again if not
            intInput = input.nextInt();
            if (intInput < min || intInput > max)
            {
                System.out.println("  ERROR: Input is not within " + min + " and " + max + ": ");
            }
        } while (intInput < min || intInput > max);

        return intInput;
    }
}
