package chatbot;

public class Chatbot {
	
	private String username;
	private boolean chatting;
	private Topic william;
	private Topic mark;
	private Topic theo;
	private Topic devin;
	private String borough;
	private String location;
	private String date;
	private String train;
	private String destination;

	public Chatbot() {
		william = new ChatbotWilliam();
		mark = new ChatbotMark();
		theo = new ChatbotTheo();
		devin = new ChatbotDevin();
		location = "unknown";
		username = "unknown";
		date = "unknown";
		destination = "unknown";
		train ="unknown";
		borough = "unknown";
		chatting = true;
	}
	
	public boolean checkTriggered(String response) {
		if(mark.isTriggered(response)) {
			mark.talk(response);
			return true;
		}else if(theo.isTriggered(response)){
			theo.talk(response);
			return true;
		}else if(william.isTriggered(response)) {
			william.talk(response);
			return true;
		}else if(devin.isTriggered(response)) {
			devin.talk(response);
			return true;
		}
		return false;
	}
	
	public boolean getChatting() {
		return chatting;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		username = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String currentLocation) {
		location = currentLocation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String currentDate) {
		date = currentDate;
	}
	public String getTrain() {
		return train;
	}
	public void setTrain(String currentTrain) {
		train = currentTrain;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String currentDestination) {
		destination = currentDestination;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String currentBorough) {
		borough = currentBorough;
	}
	public void startChatting() {
		chatting = true;
		if(username == "unknown") {
			ChatbotMain.print("Hi! I am your New York City Tour Bot. What is your name?");
			username = ChatbotMain.getInput();
		}
		ChatbotMain.print("Okay, "+ChatbotMain.chatbot.getUsername()+". I know a lot about New York City. You could learn about neighborhoods in the city, whats good to eat, how to get somewhere or what events are going on in those neighborhoods. What do you want to do?");
		while(chatting) {
			String response = ChatbotMain.getInput();
			//This if else is to prevent copying the bot, otherwise the user is stuck in the loop
			if(response.equals("Nice to meet you "+ChatbotMain.chatbot.getUsername()+". I know a lot about New York City. You could learn about neighborhoods in the city, whats good to eat, how to get somewhere or what events are going on in those neighborhoods. What do you want to do?")) {
				ChatbotMain.print("Please don't copy me! We can have a conversation instead!");
				response = ChatbotMain.getInput();
			}
			while(response.equals("Please don't copy me! We can have a conversation instead!")){
				ChatbotMain.print("Please don't copy me! We can have a conversation instead!");
				response = ChatbotMain.getInput();
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
				ChatbotMain.print("I don't know. Make sure you spell a name correctly. ");
			}
		}
	}
	public void startMark(String s) {
		mark.talk(s);
	}

}