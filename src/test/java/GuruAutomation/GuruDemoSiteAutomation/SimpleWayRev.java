package GuruAutomation.GuruDemoSiteAutomation;

public class SimpleWayRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleWayRev obj=new SimpleWayRev();
        obj.simpleStr("test.test1.test2.test3");		

}
	
	public void simpleStr(String str)
	{
		
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
			
		}
		System.out.println(rev);
	}
	
}