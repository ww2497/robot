package chatbot;

public class TheoChatbot implements Topic {
private String [] keywords;
private String goodbyeKeyword;
private String secretKeyword;
private String response;
	public TheoChatbot() {
		String[] temp = {"stuff","things","whatever","nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "dab";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("So youwant to talk");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0)==-1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0)>=0) {
				ChatbotMain.print("Get dabbed on");
			}
			else {
				ChatbotMain.print("ok");
			}
		}
		ChatbotMain.print("Well, it was nice talking to you"+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
	public boolean isTriggered(String response) {
		for (int i=0;i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i],0)>=0) {
			return true;	
			}
		}
		return false;
	}
}
