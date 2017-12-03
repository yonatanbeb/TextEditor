import java.util.ArrayList;
import java.util.Scanner;				
public class SentenceFinder {				
	public static void main(String[] args){			
		String[] array;
		int pFinal = 0;
		int iFinal = 0;		
		int jFinal = 0;		
		int nFinal = 0;	
		int qFinal = 0;
		int rFinal = 0;
		int sFinal = 0;
		System.out.println("Enter Text: ");		
		Scanner userinput1 = new Scanner(System.in);		
		Scanner userinput2 = new Scanner(System.in);		
		String text = userinput1.nextLine();		
		System.out.println("Word: ");		
		String word = userinput2.nextLine();
		String[] array1 = text.split(" ");

		for(int i = 0;i<array1.length;i++){		
			if(array1[i].equals(word)){	
				iFinal = i;
				break;			
			}	
		}	
		for(int j = iFinal;j < array1.length;j++){   		
			if(array1[j].length() > 0 && array1[j].charAt(array1[j].length() - 1) == '.'){	
				if(j == 0);
				jFinal=j;
				break;
			}	
		}		
		for(int n = iFinal ;n>0;n-- ){		
			if(array1[n].length() > 0 && array1[n].charAt(array1[n].length() - 1) == '.'){	
				nFinal=n;
				break;
			}	
		}		
		for(int p = (nFinal+1);p<jFinal+1 ;p++){		
			System.out.print(array1[p] + " ");	
			pFinal = p;
			
		}		
		for(int p = (nFinal+1);p<jFinal+1 ;p++){		
//			array1.remove(array[p] + " ");	
			
			
		
	
//DOES IT AGAIN FROM LAST STARTING POINT	
//		for(int q = pFinal;q<array.length;q++){		
//			if(array[q].equals(word)){	
//				qFinal = q;
//				break;
//			}	
//		}		
//		for(int r = qFinal;r<array.length;r++){   		
//			if(array[r].length() > 0 && array[r].charAt(array[r].length() - 1) == '.'){	
//				if(r == 0);
//				rFinal=r;
//				break;
//			}	
//		}		
//		for(int s = qFinal ;s>0;s-- ){		
//			if(array[s].length() > 0 && array[s].charAt(array[s].length() - 1) == '.'){	
//				sFinal=s;
//				break;
//			}	
//		}		
//		for(int t = (sFinal+1);t<rFinal+1 ;t++){		
//			System.out.print(array[t] + " ");	
//		}				
//				
//				
//		}		
				
	{			
}				
}
}
}

	

