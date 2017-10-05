package chatbot;

import java.util.Date;

public class ChatbotDevin implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String facts;
	private String setDestination;
	
	
	
	public ChatbotDevin() {
		String[] temp = {"sightseeing","sightsee","museums","empire state building","statue of liberty"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "date";
		facts = "facts";
	}
	public String getDestinations() {
		return setDestination;
	}
	public String getDates() 
	{
		Date date = new Date();
		return date.toString();
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print(" ");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Oh, you want to go to the statue of liberty?");
				//if yes
				ChatbotMain.print("Type in 'facts' if you want to know more about the Statue of Liberty. Type in 'directions' if you need directions to the Statue of Liberty.");
				response = ChatbotMain.getInput();
				ChatbotMain.chatbot.checkTriggered(response);
				
				ChatbotMain.chatbot.setDestination("statue of liberty");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print(" ");
				response = ChatbotMain.getInput();
				
			}else {
				ChatbotMain.print("Yeah. That's pretty cool. However, there are things I like even more. Tell me something else.");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}
	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
		{
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i],0) >= 0) {
				return true;
			}
			return false;
		}
		return false;
	}
}
