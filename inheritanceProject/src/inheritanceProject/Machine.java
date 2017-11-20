package inheritanceProject;

public abstract class Machine 
{
	protected String machineName;
	protected String machineDescription;
		
	public Machine(){};
	
	public String getName()
	{ return machineName; }
	public String getDesc()
	{ return machineDescription; }
	public abstract double getPrice();
	public abstract double getWeight();
	
	public void setName(String str)
	{ machineName = str; }
	public void setDesc(String str)
	{ machineDescription = str; }	
}
