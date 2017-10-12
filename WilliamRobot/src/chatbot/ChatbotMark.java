package chatbot;

public class ChatbotMark implements Topic {

	private String[] keywords;
	private String[] boroughs;
	private String[] neighborhoods;
	private String[] trains;
	private String goodbyeKeyword;
	private String secretKeyword;
	
	public ChatbotMark() {
		String[] keywordTemp = {"learn","know",};
		keywords = keywordTemp;
		String[] localTemp = {"lower east side","upper east side","chinatown","flatbush","little italy","east village","park slope","west village","bedford","jamaica","coney island","soho","harlem"};
		neighborhoods = localTemp;
		String[] trainTemp = {"F"              ,"Q"              ,"R"        ,"2"       ,"R"           ,"F"           ,"R"         ,"1"           ,"L"      ,"L"      ,"Q"           ,"R"   ,"A"};
		trains = trainTemp;
		String[] boroughTemp = {"brooklyn","manhattan","queens","bronx","staten island"};
		boroughs = boroughTemp;
		goodbyeKeyword = "bye";
		secretKeyword = "New Amsterdam";
	}

	@Override
	public void talk(String response) {
		while(ChatbotMain.chatbot.getLocation().equals("unknown")) {
			while(ChatbotMain.chatbot.getBorough().equals("unknown")) {
				ChatbotMain.print("Okay, but first I should know what borough you are currently in.");
				response = ChatbotMain.getInput();
				for(int i = 0; i < boroughs.length; i++) {
					if(ChatbotMain.findKeyword(response, boroughs[i], 0) >= 0) {
						ChatbotMain.chatbot.setBorough(boroughs[i]);
						ChatbotMain.print("Thanks. Now please tell me which neighborhood you're in so I can help you later. "+boroughs[i]+" is pretty big!");
						i = boroughs.length;
					}
				}
				if(ChatbotMain.chatbot.getBorough().equals("unknown")){
					ChatbotMain.print("Please type it again correctly. Ya know, the boroughs. Like Brooklyn!");
				}
			}
			response = ChatbotMain.getInput();
			for(int i = 0; i < neighborhoods.length; i++) {
				if(ChatbotMain.findKeyword(response, neighborhoods[i], 0) >= 0) {
					ChatbotMain.print("Okay.");
					ChatbotMain.chatbot.setLocation(neighborhoods[i]);
					ChatbotMain.chatbot.setTrain(trains[i]);
					
				}
			}
			
			if(ChatbotMain.chatbot.getLocation().equals("unknown")){
				ChatbotMain.print("It's funny how I don't know where that is. Try naming a larger neighborhood near you.");
			}
		}
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0 ) == -1) {
			ChatbotMain.print("What other neighborhood would you like to know about?");
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, secretKeyword, 0 ) >= 0) {
				ChatbotMain.print("Yes! New York was originally discovered by the Dutch! The origanal names that the Dutch created are still the ones we use today, such as, Brooklyn, and Manhattan");
				response = ChatbotMain.getInput();
			}else if (ChatbotMain.chatbot.checkTriggered(response)) {
				response = "bye";
				
			}else{
				if(ChatbotMain.findKeyword(response, neighborhoods[0], 0) >= 0) {
					ChatbotMain.print("The eclectic Lower East Side is where gritty alleys and tenement-style buildings mix with upscale apartments and chic boutiques. Nighttime draws hip, young crowds to the area's trendy bars, music venues and restaurants.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[1], 0) >= 0) {
					ChatbotMain.print("The posh, residential Upper East Side is known for its wealthy denizens, fancy restaurants and designer shops along Madison Avenue. It's a pretty neighborhood, with a mix of classic brownstones and upscale high-rises. ");		
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[2], 0) >= 0) {
					ChatbotMain.print("Vibrant Chinatown is a densely populated neighborhood that draws foodies and tourists to its many Chinese and Southeast Asian restaurants for dumplings, pork buns and hand-pulled noodles. The busy sidewalks are packed with souvenir stores, bubble tea shops, and markets selling everything from fresh and dried fish to herbs and spices. ");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[3], 0) >= 0) {
					ChatbotMain.print("Flatbush is a neighborhood in the New York City borough of Brooklyn. Founded in 1651 by Dutch colonists, the neighborhood, which consists of several subsections, had a population of 110,875 as of the 2010 United States Census.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[4], 0) >= 0) {
					ChatbotMain.print("Little Italy welcomes a heavily tourist crowd to its high concentration of souvenir shops and traditional Italian eateries and bakeries. Tenement buildings, once home to the immigrants who settled the area in the late 1800s, line the narrow streets. ");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[5], 0) >= 0) {
					ChatbotMain.print("The East Village is known for its happening nightlife. Old-school bars, music venues and performance spaces share the streets with posh cocktail lounges, hip restaurants. Daytime sees a more laid-back crowd browsing boutiques, vintage shops and tattoo parlors, and dining at casual cafes.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[6], 0) >= 0) {
					ChatbotMain.print("Down-to-earth Park Slope is a residential neighborhood of tree-lined streets and historic brownstones in Brooklyn. It's known for its open-minded community of families and young professionals. The mix of indie boutiques, laid-back bars and casual restaurants along 7th Avenue caters to the diverse area.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[7], 0) >= 0) {
					ChatbotMain.print("The West Village draws fashionable crowds to its designer boutiques and trendy restaurants. Quaint streets, some still cobblestoned, are lined with Federal-style townhouses and dotted with public squares. Notable venues include the Village Vanguard jazz club and the Stonewall Inn bar, site of the 1969 riots that launched the gay rights movement.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[8], 0) >= 0) {
					ChatbotMain.print("Bedford–Stuyvesant is a neighborhood of 153,000 inhabitants in the north central portion of the New York City borough of Brooklyn. The neighborhood is part of Brooklyn Community Board 3, Brooklyn Community Board 8, and Brooklyn Community Board 16. ");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[9], 0) >= 0) {
					ChatbotMain.print("Jamaica is a middle-class neighborhood in the New York City borough of Queens. The neighborhood is part of Queens Community Board 12, which also includes Hollis, St. Albans, Springfield Gardens, Baisley Pond Park, Rochdale Village, and South Jamaica. The NYPD's 103rd, 113th & 105th Precincts patrol Jamaica.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[10], 0) >= 0) {
					ChatbotMain.print("Coney Island is a residential Brooklyn neighborhood that morphs into a relaxation and entertainment destination each summer. Locals and tourists crowd its beach, the Wonder Wheel and Luna Park, an amusement park featuring the famed Cyclone roller coaster. Street performers, the Circus Sideshow and the Mermaid Parade in June lend an eccentric vibe. Nathan's Famous is known for its July 4th hot-dog eating contest.");		
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[11], 0) >= 0) {
					ChatbotMain.print("Designer boutiques, fancy chain stores and high-end art galleries make trendy SoHo a top shopping destination, especially for out-of-towners. Known for its elegant cast-iron-facades and cobblestone streets, the neighborhood is also an atmospheric backdrop for fashionable crowds clustering at high-end restaurants and nightlife hotspots. During the day, street vendors sell everything from jewelry to original artwork.");
				}
				if(ChatbotMain.findKeyword(response, neighborhoods[12], 0) >= 0) {
					ChatbotMain.print("Long known for its intimate jazz clubs, soul food institutions and African-American heritage, Harlem draws a diverse crowd of locals and visitors. Trendy eateries, stylish clubs and hip bars make for an energetic nightlife scene. The area features a mix of 19th-century brownstones and modern high-rises. Its main artery, 125th Street, is home to the iconic Apollo Theater, as well as chain stores and restaurants.");
				}
			}
			if(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
				ChatbotMain.print("If you would like to talk about something, else say 'bye'. ");
			}
		}
		//access stuff from other class
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	}

	@Override	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT 
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
