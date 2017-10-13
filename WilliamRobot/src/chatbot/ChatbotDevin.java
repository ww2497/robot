package chatbot;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class ChatbotDevin implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String[] facts;
	private String date1;
	private String date2;
	private String[] angry;
	private boolean stop;
	private int counter;
	
	
	//
	
	public ChatbotDevin() {
		String[] temp = {"dates","events"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "time";
		String[] knowledge = {"general","area","recommend"};
		
		facts = knowledge;
		date1 = "10/15/17";
		date2 = "10/21/17";
		
		String[] mad = {"Is that so? Sorry, but you should probably say something else.", "Hey, you're getting on my nerves, can you stop?", "STOP, PLEASE.", "*sigh*"};
		angry = mad;
		stop = false;
		counter = 0;
		
	}

	public String getDates() 
	{
		Date date = new Date();
		return date.toString();
	}
	public String getCal(int x)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 9, 11);//0 for Jan, 1 for Feb, etc...
		//cal.add(Calendar.MONTH, 2); // You can -/+ x months here to go back in history or move forward.
		SimpleDateFormat dt = new SimpleDateFormat("dd"); 
		long onedayago = cal.getTime().getTime() + x * 24 * 60 * 60 * 1000 - cal.getTime().getTime();
		cal.setTime(new Date(onedayago));
		//System.out.println(dt.format(cal.getTime()));
		return dt.format(cal.getTime()); // New date
		
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print("Events? What kind of events do you want to know?");
		response = ChatbotMain.getInput();
	
		for (int i = 0; i < facts.length; i++) {
		if(ChatbotMain.findKeyword(response,facts[i] , 0)>=0) {
	
			ChatbotMain.print("Some events that are happening around this area is: L.E.S Pickle Day at "+date1+" and Giant Pumpkin Weekend at "+date2+". "
					+ "L.E.S Pickle Day is "+getCal(5)+" days away from today while Giant Pumpkin Weekend is "+getCal(11)+" days away.");//hard-coded
			
			response = ChatbotMain.getInput();
			
	}
			
			
			
				

		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) 
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Here's the date and time for today: "+getDates()+" ");
				response = ChatbotMain.getInput();
			}

				else {
					if(!stop && counter < 4) {
					ChatbotMain.print(angry[counter]);
					response = ChatbotMain.getInput();
					
					}
				if (counter > 2) {
					ChatbotMain.print("alright im done with you, " +ChatbotMain.chatbot.getUsername()+". Bye.");
					ChatbotMain.chatbot.startChatting();
				}
				else {
					counter ++;
					
				}

				}

		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
				}
		}
		

		
		

		

		
			
			
		
	
	
	
	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
		{
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i],0) >= 0) {
				return true;
			}
			
		}
		return false;
		//
	}
}
