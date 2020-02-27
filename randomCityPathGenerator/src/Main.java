package src;
import java.util.*;


public class Main
{
    public static void main (String[] args)
    {
        
        System.out.println("I'm made it at least here...");
        
        PathFinder Pathfinder1 = new PathFinder(0,0);
        Pathfinder1.setK(); Pathfinder1.setN();
        Grid Grid1 = new Grid(Pathfinder1.getN(), Pathfinder1.getN());

        System.out.println("Incredible! the grid is " + Grid1.getXLength() + " x " + Grid1.getYLength());
        System.out.println("Number of cities: " + Pathfinder1.getK());

        boolean end = false;
		System.out.println("Hello World");
		int[] nums = new int[]{0,1,2,3,4,5};
		
		int count = 1;
		int max = numPermutations(5);
		for (int i = 0; i < nums.length; i++){
	        System.out.print(nums[i]);
	    }
	    System.out.println();
		while (count < max && end == false){
		    end = nextOrder(nums, end);
		    for (int i = 0; i < nums.length; i++){
		        System.out.print(nums[i]);
		    }
		    System.out.println();
		    count++;
		}
		System.out.println("Permutations: " + count);

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
	
	public static void swap(int[] order, int I, int J){
	    //System.out.println("I: " + I + "   J:" + J);
	    int temp = order[I];
	    order[I] = order[J];
	    order[J] = temp;
	}
	
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
	
	public static int numPermutations(int k){
        if (k == 1)
            return 1;
        else
            return k * numPermutations(k-1);
    }
}