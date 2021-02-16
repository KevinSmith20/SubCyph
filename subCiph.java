import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class subCiph {
  public static void main(String[] args) throws FileNotFoundException {
	Scanner kb = new Scanner(System.in);
	
	char[] plaintext = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] cyphtext = KeyGen();
	
    System.out.print("Enter a string consisting of only letters to encrypt (Type -1 to quit, press 2 to encrypt twilight and see the frequency of the letters): ");
    if(kb.hasNextInt()) {
    	int choice = kb.nextInt();
    	if(choice == -1) {
    		System.exit(0);
    	}
    	if(choice == 2) {
    		File twi = new File("twilight.txt");
    		Scanner midnight = new Scanner(twi);
    		String s = "";
    		while(midnight.hasNextLine()) {
    			//System.out.println(midnight.nextLine());
    			s = s.concat(midnight.nextLine());
    		}
    		System.out.println(s);
    		String encTwi =Encrypt(s,plaintext,cyphtext);
    		System.out.println(encTwi);
    		//String decTwi = Decrypt(encTwi,cyphtext,plaintext);
    		//ystem.out.println(decTwi);
    		//Frequency(encTwi, plaintext);
    	}
    }
    else if(kb.hasNext()) {
    	String plain = kb.nextLine();
        
        String cipher = Encrypt(plain, plaintext, cyphtext);
        System.out.println("The encrypted text is :" + cipher);
        
        System.out.println("Type -1 to see the frequencies of the letters:");
    	int choice = kb.nextInt();
    	if(choice == -1) {
    		Frequency(cipher, plaintext);
    	}
    	
        System.out.println("Type -1 to decrypt the message:");
    	int choicer = kb.nextInt();
    	if(choicer == -1) {
    		String rehpic = Decrypt(cipher, cyphtext, plaintext);
            System.out.println(rehpic);
    	}
    }
  }
  
  static String Encrypt(String input, char[] plain, char[] cyph){
	    String string = input.toUpperCase().replaceAll("[^A-Za-z]+", "");
	    char[] chararr = new char[string.length()];
	    int j = 0;
	    for(char c : string.toCharArray()) {
	    	int i = 0;
	    	while(c != plain[i]) {
	    		i++;
	    	}
	    	chararr[j] = cyph[i];
	    	j++;
	    }
	    String finalStr = String.valueOf(chararr);
		return finalStr; 
  }
  static String Decrypt (String input, char[] cyph, char[] plain){
	    String string = input.toUpperCase().replaceAll("\\s","");
	    char[] chararr = new char[string.length()+20];
	    int j = 0;
	    for(char c : string.toCharArray()) {
	    	int i = 0;
	    	while(c != cyph[i]) {
	    		i++;
	    	}
	    	chararr[j] = plain[i];
	    	j++;
	    }
	    String finalStr = String.valueOf(chararr);
		return finalStr; 
  }
  static char[] KeyGen() {
	  char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	  Character[] listChar = new Character[26];
	  int j = 0;
	  for (char c : arr) {
		  listChar[j] = arr[j];
		  j++;
	  }
	  List<Character> charList = Arrays.asList(listChar);
	  Collections.shuffle(charList);
	  charList.toArray(listChar);
	  char[] chars = new char[26];
	  for (int i = 0; i < 26; i++) {
		  arr[i] = listChar[i];
	  }
	  return arr;
  }
  static void Frequency(String st, char[] plain) {
	  st = st.toUpperCase().replaceAll("[^A-Za-z]+", "");
	  double[] chararr = new double[26];
	  for(char d: st.toCharArray()) {
		  int i = 0;
		  while(d != plain[i]) {
			  i++;
		  }
		  chararr[i]++;
	  }
	  double length = st.length();
	  System.out.println("Frequency of every letter showing up");
	  for(int k = 0; k < 26; k++) {
		  System.out.println(plain[k] + " : " + chararr[k]*100/length + "%");
	  }
  }
}
 