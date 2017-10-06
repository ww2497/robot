package chatbot;

public class ChatbotTheo implements Topic {
private String [] keywords;
private String goodbyeKeyword;
private String secretKeyword;
private String [] responses;
private String[] yes;
private String brRec;//brookyln
private String mRec;//manhattan
private String qRec;//queens
private String sRec;//Staten Island
private String bRec;//Bronx
private String allRec;
	public ChatbotTheo() {
		String[] temp = {"food","eat","hungry","restaurants"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "";
		String[] asdf = {"yea","yes","ok","sure"};
		yes = asdf;
		brRec = "Two Bros pizza";
		mRec = "Shake Shack";
		qRec = "Applebee's";
		bRec = "Dunkin donuts";
		sRec= "McDonalds";
	}
//
	@Override
	public void talk(String response) {
		ChatbotMain.print("Would you like me to recomend somewhere to eat");
		response= ChatbotMain.getInput();
		for(int i=0;i<yes.length;i++) {
			if(ChatbotMain.findKeyword(response,yes[i] , 0)>=0) {
				if(ChatbotMain.chatbot.getLocation().equals("brookyln")) {
					ChatbotMain.print("You should go to "+brRec+".");
				}
				if(ChatbotMain.chatbot.getLocation().equals("bronx")) {
					ChatbotMain.print("You should go to "+bRec+".")
				}
				if(ChatbotMain.chatbot.getLocation().equals("queens")) {
					ChatbotMain.print
				}
				ChatbotMain.print("test test");
			}
		}
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
