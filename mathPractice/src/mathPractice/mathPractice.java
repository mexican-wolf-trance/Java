package mathPractice;
import java.util.Scanner;
public class mathPractice 
{
	public static void main (String [] args)
	{	
		double base,height,area, half = .5;
		int tri;
                        
		Scanner answer = new Scanner(System.in);
		Scanner h = new Scanner(System.in);
		Scanner b = new Scanner(System.in);
		Scanner t = new Scanner(System.in);
     
		System.out.println("Enter the base");
		base = b.nextDouble();
    
		System.out.println("Enter the height");
		height = h.nextDouble();
    
		System.out.println("1 if triangle,2 if rectangle");  
		tri = t.nextInt();
		
		if(tri == 1)
		{
			area = half * base * height;
			System.out.println("The area of the triangle is "+ area);
		}
		else if(tri == 2)
		{
			area = base * height;    
			System.out.println("The area of the rectangle is "+ area);
		}
		else 
			System.out.println("No");
   
		answer.close();
		h.close();
		b.close();
		t.close();
    	
	}
}
