import java.util.Scanner;

public class SentenceFinder3 
{

	public static String printCompatibleSentence(String string) 
	{
		// TODO Auto-generated method stub
		
		boolean printSentence = false;
		boolean lastLetter = true;
		int wordIndex = 0;
//		String lastIndex = "";
		int lastIndex = 0;
		int lastIndex2 = 0;
		
		//Saves text and word
//		System.out.println("Enter Text: ");		
//		Scanner userinput1 = new Scanner(System.in);		
//		Scanner userinput2 = new Scanner(System.in);		
		String text = MainWindow.CreateContents(innertopleft.getText().trim());
//		System.out.println("Word: ");		
		String word = MainWindow.CreateContents(text.getText().trim());
				
				
		//Goes through all the words finds if chars are compatible
				for(int i=0;i<text.length();i++)
				{
					lastIndex = i;	// shoulden't be here because always resets to i
									// need to asign that if no word is compatible, lastIndex returns to 0
					if (text.charAt(i) != ' ' && text.charAt(i) != '.')
					{
						if(wordIndex >= word.length() )
						{
							lastLetter = false;	
						}

						else
						{
							if(text.charAt(i) != word.charAt(wordIndex))
							{
								lastLetter = false;
								
							}
							
						}
						wordIndex++;
					}
					
					
					else
					{ 
						
						
						if(lastLetter == true)
						{
							printSentence = true;
						}
						lastLetter = true;
						wordIndex = 0;
						
					}
					
					if(text.charAt(i) == '.')
					{
						if(printSentence == true)
						{
							for(int z = (text.length()-lastIndex-1);z<lastIndex+1;z++)
							{
								System.out.print(text.charAt(z));
							}
							System.out.println("\n" + lastIndex2);
							
						}
		
						printSentence = false;
					}	
				}
				return word;
	}
}



	




