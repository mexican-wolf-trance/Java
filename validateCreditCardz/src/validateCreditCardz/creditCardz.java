package validateCreditCardz;
import java.util.Scanner;

public class creditCardz 
{
	public static void main(String [] args)
	{
		//Create and load all of the variables and arrays
		long creditCardz;
		int len;
		int count2 = 0;
		int addNumNum = 0;
		int multNumNum = 0;
		int sum = 0;
		int total = 0;
		int multTotal;
		int cCardTotal;
		char [] cCardArray;
		int [] cCardAddArray;
		int [] cCardMultArray;		
		/////////////////////////////////////////////////
		/* Create the input variable and ask for       */
		/* a credit card number. Then convert the      */
		/* number to a string for further manipulation */
		/////////////////////////////////////////////////
		Scanner creditInput = new Scanner(System.in);
	
		System.out.print("Enter a credit card number as a long integer: ");	
		creditCardz = creditInput.nextLong();
		
		String cCardz = String.valueOf(Math.abs((long)creditCardz));	
		len = cCardz.length();
		
		//////////////////////////////////////////////////
		/* Check the number to ensure it is between 13  */
		/* and 16 numbers long and begins with either 4,*/
		/* 5, 37, and 6. If not, then try again.        */
		//////////////////////////////////////////////////
		while (true)
		{
			if ( len < 13 || len > 16)
			{
				System.out.println(creditCardz + " is invalid.");
				creditCardz = creditInput.nextLong();
				cCardz = String.valueOf(Math.abs((long)creditCardz));
				continue;
			}
			cCardArray = new char[len];		
			for (int count = 0; count < len; count++)
				cCardArray[count] = cCardz.charAt(count);
			
			if (cCardArray[0] != '4' && cCardArray[0] != '5' && cCardArray[0] != '3' && cCardArray[0] != '6')
			{
				System.out.println(creditCardz + " is invalid.");
				creditCardz = creditInput.nextLong();
				cCardz = String.valueOf(Math.abs((long)creditCardz));
				continue;
			}
			if (cCardArray[0] == '3')
			{
				if (cCardArray[1] != '7')
				{
					System.out.println(creditCardz + " is invalid.");
					creditCardz = creditInput.nextLong();
					cCardz = String.valueOf(Math.abs((long)creditCardz));
					continue;
				}
				else if (cCardArray[1] == '7')
					break;
			}
			else 
			{
				break;
			}
		}
		//////////////////////////////////////////////////////
		/* Here we do the addition and multiplication to    */
		/* check the number's validity. Depending on if the */
		/* number has an odd amount of integers, or even,   */
		/* determines the length of the array.              */
		//////////////////////////////////////////////////////		
		if (len % 2 == 0)
			cCardAddArray = new int[(len / 2)];
		else 
			cCardAddArray = new int[(len / 2) + 1];		
		//Add all the digits in the odd places from right to left
		for (int count = len - 1; count > -1; count -= 2)
		{			
			cCardAddArray[count2] = Character.getNumericValue(cCardArray[count]);
			addNumNum += cCardAddArray[count2];
			count2++;			
		}		
		//Double every second digit from right to left
		cCardMultArray = new int[(len / 2)];	
		count2 = 0;
		for (int count = len - 2; count > -1; count -= 2)
		{
			cCardMultArray[count2] = Character.getNumericValue(cCardArray[count]);
		//If it results in a two digit integer, add the two digits
			if (cCardMultArray[count2] * 2 > 9)
			{
				int num = (cCardMultArray[count2] * 2);
				sum = 0;
				while (num > 0)
				{
					sum = sum + num % 10;
					num = num / 10;
				}
				total += sum;
			}
			else
				multNumNum += cCardMultArray[count2] * 2;
			count2++;
		}
		//Then add them all together
		multTotal = total + multNumNum;
		cCardTotal = multTotal + addNumNum;		
		///////////////////////////////////////////////////
		/* Once the arithmetic is complete, we see if the*/
		/* number is valid.                              */
		///////////////////////////////////////////////////				
		if (cCardTotal % 10 == 0)
			System.out.println(creditCardz + " is valid.");
		else 
			System.out.println(creditCardz + " is invalid.");
		
		creditInput.close();		
	}	
}