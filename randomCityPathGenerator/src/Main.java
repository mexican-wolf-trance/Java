package src;
import java.util.*;


public class Main
{
    public static void main (String[] args)
    {
        
        System.out.println("I'm made it at least here...");
        
        PathFinder Pathfinder1 = new PathFinder(0,0);
        Pathfinder1.setK(); 
        Pathfinder1.setN();
        Grid Grid1 = new Grid(Pathfinder1.getN());

        System.out.println("Incredible! the grid is " + Grid1.getLength() + " x " + Grid1.getLength());
        System.out.println("Number of cities: " + Pathfinder1.getK());

        boolean end = false;
		System.out.println("Hello World");
		int[] nums = new int[]{0,1,2,3,4,5}; //temporary hardcoded city list
		
		int count = 1;
        int max = numPermutations(5); //max set to 1 less than size because they all start at 0, will end up being K - 1
        //test output
		for (int i = 0; i < nums.length; i++){
	        System.out.print(nums[i]);
	    }
        System.out.println();

        //runs through the following code for every iteration of the order of cities
        //checks against both the expected number of iterations and if it reaches the actual last iteration, just in case
		while (count < max && end == false){
		    end = nextOrder(nums, end);               //returns true if the last iteration is found, auto updates order since arrays are passed by ref
		    for (int i = 0; i < nums.length; i++){    //more testing output
		        System.out.print(nums[i]);
            }
            //*call to calculate distance of path based on order here
            //*call to compare against lowest found so far here
		    System.out.println();
		    count++;
		}
		System.out.println("Permutations: " + count); //more testing output

    }
    public static boolean nextOrder(int[] order, boolean end){
	    int I = -1;
	    
	    for (int i = 1; i < order.length - 1; i++){
	        if (order[i] < order[i+1]){
	            I = i;
	        }
	    }
	    if (I == -1){
	        end = true;
	    }else{
	        int J = -1;
	        for (int j = 1; j < order.length; j++){
	            if (order[I] < order[j]){
	                J = j;
	            }
	        }
	        swap(order, I, J);
	        reverse(order, I+1);
	    }
        boolean true_after_swap = false;
        
        //reruns the first check to see if it becomes the last iteration after the above changes
        //avoids the function being called twice for the last iteration, may clean up to avoid needed this
	    for (int i = 1; i < order.length - 1; i++){
	        if (order[i] < order[i+1]){
	            true_after_swap = true;
	        }
	    }
	    if (true_after_swap == false){
	        end = true;
	    }
	    
	    return end;
	}
    
    //simple swap function to switch two values in an array
	public static void swap(int[] order, int I, int J){
	    int temp = order[I];
	    order[I] = order[J];
	    order[J] = temp;
	}
    
    //function to reverse the end of an array starting at a given index
	public static void reverse(int[] order, int I){
	    int j = order.length;
	    int[] rev_order = new int[order.length];
	    for (int i = 0; i < order.length; i++){
	        rev_order[i] = order[i];
	    }
	    for (int i = I; i < order.length; i++){
	        rev_order[j-1] = order[i];
	        j = j - 1;
	    }
	    for (int i = 0; i < order.length; i++){
	        order[i] = rev_order[i];
	    }
	}
    
    //factorial algorithm to return the expected amount of iterations for a given number of cities
	public static int numPermutations(int k){
        if (k == 1)
            return 1;
        else
            return k * numPermutations(k-1);
    }
}