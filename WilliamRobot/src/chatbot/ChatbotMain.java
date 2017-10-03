package chatbot;

import java.util.Scanner;



public class ChatbotMain {

	public static final Chatbot chatbot = new Chatbot();
	private static Scanner inputSource = new Scanner(System.in);
	public static void main(String[] args) {
		chatbot.startChatting();
	}
	
	public static int findKeyword(String searchString, String keyword, int startPsn) {
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		
		int psn = searchString.indexOf(keyword, startPsn);
		
		while(psn>= 0) {
			if(keywordIsIsolated(psn, keyword, searchString)&& noNegations(searchString, psn)) {
				return psn;
			}else {
				psn = searchString.indexOf(keyword, psn+1);///returns index of next keyword
			}
			
		}
		return -1;
	}
//
		public static boolean keywordIsIsolated(int psn, String keyword, String s){
			int end = keyword.length()+psn;
			String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			if(psn == 0) {
				for(int i=0;i<alphabet.length;i++){
				if(s.substring(keyword.length(),keyword.length()+1).toLowerCase().equals(alphabet[i])){
					return false;
					}
					else{
						return true;
					}
				}
				
			}
			for(int i=0;i<alphabet.length;i++){
				if(s.substring(psn-1,psn).toLowerCase().equals(alphabet[i])){
					return false;
				}
				if(s.substring(end+1,end+2).toLowerCase().equals(alphabet[i])){
					return false;
				}
			}
			return true;
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
