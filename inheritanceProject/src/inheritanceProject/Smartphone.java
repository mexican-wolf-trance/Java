package inheritanceProject;

public class Smartphone extends Machine
{
	private double smartphonePrice;
	private double smartphoneWeight;
	
	public Smartphone()
	{ System.out.println("SMARTPHONE"); }
	public Smartphone(String str1 , double a , double b , String str2)
	{
		machineName = str1;
		if (a < 220 || a > 350)
			smartphonePrice = 200; 
		else
			smartphonePrice = a;
		if (b < 0.25 || b > 0.5)
			smartphoneWeight = 0.3; 
		else
			smartphoneWeight = b;
		machineDescription = str2;
		System.out.println("SMARTPHONE COMPLETE");
	}
	
	public double getPrice()
	{ return smartphonePrice; }
	public double getWeight()
	{ return smartphoneWeight; }
	
	public void setPrice(double a)
	{ 
		if (a < 220 || a > 350)
			smartphonePrice = 200; 
		else
			smartphonePrice = a;
	}
	public void setWeight(double a)
	{ 
		if (a < 0.25 || a > 0.5)
			smartphoneWeight = 0.3; 
		else
			smartphoneWeight = a;
	}
}
