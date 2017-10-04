package chatbot;

import java.util.Scanner;



public class ChatbotMain {

	public static final Chatbot chatbot = new Chatbot();
	private static Scanner inputSource = new Scanner(System.in);
	public static void main(String[] args) {
		chatbot.startChatting();
	}
	
	public static int findKeyword(String searchString,	String key,	int startIndex) {
	//delete white space
	String phrase = searchString.trim();
	//set all letters to lowercase
	phrase = phrase.toLowerCase();
	key = key.toLowerCase();
		
	//		System.out.println("The phrase is "+phrase);
	//		System.out.println("The key is "+key);
		
	//find position of key
	int psn = phrase.indexOf(key);
	//		System.out.println("The position found is "+psn);
	//keep looking for the word 
	//until you find the right context
	while(psn >= 0){
		String before = " ";
		String after = " ";
		//if the phrase does not end with this word
		if(psn + key.length() < phrase.length()){
			after = phrase.substring(psn + key.length(),
			psn + key.length()+1);
			//				System.out.println("The character after "
			//						+ key +" is "+after);
			}
			//if the phrase does not begin with this word
			if(psn >0){
				before = phrase.substring(psn-1,psn).toLowerCase();
				//				System.out.println("The character before "
				//						+ key +" is "+before);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
			//				System.out.println(key+" was found at "+psn);
				if(noNegations(phrase, psn)){
					return psn;					
				}
			}
			//in case the keyword was not found yet,
			//check the rest of the string
			psn = phrase.indexOf(key,psn+1);
			//			System.out.println(key+" was not found. "
			//					+ "Checking "+psn);
	}
		
		return -1;
	}
	 

	public static boolean noNegations(String s, int psn){
		String[] negations = {"don't", "not"};
		for(int i=0;i < negations.length;i++){
			int a = negations[i].length()+1;
			if(psn<negations[i].length()) {
				return true;
			}
			if(s.substring(psn-a,psn).toLowerCase().equals(negations[i])){
				return false;
			}
		}
		return true;
	}


	public static String getInput(){
		return inputSource.nextLine();
	}

	public static void print(String s){
		multiLinePrint(s);
	}

	public static void multiLinePrint(String s){
		String printString = "";
		int cutoff = 25;
		//this while loop last as long as there are words left in the original String
		while(s.length() > 0){

			String currentCut = "";
			String nextWord = "";

			//while the current cut is still less than the line length 
			//AND there are still words left to add
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				//add the next word
				currentCut += nextWord;

				//remove the word that was added from the original String
				s = s.substring(nextWord.length());

				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1) {
					endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				}

				//the next word should include the space
				nextWord = s.substring(0,endOfWord+1);
			}

			printString +=currentCut+"\n";

		}
		System.out.print(printString);
	}

	public static int getIntegerInput() {
		print("Please enter an integer.");
		String integerString = getInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			}catch(NumberFormatException e){
				print("You must enter an integer. You better try again.");
				integerString = getInput();
			}
		}
		return value;
	}

}
