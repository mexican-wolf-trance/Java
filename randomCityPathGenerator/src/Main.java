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


public class Main
{
    public static void main (String[] args)
    {

        System.out.println("I'm made it at least here...");

        PathFinder pathfinder = new PathFinder(0,0);
		int k = pathfinder.setK();
		int n = pathfinder.setN();
        Grid Grid1 = new Grid(n);

        System.out.println("Incredible! the grid is " + Grid1.getLength() + " x " + Grid1.getLength());
        System.out.println("Number of cities: " + pathfinder.getK());

        boolean end = false;
		Order order = new Order(k);
		int[] cur_order = order.getOrder();

		int count = 1;
        int max = numPermutations(k); //max set to 1 less than size because they all start at 0, will end up being K - 1
        //test output
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

    //factorial algorithm to return the expected amount of iterations for a given number of cities
	public static int numPermutations(int k){
        if (k == 1)
            return 1;
        else
            return k * numPermutations(k-1);
    }
}
