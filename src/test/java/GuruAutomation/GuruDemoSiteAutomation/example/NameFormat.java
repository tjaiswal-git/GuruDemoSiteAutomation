package GuruAutomation.GuruDemoSiteAutomation.example;

public class NameFormat {

	public void nameFormat(String str) {
		String splitWords[] = str.split("\\s");
		// System.out.println("length of "+splitWords.length);
		if (splitWords.length == 3) {
			String newStr = "";
			for (int i = 0; i < splitWords.length; i++) {
				if (i <= 1) {
					for (int j = 0; j < 1; j++) {

						newStr = newStr + String.valueOf(Character
								.toUpperCase(splitWords[i].charAt(j))) + ".";
					}
				}
				if (i == 2) {
					for (int j = 0; j < splitWords[i].length(); j++) {
						if (j == 0) {
					
							newStr = newStr + String.valueOf(Character.toUpperCase(splitWords[i]
									.charAt(j)));

						} else { // System.out.println("length "+splitWords[i].length());
					
							newStr = newStr + String.valueOf(splitWords[i].charAt(j));
						}
					}
				}
			}

			System.out.println(newStr);
		} else {
			System.out.println("String is not a proper format");
		}
	
	
	
	}
	
	public void nameFormatOfSubstring(String str)
	{
	  String s[]= str.split(" ");
	  System.out.println(s[0].substring(0, 1).toUpperCase()+"."+s[1].substring(0,1).toUpperCase()+"."+s[2].substring(0, 1).toUpperCase()+
			  s[2].substring(1,s[2].length()));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NameFormat obj = new NameFormat();
		obj.nameFormat("mahendra singh dhoni");
		obj.nameFormatOfSubstring("tarun kumar jaiswal");
	}

}
