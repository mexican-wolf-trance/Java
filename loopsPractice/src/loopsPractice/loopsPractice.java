package loopsPractice;
//import java.util.Scanner;

public class loopsPractice 
{
	public static void main (String [] args)
	{
		int count = 0;
		while (count <= 6)
		{
			System.out.printf(" Welcome to Java  :");
			count++;
		}
		System.out.printf("\n");
		for (count = 1; count < 8; count++)
		{
			for (int counts = 0; counts < 6; counts++)
			{
				System.out.printf(" I am the egg man :");
			}
			System.out.println(" You are the walrus");
		}
		
	}
}