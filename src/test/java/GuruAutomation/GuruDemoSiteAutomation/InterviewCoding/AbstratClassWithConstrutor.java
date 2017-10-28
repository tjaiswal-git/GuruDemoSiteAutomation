package GuruAutomation.GuruDemoSiteAutomation.InterviewCoding;

abstract class Product {

	int value;
	public Product(int val) 
	{
		this.value=val;
	}
	
	public int multiply(int mul)
	{
		return mul*value;
	}
	
}

class A extends Product
{

	public A() {
		 super(2);
		
	}
	
}

class B extends Product
{
	public B()
	{
		super(5);
	}
}

public class AbstratClassWithConstrutor
{
public static void main(String[] args) {
		
	A obj=new A();
	System.out.println(obj.multiply(5));

	}


}