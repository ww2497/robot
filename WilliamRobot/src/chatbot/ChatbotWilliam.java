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
		secretKeyword = "lost";
		response = "";
		chatting = true;
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print("Take the " + ChatbotMain.chatbot.getTrain() + " train to get to " + ChatbotMain.chatbot.getDestination() + ". Anything else you need?");
		response = ChatbotMain.getInput();
		while(chatting) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0 ) >= 0) {
				ChatbotMain.print("Here's a map of the MTA Subway: http://web.mta.info/maps/submap.html. Anything else you need?");
			}
			response = ChatbotMain.getInput();
			ChatbotMain.chatbot.checkTriggered(response);
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
