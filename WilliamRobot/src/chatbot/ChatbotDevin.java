package chatbot;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class ChatbotDevin implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String facts;
	
	
	//
	
	public ChatbotDevin() {
		String[] temp = {"dates","events"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "time";
		facts = "facts";
	}

	public String getDates() 
	{
		Date date = new Date();
		return date.toString();
	}
	public String getCal()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 9, 16);//0 for Jan, 1 for Feb, etc...
		cal.add(Calendar.MONTH, 2); // You can -/+ x months here to go back in history or move forward.
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy"); 
		long onedayago = cal.getTime().getTime() - 24 * 60 * 60 * 1000;
		cal.setTime(new Date(onedayago));
		//System.out.println(dt.format(cal.getTime()));
		return dt.format(cal.getTime()); // New date
	}
	@Override
	public void talk(String response) {
		ChatbotMain.print("Events? What events do you want to know?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Here's the date: "+getDates()+" ");
				response = ChatbotMain.getInput();
				
			}else {
				ChatbotMain.print(""+getCal()+"");
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
			
		}
		return false;
		//
	}
}
