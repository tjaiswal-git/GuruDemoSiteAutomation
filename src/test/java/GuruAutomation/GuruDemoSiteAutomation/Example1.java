package GuruAutomation.GuruDemoSiteAutomation;

class CustomException extends Exception
{
 
	public CustomException(String string) 
	{
	super();	
	}

}
	


public class Example1
{

	 void productCheck(int weight) throws CustomException
	 {
			if(weight<100)
			{
				throw new CustomException("Product Invalid");
			}
	 }
	public static void main(String args[])
	{
	Example1 obj=new Example1();
	try {
		obj.productCheck(60);
	} catch (CustomException e) {
		
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
		
	}
	
	
}

