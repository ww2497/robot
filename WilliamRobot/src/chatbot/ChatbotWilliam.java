package chatbot;

public class ChatbotWilliam implements Topic {

	private String[] keywords;
	private String[] decline;
	private String[] lost;
	private String response;
	private String goodByeKeyword;
	private boolean chatting;
	private static String train;
	private static String destination;
	
	public ChatbotWilliam() {
		String[] directions = {"where is", "get there", "go there", "go to", "get to", "directions"};
		keywords = directions;
		String[] no = {"no", "nah", "nope", "im good", "i'm good"};
		decline = no;
		String[] help = {"lost", "map", "how do i", "where is"};
		lost = help;
		String[] togo = {"statue of liberty", "map", "how do i", "where is"};
		lost = help;
		response = "";
		chatting = true;
	}
	@Override
	public void talk(String response) {
			ChatbotMain.print("Take the " + ChatbotMain.chatbot.getTrain() + " train to get to " + ChatbotMain.chatbot.getDestination() + ". Anything else you need, " + ChatbotMain.chatbot.getUsername() + "?");
			response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodByeKeyword, 0) == -1) {
			for(int i = 0; i < decline.length; i++) {
				if(ChatbotMain.findKeyword(response, decline[i], 0) >= 0) {
					ChatbotMain.print("Alright. Say 'sightseeing' or 'food' to summon the sightseeing bot or foodbot respectively.");
					response = ChatbotMain.getInput();
					ChatbotMain.chatbot.checkTriggered(response);
				}
			}
			for(int i = 0; i < lost.length; i++) {
				if(ChatbotMain.findKeyword(response, lost[i], 0) >= 0) {
					ChatbotMain.print("Here's a map of the MTA Subway: http://web.mta.info/maps/submap.html. Did that help?");
					response = ChatbotMain.getInput();
					if(response == "no" || response == "nah" || response == "not really")
					{
						ChatbotMain.print("I'm sorry to hear that.");
					}
				}
			}
			response = ChatbotMain.getInput();
			ChatbotMain.chatbot.checkTriggered(response);
		}
		ChatbotMain.print("Say , "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.checkTriggered(response);
		ChatbotMain.chatbot.startChatting();
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
