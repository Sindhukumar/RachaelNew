import java.util.Random;

public class RachaelEmotion extends Data{
	Random rnd = new Random();
	String output = "";
	public String getSentiment(String response){
		String delim = " ";
		String[] parts = response.split(delim);
		
		for (int i = 0; i < parts.length; i++) {
			int emotion;
			emotion = getIfExists(parts[i]);
			if(emotion == 1){
				output += "Im glad you are feeling that way. ";
				break;
			}
			if(emotion == 2){
				output += "There is certainly a solution to this. ";
				break;
			}
			//output = "How do you feel about " + parts[i] + "? GOOD, BAD or OK";			
			//replacementMap.put();
		}
		return getResponse(response);
	}
	public String getResponse(String response){
		int randomInt = 1 + rnd.nextInt(2);
		if (randomInt == 1) {
			output += getHedge();
		} 
		else if (randomInt == 2) {
			output += getReplacement(response);
			output += getQualifier();
		}
		return output;
	}
}
