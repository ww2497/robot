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
private boolean rec;
	public ChatbotTheo() {
		String[] temp = {"food","eat","hungry","restaurants"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "";
		String[] asdf = {"yea","yes","ok","sure"};
		yes = asdf;
		brRec = "Nathan's famous";
		mRec = "Katz Delicatessen";
		qRec = "HinoMaru Ramen's";
		bRec = "Brook Luncheonette";//
		sRec= "McDonalds";
		rec=false;
	}
//
	@Override
	public void talk(String response) {
		if(rec==false) {
		ChatbotMain.print("Would you like me to recomend somewhere to eat");
		response= ChatbotMain.getInput();
		for(int i=0;i<yes.length;i++) {
			if(ChatbotMain.findKeyword(response,yes[i] , 0)>=0) {
				if(ChatbotMain.chatbot.getLocation().equals("brookyln")) {
					ChatbotMain.print("You should go to "+brRec+".");
					ChatbotMain.chatbot.setDestination(brRec);
					ChatbotMain.chatbot.setTrain("Q");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("bronx")) {
					ChatbotMain.print("You should go to "+bRec+".");
					ChatbotMain.chatbot.setDestination(bRec);
					ChatbotMain.chatbot.setTrain("6");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("queens")) {
					ChatbotMain.print("You should go to "+qRec+".");
					ChatbotMain.chatbot.setDestination(qRec);
					ChatbotMain.chatbot.setTrain("W");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("staten island")) {
					ChatbotMain.print("You should go to "+sRec+".");
					ChatbotMain.chatbot.setDestination(sRec);
					ChatbotMain.chatbot.setTrain("A");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("manhattan")) {
					ChatbotMain.print("You should go to "+mRec+".");
					ChatbotMain.chatbot.setDestination(mRec);
					ChatbotMain.chatbot.setTrain("F");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("unknown"))
				ChatbotMain.print("I don't know where you are you are could you tell me what borough your in");
				response = ChatbotMain.getInput();
				ChatbotMain.chatbot.startMark(response);
				return;
				
			}//
			else {
				ChatbotMain.print("ok I will not recomend somewhere for you to eat");
				rec = true;
			}
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
