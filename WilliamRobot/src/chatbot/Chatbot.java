package chatbot;

public class Chatbot {
	
	private String username;
	private boolean chatting;
	private Topic william;
	private Topic mark;
	private Topic theo;
	private Topic devin;
	private String location;
	private String month;
	

	public Chatbot() {
		william = new ChatbotWilliam();
		mark = new ChatbotMark();
		theo = new ChatbotTheo();
		devin = new ChatbotDevin();
		location = "Unknown";
		username = "Unknown User";
		chatting = true;
	}
		
	public String getUsername() {
		return username;
	}
	public String getLocation() {
		return location;
	}
	
	public void startChatting() {
		ChatbotMain.print("Hi! I am your New York City Tour Bot, please tell me your name?");
		username = ChatbotMain.getInput();
		ChatbotMain.print("What borough are you in right now?");
		location = ChatbotMain.getInput();
		
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(william.isTriggered(response)) {
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				william.talk(response);
			}else if(mark.isTriggered(response)){
				chatting = false;
				mark.talk(response);
			}else if(theo.isTriggered(response)) {
				chatting = false;
				theo.talk(response);
			}else if(devin.isTriggered(response)) {
				chatting = false;
				devin.talk(response);
			}else {
				ChatbotMain.print("I don't know anything about that. What else do you want to talk about?");
			}
		}
	}


}
