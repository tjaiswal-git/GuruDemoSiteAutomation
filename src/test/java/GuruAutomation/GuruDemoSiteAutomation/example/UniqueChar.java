package GuruAutomation.GuruDemoSiteAutomation.example;

import java.util.HashSet;
import java.util.Set;

public class UniqueChar {

	public boolean isUnique(String str)
	{
		char[] ch = str.toCharArray();
		Set<Character> setChar=new HashSet<Character>();
		for(Character charWord:ch)
		{
			if(!setChar.add(charWord))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[])
	{
		UniqueChar obj=new UniqueChar();
		System.out.println(obj.isUnique("Tarun"));
	}
	
}
