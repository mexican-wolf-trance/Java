package employeeArray;
import java.util.Scanner;

public class employeeHoursCalc 
{
	public int empNum;
	public String [] empl;
	public double [][] hours;
			
	public employeeHoursCalc(){}
	/////////////////////////////////////////////////
	/* A string array is created that holds the    */
	/* employee designation that will correspond   */
	/* to the hours worked for that employee       */
	/////////////////////////////////////////////////	
	public void setEmpl()
	{
		empl = new String[empNum];
		for (int count = 0; count < empNum; count++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("Employee_");
			sb.append(count + 1);
			sb.append(": ");
			empl[count] = sb.toString();
		}
	}
	/////////////////////////////////////////////////
	/* This creates a multidimensional array that  */
	/* stores the numbers of hours worked per day  */
	/* per employee.                               */
	/////////////////////////////////////////////////
	public void setHours()
	{
		Scanner hoursInput = new Scanner(System.in);
		hours = new double[empNum][7];
		String weekDays[] = {"Sunday" , "Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday"};
		for (int col = 0; col < empNum; col++)
		{
			System.out.println("Enter the hours for Employee " + (col + 1) + ": ");
			for (int row = 0; row < 7; row++)
			{
				System.out.print(weekDays[row] + ": ");
				hours[col][row] = hoursInput.nextDouble();
			}
		}
		hoursInput.close();
	}
	/////////////////////////////////////////////////
	/* Here we use a selection sort algorithm to   */
	/* sort the total hours worked per week per    */
	/* employee but also sorts the employee number */
	/* array at the same time. They both then get  */
	/* displayed in descending order               */
	/////////////////////////////////////////////////
	public void sortAndDisplay(double array[])
	{
		{
		   int startScan, minIndex, minValue;
		   String minVal;
		   
		   for (startScan = 0; startScan < (empNum - 1); startScan++)
		   {
		      minIndex = startScan;
		      minValue = (int)array[startScan];
		      //Sort the string array at the same rate as the hours array
		      minVal = empl[startScan];
		      for(int index = startScan + 1; index < empNum; index++)
		      {
		         if (array[index] < minValue)
		         {
		            minValue = (int)array[index];
		            minIndex = index;
		            
		            minVal = empl[index];
		         }
		      }
		      array[minIndex] = array[startScan];
		      array[startScan] = minValue;
		      
		      empl[minIndex] = empl[startScan];
		      empl[startScan] = minVal;
		   }
		}
		//And display
		for (int count = 0; count < empNum; count++)
		{
			System.out.println(empl[count] + " " + array[count]);
		}
	}
}

