package GuruAutomation.GuruDemoSiteAutomation;

public class SplitString {

	public void revString(String str)
	{
		
		String words[] = words=str.split("\\.");
		String newStr="";
	    for(int i=0;i<words.length;i++)
		{
			String rev="";
			for(int j=words[i].length()-1;j>=0;j--)
			{
				  rev= rev+words[i].charAt(j);
				
			}
			
			System.out.println("reverse "+rev);
			//System.out.println("words length "+words.length);
			if(i<words.length-1)
			{
			newStr=newStr+rev.concat(".");
			}
			else
			{
				newStr=newStr+rev;
			}
		}
		System.out.println(newStr);
		
	}
	
public static void main(String args[])
{
	SplitString obj=new SplitString();
	obj.revString("test.test1.test2.test3.test4.test5.test6");
}
}	

