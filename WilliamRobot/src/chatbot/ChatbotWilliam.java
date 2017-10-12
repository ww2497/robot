package chatbot;

public class ChatbotWilliam implements Topic {

	private String[] keywords;
	private String[] decline;
	private String[] lost;
	private String[] repeat;
	private boolean chatting;
	
	public ChatbotWilliam() {
		String[] directions = {"where is", "get there", "go there", "go to", "get to", "directions"};
		keywords = directions;
		String[] no = {"no", "nah", "nope", "im good", "i'm good"};
		decline = no;
		String[] help = {"lost", "map", "how do i", "where is"};
		lost = help;
		String[] again = {"repeat", "again", "directions", "train"};
		repeat = again;
		chatting = true;
	}
	public void talk(String response) {
		chatting = true;
		if(ChatbotMain.chatbot.getDestination() == "unknown") {	
		ChatbotMain.print("Where do you want to go?");
			response = ChatbotMain.getInput();
		ChatbotMain.print("Take the " + ChatbotMain.chatbot.getTrain() + " train to get to " + ChatbotMain.chatbot.getDestination() + ". Anything else you need, " + ChatbotMain.chatbot.getUsername() + "?");
			response = ChatbotMain.getInput();
		}else if(ChatbotMain.chatbot.getLocation().equals("unknown")){
			ChatbotMain.print("Okay, but first I need to know where you are right now. What neighborhood are you in right now?");
			response = ChatbotMain.getInput();
			ChatbotMain.chatbot.setLocation(response);
		}
		while(chatting) {
			for(int i = 0; i < decline.length; i++) {
				if(ChatbotMain.findKeyword(response, decline[i], 0) >= 0) {
					ChatbotMain.print("Alright. Say 'sightseeing' or 'food' to summon the sightseeing bot or foodbot respectively.");
					response = ChatbotMain.getInput();
					if(ChatbotMain.chatbot.checkTriggered(response)) {
//						ChatbotMain.chatbot.checkTriggered(response);
						chatting = false;
						break;
					}
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
					else if(response == "yes" || response == "yeah" || response == "somewhat")
					{
						ChatbotMain.print("I'm glad to hear that.");
					}
					else 
					{
						ChatbotMain.print("Uh... Okay. Anything else you need?");
					}
				}
			}
			for(int i = 0; i < repeat.length; i++) {
				if(ChatbotMain.findKeyword(response, repeat[i], 0) >= 0) {
					ChatbotMain.print("Take the " + ChatbotMain.chatbot.getTrain() + " train to get to " + ChatbotMain.chatbot.getDestination() + ". Anything else you need, " + ChatbotMain.chatbot.getUsername() + "?");
				}
			}
			response = ChatbotMain.getInput();
			ChatbotMain.chatbot.checkTriggered(response);
		}
		
		response = ChatbotMain.getInput();
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