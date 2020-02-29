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

        pathfinder.outputGrid();
        pathfinder.calcDistances();
        pathfinder.outputDistances();


        boolean end = false;
		Order order = new Order(k);
		int[] cur_order = order.getOrder();

		int count = 1;
        int max = numPermutations(k); //max set to 1 less than size because they all start at 0, will end up being K - 1
        //test output
        System.out.println("\nDifferent city orders:");
		for (int i = 0; i < k; i++){
	        System.out.print(cur_order[i]);
	    }
        System.out.println();

        //runs through the following code for every iteration of the order of cities
        //checks against both the expected number of iterations and if it reaches the actual last iteration, just in case
		while (count < max && end == false){
		    end = order.nextOrder(cur_order, end);               //returns true if the last iteration is found, auto updates order since arrays are passed by ref
		    for (int i = 0; i < cur_order.length; i++){    //more testing output
		        System.out.print(cur_order[i]);
            }
            //*call to calculate distance of path based on order here
            //*call to compare against lowest found so far here
		    System.out.println();
		    count++;
		}
		System.out.println("Permutations: " + count); //more testing output

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

    //factorial algorithm to return the expected amount of iterations for a given number of cities
	public static int numPermutations(int k){
        if (k == 1)
            return 1;
        else
            return k * numPermutations(k-1);
    }
}
