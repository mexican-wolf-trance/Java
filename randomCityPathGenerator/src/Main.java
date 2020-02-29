/* Homework 3 - Analyzing a Random TSP
 * CS 4500 - 02
 * February 28, 2020
 * Authors: Jared Hunsaker -
 *          Jordan Lanius  - jwlq89@mail.umsl.edu
 *          Charles Wyatt  -
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

<<<<<<< HEAD
/*
randomCityPathGenerator
Main.java
Grid.java, City.java, PathFinder.java
No external files created
Charles Wyatt, Jordan Lanius, Jared Hunsaker
cwdh4@mail.umsl.edu, 
COMPSCI 4500
02/28/2020

This program asks the user to generate a grid of a number of cities of their choosing
(between 4 and 9 cities for real) and then our program will determine the shortest path
between the cities.

Did not use any external sources...

 */
=======
>>>>>>> 9b920a1bbcf6da0af6ea8fa5a381035cba156a5f
public class Main
{
    public static void main (String[] args)
    {
<<<<<<< HEAD
        
        System.out.println("I made it at least here...");
        
        PathFinder Pathfinder1 = new PathFinder(0,0);
        Pathfinder1.setK(); 
        Pathfinder1.setN();
        Grid Grid1 = new Grid(Pathfinder1.getN());

        System.out.println("Incredible! the grid is " + Grid1.getLength() + " x " + Grid1.getLength());
        System.out.println("Number of cities: " + Pathfinder1.getK());
=======
        int k, n;
        Scanner input = new Scanner(System.in);

        System.out.println("How many cities does the salesperson need to travel to?");
        k = inputInteger(input,4, 9);
        System.out.println("\nHow large is the area that these cities exist in?");
        n = inputInteger(input,10, 30);
        System.out.println();

        PathFinder pathfinder = new PathFinder(k,n);

        pathfinder.outputGrid();


>>>>>>> 9b920a1bbcf6da0af6ea8fa5a381035cba156a5f

        boolean end = false;
		Order order = new Order(k);
		int[] cur_order = order.getOrder();

		int count = 1;
<<<<<<< HEAD
		int max = numPermutations(Pathfinder1.getK()-1);
        //int max = numPermutations(5); //max set to 1 less than size because they all start at 0, will end up being K - 1
=======
        int max = numPermutations(k); //max set to 1 less than size because they all start at 0, will end up being K - 1
>>>>>>> 9b920a1bbcf6da0af6ea8fa5a381035cba156a5f
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
