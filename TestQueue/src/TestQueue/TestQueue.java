package TestQueue;
import java.util.*;

public class TestQueue 
{

	public static void main(String[] args) 
	{
		Queue<Integer> myQueue = new LinkedList<Integer>();
		
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(5);
		myQueue.add(6);
		myQueue.add(7);
		myQueue.add(8);
		myQueue.add(9);
		
		System.out.println(myQueue);
		int deleted_element = myQueue.remove();
		System.out.println(deleted_element);
		
		int head = myQueue.peek();
		System.out.println(head);
		
		System.out.println(myQueue.size());
		

	}

}
