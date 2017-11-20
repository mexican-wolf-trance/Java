package inheritanceProject;

public class Printer extends Machine
{
	private double printerPrice;
	private double printerWeight;
	
	public Printer()
	{ System.out.println("PRINTER"); }
	public Printer(String str1 , double a , double b , String str2)
	{
		machineName = str1;
		if (a < 40 || a > 200)
			printerPrice = 90; 
		else
			printerPrice = a;
		if (b > 50)
			printerWeight = 25; 
		else
			printerWeight = b;
		machineDescription = str2;
		System.out.println("PRINTER COMPLETE");
	}
	
	public double getPrice()
	{ return printerPrice; }
	public double getWeight()
	{ return printerWeight; }
	
	public void setPrice(double a)
	{ 
		if (a < 40 || a > 200)
			printerPrice = 90; 
		else
			printerPrice = a;
	}
	public void setWeight(double a)
	{ 
		if (a >= 50)
			printerWeight = 25; 
		else
			printerWeight = a;
	}
}
