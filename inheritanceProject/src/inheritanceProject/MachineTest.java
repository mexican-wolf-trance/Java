package inheritanceProject;
import java.util.*;
import java.util.ArrayList;

public class MachineTest 
{
	public static void main (String [] args)
	{
		Scanner gPrice, gWeight, gName, gDesc, answer, length;
		ArrayList<Machine> machines = new ArrayList<Machine>();
		String[] classes;
		double price, weight;
		int i, len;
		String name, desc;
					
		System.out.println("How many machines?");
		length = new Scanner(System.in);
		len = length.nextInt();
		classes = new String[len];
		
		for (int n = 0; n < len; n++)
		{
			while(true)
			{	
				System.out.println("What would you like?\n1. Scanner\n2. Printer\n3. Smartphone");
				answer = new Scanner(System.in);
				i = answer.nextInt();
				if (i == 1)
				{
					classes[n] = "Scanner";
					while(true)
					{
						try
						{
							System.out.println("Scanner:");
							System.out.println("Enter the price");
							gPrice = new Scanner(System.in);
							price = gPrice.nextDouble();
							System.out.println("Enter the weight");
							gWeight = new Scanner(System.in);
							weight = gWeight.nextDouble();
							System.out.println("Enter the name");
							gName = new Scanner(System.in);
							name = gName.nextLine();
							System.out.println("Enter a short description");
							gDesc = new Scanner(System.in);
							desc = gDesc.nextLine();
							machines.add(new Scannerr(name , price , weight, desc));
						}
						catch (InputMismatchException ex)
						{
							System.out.println("Erroneous input");
							continue;
						}
						break;
					}
					break;
				}
				else if (i == 2)
				{
					classes[n] = "Printer";
					while(true)
					{
						try
						{
							System.out.println("Printer:");
							System.out.println("Enter the price");
							gPrice = new Scanner(System.in);
							price = gPrice.nextDouble();
							System.out.println("Enter the weight");
							gWeight = new Scanner(System.in);
							weight = gWeight.nextDouble();
							System.out.println("Enter the name");
							gName = new Scanner(System.in);
							name = gName.nextLine();
							System.out.println("Enter a short description");
							gDesc = new Scanner(System.in);
							desc = gDesc.nextLine();
							machines.add(new Printer(name , price , weight, desc));
						}
						catch (InputMismatchException ex)
						{
							System.out.println("Erroneous input");
							continue;
						}
						break;
					}
					break;
				}
				else if (i == 3)
				{
					classes[n] = "Smartphone";
					while(true)
					{
						try
						{
							System.out.println("Smartphone:");
							System.out.println("Enter the price");
							gPrice = new Scanner(System.in);
							price = gPrice.nextDouble();
							System.out.println("Enter the weight");
							gWeight = new Scanner(System.in);
							weight = gWeight.nextDouble();
							System.out.println("Enter the name");
							gName = new Scanner(System.in);
							name = gName.nextLine();
							System.out.println("Enter a short description");
							gDesc = new Scanner(System.in);
							desc = gDesc.nextLine();
							machines.add(new Smartphone(name , price , weight, desc));
						}
						catch (InputMismatchException ex)
						{
							System.out.println("Erroneous input");
							continue;
						}
						break;
					}
					break;
				}	
				else
				{
			      System.out.println("Erroneous input");
			      continue;
				}
			}
		}
		for (int n = 0; n < machines.size(); n++)
		{
			System.out.println("Machine: " + (n+1) + " (" + classes[n] + ")");
			System.out.println("Name: " + machines.get(n).getName());
			System.out.println("Description: " + machines.get(n).getDesc());
			System.out.println("Price: " + machines.get(n).getPrice());
			System.out.println("Weight: " + machines.get(n).getWeight());
			System.out.printf("\n");
		}
		length.close();
	}
}