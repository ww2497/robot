package chatbot;

import java.util.Date;

public class ChatbotDevin implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String agreements;
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
	}
	
	
	public ChatbotDevin() {
		String[] temp = {"stuff","things","whatever","nothing"};
		agreements = "yes";
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pubg";
		response = "";
	}
	public String getDates() 
	{
		//return getDates;
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print("Dates? I know a lot about dates.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, agreements, 0) >= 0) {
				ChatbotMain.print("Indeed. After all, today's the ");
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
