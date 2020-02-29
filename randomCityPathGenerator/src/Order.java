/* Homework 3 - Analyzing a Random TSP
 * CS 4500 - 02
 * February 28, 2020
 * Authors: Jared Hunsaker - jthp73@mail.umsl.edu
 *          Jordan Lanius  - jwlq89@mail.umsl.edu
 *          Charles Wyatt  - cwdh4@mail.umsl.edu
 *
 * - PathFinder.java -
 * This object handles the various permutations of visiting order that the salesperson
 * must choose from.
 *
 * Project Files: Main.java, PathFinder.java, > Order.java <, Grid.java, City.java
 */
public class Order{
    int num_cities;
    int num_Permutations;
    static int[] order;

    //empty constructor
    public Order(){
        num_cities = 0;
    }

    //constructor
    public Order(int c){
        num_cities = c;    //sets the number of cities to the passed in value
        num_Permutations = calcNumPermutations(num_cities - 1);  //calc number of paths based on cities. -1 because they all start at 0
        order = new int[num_cities+1];       //order is +1 num cities because he returns to starting city at the end
        for (int i = 0; i < num_cities; i++){
            order[i]=i;    //set initial order from 0 to num cities - 1
        }
        order[num_cities] = 0; //set last city back to 0
    }

	//calculates the next permutation of cities according to lexicographical ordering
    public static boolean nextOrder(int[] order, boolean end){
	    int I = -1;  //default big index to -1, will be check later to see if last permutation

	    for (int i = 1; i < order.length - 2; i++){  //set i=1 and order.length - 2 because first and last city is always 0
	        if (order[i] < order[i+1]){
	            I = i;                               //set I to the largest index where there is one further index with a higher value
	        }
	    }
	    if (I == -1){    //if there is no index that fits the above loop check, there are no more permutations and the end is reached
	        end = true;
	    }else{           //if I was reset, find the next permutation
	        int J = -1;  //like I, set J to default -1. if I is set above, there should always be a J that is set below
	        for (int j = 1; j < order.length - 1; j++){
	            if (order[I] < order[j]){
					J = j;       //set J to the largest index with a value that is higher than value at I
								 //does not mean the highest value past I, but the highest index with a higher value than at I
	            }
	        }
	        swap(order, I, J);   //swaps values at I and J
			reverse(order, I+1); //reverses the part of the array after I
								 //swapping and reversing is what provides the next order according to lexicographical ordering
	    }
        boolean true_after_swap = false;

        //reruns the first check to see if it becomes the last iteration after the above changes
		//without this, the above logic will return the last order without setting end = true, so function is re-called
		//byproduct of the check to see if it is the last order being part of the actual algorithm
	    for (int i = 1; i < order.length - 2; i++){
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
	    int j = order.length - 1;
	    int[] rev_order = new int[order.length];
	    for (int i = 0; i < order.length; i++){
	        rev_order[i] = order[i];
	    }
	    for (int i = I; i < order.length - 1; i++){
	        rev_order[j-1] = order[i];
	        j = j - 1;
	    }
	    for (int i = 0; i < order.length; i++){
	        order[i] = rev_order[i];
	    }
	}

    //factorial algorithm to return the expected amount of iterations for a given number of cities
    public static int calcNumPermutations(int k){
        if (k == 1)
            return 1;
        else
            return k * calcNumPermutations(k-1);
    }

	public static int[] getOrder(){
	    return order;
	}

	public int getNumPermutations() {
        return num_Permutations;
    }
}
