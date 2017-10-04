package chatbot;

public class ChatbotMark implements Topic {

	private String[] keywords;
	private String[] boroughs;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String currentTopic;
	
	public ChatbotMark() {
		String[] temp = {"lower east side","upper east side","chinatown","downtown","flatbush","little italy","east village","park slope","west village","bedford","jamaica","coney island","soho","harlem"};
		keywords = temp;
		String[] boroughTemp = {"brooklyn","manhatton","queens","bronx","staten island"};
		boroughs = boroughTemp;
		goodbyeKeyword = "bye";
		secretKeyword = "New Amsterdam";
		response = "";
		currentTopic = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! We in Brooklyn, NYC and I know all the best spots all over the city. You want duh best pizza spot, pssh, fuhgettaboutit. What neighborhood are you in right now?");
		while(ChatbotMain.chatbot.getLocation().equals("Unknown")) {
			response = ChatbotMain.getInput();
			response = response.toLowerCase();
			for(int i = 0; i < keywords.length; i++) {
				if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
					ChatbotMain.chatbot.setLocation(keywords[i]);
				}
			}
			for(int i = 0; i < boroughs.length; i++) {
				if(ChatbotMain.findKeyword(response, boroughs[i], 0) >= 0) {
					ChatbotMain.print("Please tell me which neighborhood your in. "+boroughs[i]+" is pretty big!");
					response = ChatbotMain.getInput();
					i = boroughs.length;
				}
			}
			ChatbotMain.print("It's funny how I don't know where that is. Please name another more popular neighborhood near where you are.");
		}
		
		ChatbotMain.print("What do you want to do in "+ChatbotMain.chatbot.getLocation()+"?");
		response = ChatbotMain.getInput();
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0 ) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0 ) >= 0) {
				ChatbotMain.print("Yes! New York was origanilly discovered by the Dutch! The origanal names that the Dutch created are still the ones we use today, such as, Brooklyn, and Manhattan");
				response = ChatbotMain.getInput();
			}else {
				for(int i = 0; i < keywords.length; i++) {
					if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
						currentTopic = keywords[i];
					}else {
						/*
						 * 
						 *I know the below section doesn't work. We need to be able to isTriggered each 
						 * other so we can switch topic.
						 * 
						 */
						if(theo.isTriggered(response)){
							Chatbot.chatting = false;
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
