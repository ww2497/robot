package chatbot;

public class Chatbot {
	
	private String username;
	private boolean chatting;
	private Topic william;

	public Chatbot() {
		william = new ChatbotWilliam();
		username = "Unknown User";
		chatting = true;
	}
		
	public String getUsername() {
		return username;
	}
	
	public void startChatting() {
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your inputs. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(william.isTriggered(response)) {
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				william.talk(response);
				
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}


}
