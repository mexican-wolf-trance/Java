package TestStack;
import java.util.*;

public class TestStack 
{

	public static void main(String[] args) 
	{
		Deque<String> books = new LinkedList<String>();
		
		books.addFirst("Java Programming");
		books.addFirst("Intro to C++");
		books.addFirst("Begin Python");
		books.addFirst("Database Systems");
		
		System.out.println("Books in the stack");
		System.out.println("First book in the stack" + books.removeFirst());
		System.out.println("Second book in the stack" + books.removeFirst());
		System.out.println("Third book in the stack" + books.removeFirst());

	}

}
