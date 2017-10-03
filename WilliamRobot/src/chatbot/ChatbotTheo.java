package chatbot;

public class ChatbotTheo implements Topic {
private String [] keywords;
private String goodbyeKeyword;
private String secretKeyword;
private String [] responses;
	public ChatbotTheo() {
		String[] temp = {"food","eat","hungry","restaurants"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "";
		String[] asdf = {};
		responses = asdf;
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Would you like me to recomend somewhere to eat");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0)==-1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0)>=0) {
				ChatbotMain.print("Get dabbed on");
			}
			else {
				ChatbotMain.print("Im sorry I dont understand");
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
