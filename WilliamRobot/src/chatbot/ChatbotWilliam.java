package chatbot;

public class ChatbotWilliam implements Topic {

	private String[] keywords;
	private String[] decline;
	private String[] lost;
	private String[] repeat;
	private String[] yes;
	private String response;
	private String goodByeKeyword;
	private String repeating;
	private boolean chatting;
	private boolean saidSomething;
	private static String train;
	private static String destination;
	
	
	public ChatbotWilliam() {
		String[] directions = {"where is", "get there", "go there", "go to", "get to", "directions"};
		keywords = directions;
		String[] no = {"no", "nah", "nope", "im good", "i'm good"};
		decline = no;
		String[] help = {"lost", "map", "how do i", "where is"};
		lost = help;
		String[] again = {"repeat", "again", "directions", "train"};
		repeat = again;
		String[] affirmative = {"yes", "yeah", "yea"};
		yes = affirmative;
		repeating = "";
		response = "";
		chatting = true;
	}
	public void talk(String response) {
		if(ChatbotMain.chatbot.getDestination() != null) {	
			ChatbotMain.print("Hi, I'm the transportation bot. You can take the " + ChatbotMain.chatbot.getTrain() + " train to get to " + ChatbotMain.chatbot.getDestination() + ". Anything else you need, " + ChatbotMain.chatbot.getUsername() + "?");
			response = ChatbotMain.getInput();
		}else {
			ChatbotMain.print("Transportation bot here: I'm not quite sure how to get there, sorry. Is there anything else I can help you with?");
			response = ChatbotMain.getInput();
		}
		A: while(chatting) {
			saidSomething = false;
			while(repeating.equals(response)) {
				ChatbotMain.print("Repeating yourself doesn't get the point across any better. Is there anything else I can help you with?");
				response = ChatbotMain.getInput();
			}
			repeating = response;
			for(int i = 0; i < decline.length; i++) {
				if(ChatbotMain.findKeyword(response, decline[i], 0) >= 0) {
					ChatbotMain.print("Alright. You can say 'bye' to go back to the main tourbot.");
					response = ChatbotMain.getInput();
					if(ChatbotMain.chatbot.checkTriggered(response)) {
						chatting = false;
						break A;
					}
					else
					{
						ChatbotMain.print("I didn't quite understand that, " + ChatbotMain.chatbot.getUsername() + ".");
					}
					saidSomething = true;
				}
			}
			for(int i = 0; i < yes.length; i++) {
				if(ChatbotMain.findKeyword(response, yes[i], 0) >= 0) {
					ChatbotMain.print("What do you need help with? As the transportation bot, I can give you directions to the restaurant suggested by the foodbot or provide a map of the subway.");
					saidSomething = true;
				}
			}
			for(int i = 0; i < lost.length; i++) {
				if(ChatbotMain.findKeyword(response, lost[i], 0) >= 0) {
					ChatbotMain.print("Here's a map of the MTA Subway: http://web.mta.info/maps/submap.html. Did that help?");
					response = ChatbotMain.getInput();
					if(response.equals("no") || response.equals("nah") || response.equals("not really"))
					{
						ChatbotMain.print("I'm sorry to hear that. Is there anything else you need?");
					}
					else if(response.equals("yes") || response.equals("yeah") || response.equals("somewhat"))
					{
						ChatbotMain.print("I'm glad to hear that. Anything else you need?");
					}
					else 
					{
						ChatbotMain.print("Uh... Okay. Anything else you need?");
					}
					saidSomething = true;
				}
			}
			for(int i = 0; i < repeat.length; i++) {
				if(ChatbotMain.findKeyword(response, repeat[i], 0) >= 0) {
					if(ChatbotMain.chatbot.getDestination() != null) {	
						ChatbotMain.print("Take the " + ChatbotMain.chatbot.getTrain() + " train to get to " + ChatbotMain.chatbot.getDestination() + ". Anything else you need, " + ChatbotMain.chatbot.getUsername() + "?");
						saidSomething = true;
					}
				}
			}
			if(!saidSomething) {
				ChatbotMain.print("I didn't quite catch that. Is there something other than that I could help you with?");
			}
			response = ChatbotMain.getInput();
		}
		
		response = ChatbotMain.getInput();
		ChatbotMain.chatbot.checkTriggered(response);
		ChatbotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
}

