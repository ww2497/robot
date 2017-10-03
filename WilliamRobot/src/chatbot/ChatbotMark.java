package chatbot;

public class ChatbotMark implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotMark() {
		String[] temp = {"Brooklyn","Manhatton","Queens","Bronx","Staten Island"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "New Amsterdam";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! We in Brooklyn, NYC and I know all the best spots all over the city. You want duh best pizza spot, pssh, fuhgettaboutit. Where are you right now?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0 ) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0 ) >= 0) {
				ChatbotMain.print("Bleep bloop, How did you know i was a robot?!");
				response = ChatbotMain.getInput();
			}else {
				for(int i = 0; i < keywords.length; i++) {
					if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						
					}
				}
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
