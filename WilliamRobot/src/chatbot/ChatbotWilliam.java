package chatbot;

public class ChatbotWilliam implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private boolean chatting;
	
	public ChatbotWilliam() {
		String[] temp = {"where is", "get there", "directions", "go to"};
		keywords = temp;
		secretKeyword = "pug";
		response = "";
		chatting = true;
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print("Hi! I am your New York City Tour Bot, please tell me your name?");
		
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.chatbot.getLocation() == "brooklyn") {
				ChatbotMain.print("It's located at" + "s.");
			}
			if(ChatbotMain.chatbot.getLocation() == "manhattan") {
				ChatbotMain.print("It's located at" + "s.");
			}
			if(ChatbotMain.chatbot.getLocation() == "queens") {
				ChatbotMain.print("It's located at" + "s.");
			}
			if(ChatbotMain.chatbot.getLocation() == "bronx") {
				ChatbotMain.print("It's located at" + "s.");
			}
			if(ChatbotMain.chatbot.getLocation() == "staten island") {
				ChatbotMain.print("It's located at" + "s. Anything else you need help with?");
			}
			if(mark.isTriggered(response)) {
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				mark.talk(response);
			}else if(theo.isTriggered(response)){
				chatting = false;
				theo.talk(response);
			}else if(william.isTriggered(response)) {
				chatting = false;
				william.talk(response);
			}else if(devin.isTriggered(response)) {
				chatting = false;
				devin.talk(response);
			}else {
				ChatbotMain.print("I don't know anything about that.");
			}
		}
	}

	@Override
	public boolean isTriggered(String response) {
		// TODO Auto-generated method stub
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubic)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}



}
