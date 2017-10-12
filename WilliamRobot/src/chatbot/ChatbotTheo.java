package chatbot;

public class ChatbotTheo implements Topic {
	private String [] keywords;
	private String goodbyeKeyword;
	private String[] yes;
	private String lesRec;
	private String uesRec;
	private String cRec;
	private String liRec;
	private String fRec;
	private String evRec;
	private String psRec;
	private String wvRec;	
	private String bedRec;
	private String jRec;
	private String ciRec;
	private String shRec;
	private String hRec;
	private boolean rec;
	
	public ChatbotTheo() {
		String[] temp = {"food","eat","hungry","restaurants"};
		keywords = temp;
		goodbyeKeyword = "bye";
		String[] asdf = {"yea","yes","ok","sure","ye","y","yeah","okay","k"};
		yes = asdf;
		lesRec = "Balvanera";
		uesRec = "Up Thai";
		cRec = "Joe's Shanghai's";
		liRec = "Benito One";
		fRec="MangoSeed";
		evRec="Pylos";
		psRec="Palo Santo";
		wvRec="The Spotted Pig";
		bedRec="Ako";
		jRec="Golden Krust";
		ciRec="Nathans";
		shRec="AquaGril";
		hRec="Red Rooster";
		rec=false;
	}
//
	@Override
	public void talk(String response) {
		rec=false;
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0)==-1) {
			while(rec==false) {
				ChatbotMain.print("Would you like me to recomend somewhere to eat?");
				response = ChatbotMain.getInput();
				for(int i=0;i<yes.length;i++) {
					if(ChatbotMain.findKeyword(response,yes[i] , 0)>=0) {
						if(ChatbotMain.chatbot.getLocation().equals("unknown")) {
							ChatbotMain.print("I'll need to know where you are first. Please tell me what neighborhood you're currently in.");
							response = ChatbotMain.getInput();
							while (ChatbotMain.chatbot.getLocation() == "unknown") {
								if(response.equals("lower east side") || response.equals("upper east side") || response.equals("chinatown") || response.equals("flatbush") || response.equals("little italy") || response.equals("east village") || response.equals("park slope") || response.equals("west village") || response.equals("bedford") || response.equals("jamaica") || response.equals("coney island") || response.equals("soho") || response.equals("harlem"))
								{
									ChatbotMain.chatbot.setLocation(response);
								}
								else
								{
									ChatbotMain.print("Sorry, that's not a valid neighborhood.");
									response = ChatbotMain.getInput();
								}
							}
						}
						if(ChatbotMain.chatbot.getLocation().equals("lower east side")) {
							ChatbotMain.print("You should go to "+lesRec+".");
							ChatbotMain.chatbot.setDestination(lesRec);
							ChatbotMain.chatbot.setTrain("F");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("upper east side")) {
							ChatbotMain.print("You should go to "+uesRec+".");
							ChatbotMain.chatbot.setDestination(uesRec);
							ChatbotMain.chatbot.setTrain("Q");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("chinatown")) {
							ChatbotMain.print("You should go to "+cRec+".");
							ChatbotMain.chatbot.setDestination(cRec);
							ChatbotMain.chatbot.setTrain("R");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("flatbush")) {
							ChatbotMain.print("You should go to "+fRec+".");
							ChatbotMain.chatbot.setDestination(fRec);
							ChatbotMain.chatbot.setTrain("2");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("little italy")) {
							ChatbotMain.print("You should go to "+liRec+".");
							ChatbotMain.chatbot.setDestination(liRec);
							ChatbotMain.chatbot.setTrain("R");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("east village")) {
							ChatbotMain.print("You should go to "+evRec+".");
							ChatbotMain.chatbot.setDestination(evRec);
							ChatbotMain.chatbot.setTrain("F");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("park slope")) {
							ChatbotMain.print("You should go to "+psRec+".");
							ChatbotMain.chatbot.setDestination(psRec);
							ChatbotMain.chatbot.setTrain("R");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("west village")) {
							ChatbotMain.print("You should go to "+wvRec+".");
							ChatbotMain.chatbot.setDestination(wvRec);
							ChatbotMain.chatbot.setTrain("1");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("bedford")) {
							ChatbotMain.print("You should go to "+bedRec+".");
							ChatbotMain.chatbot.setDestination(bedRec);
							ChatbotMain.chatbot.setTrain("L");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("jamaica")) {
							ChatbotMain.print("You should go to "+jRec+".");
							ChatbotMain.chatbot.setDestination(jRec);
							ChatbotMain.chatbot.setTrain("L");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("coney island")) {
							ChatbotMain.print("You should go to "+ciRec+".");
							ChatbotMain.chatbot.setDestination(ciRec);
							ChatbotMain.chatbot.setTrain("Q");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("soho")) {
							ChatbotMain.print("You should go to "+shRec+".");
							ChatbotMain.chatbot.setDestination(shRec);
							ChatbotMain.chatbot.setTrain("R");
							rec = true;
						}
						else if(ChatbotMain.chatbot.getLocation().equals("harlem")) {
							ChatbotMain.print("You should go to "+hRec+".");
							ChatbotMain.chatbot.setDestination(hRec);
							ChatbotMain.chatbot.setTrain("A");
							rec = true;
						}
					}
				}
				if (rec == false) {
					ChatbotMain.print("Okay, I will not recomend somewhere for you to eat.");
					rec = true;
					ChatbotMain.chatbot.startChatting();
				}
				else
				{
					ChatbotMain.print("Do you need directions?");
				}
			}
			
			response = ChatbotMain.getInput();
			for(int i=0;i<yes.length;i++) {
				if(ChatbotMain.findKeyword(response,yes[i] , 0)>=0) {
					ChatbotMain.chatbot.startWilliam(response);
				}
			}
			ChatbotMain.print("Alright, please say 'bye' to be redirected to the main tour guide.");
		}
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+".");
		ChatbotMain.chatbot.startChatting();
	}
	public boolean isTriggered(String response) {
		for (int i=0;i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i],0)>=0) {
			return true;	
			}
		}
		return false;
	}
}
