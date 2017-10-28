package GuruAutomation.GuruDemoSiteAutomation.InterviewCoding;

 class OverideMethods1 {

	public static void dispaly()
	{
		System.out.println("display of base class");
	}
	
	public void print()
	{
		System.out.println("print of base class");
	}
	
}

class A1 extends OverideMethods1
{
	public static void display()
	{
		System.out.println("display of child class");
	}
	
	public void print()
	{
		System.out.println("print of child class");
	}
}

public class OverideMethods

{
	public static void main(String[] args) 
	{
	
		A1
		obj=new A1();
		obj.dispaly();
		obj.print();
	}

}
