package src;

public class Order{
    int num_cities;
    static int[] order;

    public Order(){
        num_cities = 0;
    }

    public Order(int c){
        num_cities = c;
        order = new int[num_cities];
        for (int i = 0; i < num_cities; i++){
            order[i]=i;
        }
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

	public static int[] getOrder(){
	    return order;
	}
}
