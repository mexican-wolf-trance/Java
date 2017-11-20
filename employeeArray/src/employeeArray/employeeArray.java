package employeeArray;
import java.util.Scanner;

public class employeeArray 
{
	public static void main(String [] args) 
	{
		employeeHoursCalc test = new employeeHoursCalc();
		Scanner employeeNum = new Scanner(System.in);
						
		System.out.println("How many employees? ");		
		test.empNum = employeeNum.nextInt();
		/////////////////////////////////////////////////
		/* The user inputs the numbers of employees    */
		/* and then inputs the number of hours per     */
		/* employee.                                   */
		/////////////////////////////////////////////////
		test.setEmpl();
		test.setHours();		
		//Pass the array into the method, and the result into a new array
		double hourTotals[] = weekTotals(test.hours , test.empNum);
		//Display the sorted total hours per employee
		test.sortAndDisplay(hourTotals);
		employeeNum.close();
	}
	public static double [] weekTotals(double [][] array , int num)
	{	
		/////////////////////////////////////////////////
		/* In this method, we add together the hours   */
		/* each employee worked, and then sort them    */
		/* according to how many hours they worked.    */
		/////////////////////////////////////////////////
		double [] hourTotals = new double[num];
		for (int col = 0; col < num; col++)
		{
			for (int row = 0; row < 7; row++)
			{
				hourTotals[col] += array[col][row];
			}
		}
		return hourTotals;		
	}
}

