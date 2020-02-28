package src;
import java.util.*;


public class Main
{
    public static void main (String[] args)
    {
        
        System.out.println("I'm made it at least here...");
        
        PathFinder Pathfinder1 = new PathFinder(0,0);
		int k = Pathfinder1.setK(); 
		int n = Pathfinder1.setN();
        Grid Grid1 = new Grid(Pathfinder1.getN(), Pathfinder1.getN());

        System.out.println("Incredible! the grid is " + Grid1.getXLength() + " x " + Grid1.getYLength());
        System.out.println("Number of cities: " + Pathfinder1.getK());

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