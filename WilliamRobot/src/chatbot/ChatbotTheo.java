package chatbot;

public class ChatbotTheo implements Topic {
private String [] keywords;
private String goodbyeKeyword;
private String secretKeyword;
private String [] responses;
private String[] yes;
private int g;
private String lesRec;
private String uesRec;
private String qRec;
private String cRec;
private String liRec;
private String dtRec;
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
		secretKeyword = "";
		String[] asdf = {"yea","yes","ok","sure"};
		yes = asdf;
		g=0;
		lesRec = "Balvanera";
		uesRec = "Up Thai";
		cRec = "Joe's Shanghai's";
		liRec = "Benito One";
		dtRec="Shake shack";
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
		if(rec==false) {
		ChatbotMain.print("Would you like me to recomend somewhere to eat");
		response= ChatbotMain.getInput();
		for(int i=0;i<yes.length;i++) {
			if(ChatbotMain.findKeyword(response,yes[i] , 0)>=0) {
				if(ChatbotMain.chatbot.getLocation().equals("lower east side")) {
					ChatbotMain.print("You should go to "+lesRec+".");
					ChatbotMain.chatbot.setDestination(lesRec);
					ChatbotMain.chatbot.setTrain("F");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("little italy")) {
					ChatbotMain.print("You should go to "+liRec+".");
					ChatbotMain.chatbot.setDestination(liRec);
					ChatbotMain.chatbot.setTrain("R");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("queens")) {
					ChatbotMain.print("You should go to "+qRec+".");
					ChatbotMain.chatbot.setDestination(qRec);
					ChatbotMain.chatbot.setTrain("W");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("chinatown")) {
					ChatbotMain.print("You should go to "+cRec+".");
					ChatbotMain.chatbot.setDestination(cRec);
					ChatbotMain.chatbot.setTrain("R");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("upper east side")) {
					ChatbotMain.print("You should go to "+uesRec+".");
					ChatbotMain.chatbot.setDestination(uesRec);
					ChatbotMain.chatbot.setTrain("Q");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("downtown")) {
					ChatbotMain.print("You should go to "+dtRec+".");
					ChatbotMain.chatbot.setDestination(dtRec);
					ChatbotMain.chatbot.setTrain("2");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("flatbush")) {
					ChatbotMain.print("You should go to "+fRec+".");
					ChatbotMain.chatbot.setDestination(fRec);
					ChatbotMain.chatbot.setTrain("2");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("east village")) {
					ChatbotMain.print("You should go to "+evRec+".");
					ChatbotMain.chatbot.setDestination(evRec);
					ChatbotMain.chatbot.setTrain("F");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("park slope")) {
					ChatbotMain.print("You should go to "+psRec+".");
					ChatbotMain.chatbot.setDestination(psRec);
					ChatbotMain.chatbot.setTrain("R");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("west village")) {
					ChatbotMain.print("You should go to "+wvRec+".");
					ChatbotMain.chatbot.setDestination(wvRec);
					ChatbotMain.chatbot.setTrain("1");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("bedford")) {
					ChatbotMain.print("You should go to "+bedRec+".");
					ChatbotMain.chatbot.setDestination(bedRec);
					ChatbotMain.chatbot.setTrain("L");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("jamaica")) {
					ChatbotMain.print("You should go to "+jRec+".");
					ChatbotMain.chatbot.setDestination(jRec);
					ChatbotMain.chatbot.setTrain("L");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("coney island")) {
					ChatbotMain.print("You should go to "+ciRec+".");
					ChatbotMain.chatbot.setDestination(ciRec);
					ChatbotMain.chatbot.setTrain("Q");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("soho")) {
					ChatbotMain.print("You should go to "+shRec+".");
					ChatbotMain.chatbot.setDestination(shRec);
					ChatbotMain.chatbot.setTrain("R");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("harlem")) {
					ChatbotMain.print("You should go to "+hRec+".");
					ChatbotMain.chatbot.setDestination(hRec);
					ChatbotMain.chatbot.setTrain("A");
					rec = true;
				}
				if(ChatbotMain.chatbot.getLocation().equals("unknown"))
				ChatbotMain.print("I don't know where you are you are could you tell me what borough your in");
				response = ChatbotMain.getInput();
				ChatbotMain.chatbot.startMark(response);
				return;
				
			}//
			else {
				if(g==0) {
				ChatbotMain.print("ok I will not recomend somewhere for you to eat");
				rec = true;
				}
			}
			g++;
		}
		}
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0)==-1) {
			
			if(ChatbotMain.findKeyword(response, secretKeyword, 0)>=0) {
				ChatbotMain.print("Get dabbed on");
			}
			else {
				ChatbotMain.print("Im sorry I dont understand");
			}
		}
		ChatbotMain.print("Well, it was nice talking to you"+ChatbotMain.chatbot.getUsername()+"!");
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
