import java.util.Scanner;

public class SentenceFinder2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		boolean printSentence = false;
		boolean lastLetter = true;
		int wordIndex = 0;
		String lastSentence = "";

		
		//Saves text and word
		System.out.println("Enter Text: ");		
		Scanner userinput1 = new Scanner(System.in);		
		Scanner userinput2 = new Scanner(System.in);		
		String text = userinput1.nextLine();
		System.out.println("Word: ");		
		String word = userinput2.nextLine();
				
				
		//Goes through all the words finds if chars are compatible
				for(int i=0;i<text.length();i++)
				{
					lastSentence += text.charAt(i);
					
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
					if(text.charAt(i) == '.'){
						if(printSentence == true)
						{
						System.out.println(lastSentence);
						printSentence = false;
						}
					
					}
				}
		}
}


/*problem: lastSentence holds all text((lastSentenc += word.charAt(i)) line 27) once printSentence
 checks out true all text is printed instead of just the sentences containing the selected word*/

//make program work without variable lastSentence can use any variable other than string
