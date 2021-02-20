import java.net.URL;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args)
	{ 
		URLReader hearthstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		//System.out.println(hearthstoneURLReader.getTheURLContents());
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		HearthstoneCard[] theMinions = new HearthstoneCard[1924];
		theMinions[0] = new HearthstoneCard (name, cost, attack, defense);
	    		
	    //System.out.println(obj instanceof JSONArray);
	    if(obj instanceof JSONArray)
	    {
	    	//I am only in here if obj IS a JSONArray
	    	JSONArray array = (JSONArray)obj;
	    	int count = 0;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			
		    			String[] name = (String[])cardData.get("name");
		    			int[] cost = (int[])cardData.get("cost");
		    			int[] attack = (int[])cardData.get("attack");
		    			int[] defense = (int[])cardData.get("health");
		    			
		    			
		    			/*
		    			System.out.println(cardData.get("name"));
			    		System.out.println(cardData.get("cost"));
			    		System.out.println(cardData.get("attack"));
			    		System.out.println(cardData.get("health"));
			    		count++;
			    		*/
		    		}
		    		
		    	}
		    	
		    }
		    //System.out.println(count);
	    }
	}
}
