package chatbot;

public class ChatbotMark implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotMark() {
		String[] temp = {"stuff","things","something","nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "bloop";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! We in Brooklyn, NYC and I know all the best spots all over the city. You want duh best pizza spot, pssh, fuhgettaboutit. Name spot you wanna know about.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0 ) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0 ) >= 0) {
				ChatbotMain.print("Bleep bloop, How did you know i was a robot?!");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("Yeah, thats cool I guess, what else you got?");
				response = ChatbotMain.getInput();
			}
		}
		//access stuff from other class
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT 
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
