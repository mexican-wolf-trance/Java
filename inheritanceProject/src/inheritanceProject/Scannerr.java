package inheritanceProject;

public class Scannerr extends Machine
{
	private double scannerPrice;
	private double scannerWeight;
	
	public Scannerr()
	{ System.out.println("SCANNER"); }
	public Scannerr(String str1 , double a , double b , String str2)
	{
		machineName = str1;
		if (a < 60 || a > 300)
			scannerPrice = 80; 
		else
			scannerPrice = a;
		if (b < 2 || b > 25)
			scannerWeight = 10; 
		else
			scannerWeight = b;
		machineDescription = str2;
		System.out.println("SCANNER COMPLETE");
	}
	
	public double getPrice()
	{ return scannerPrice; }
	public double getWeight()
	{ return scannerWeight; }
	
	public void setPrice(double a)
	{ 
		if (a < 60 || a > 300)
			scannerPrice = 80; 
		else
			scannerPrice = a;
	}
	public void setWeight(double a)
	{ 
		if (a < 2 || a > 25)
			scannerWeight = 10; 
		else
			scannerWeight = a;
	}
}
