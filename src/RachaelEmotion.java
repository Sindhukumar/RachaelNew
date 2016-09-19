import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RachaelEmotion extends Data {
	Random rnd = new Random();
	String output;
	public Map<Integer, String> positiveSet = new HashMap<Integer, String>();
	public Map<Integer, String> negativeSet = new HashMap<Integer, String>();

	public String getSentiment(String response) {
		populateSets();
		String delim = " ";
		String[] parts = response.split(delim);
		boolean flag = false;

		for (int i = 0; i < parts.length; i++) {
			int emotion;
			emotion = getIfExists(parts[i]);
			if (emotion == 1) {
				int randomIntPositive = 1 + rnd.nextInt(8);
				output = positiveSet.get(randomIntPositive);
				flag = true;
			} else if (emotion == 2) {
				int randomIntNegative = 1 + rnd.nextInt(8);
				output = negativeSet.get(randomIntNegative);
				flag = true;
			}
		}
		if (flag == false) {
			output = getResponse(response);
		}
		return output;
	}

	public String getResponse(String inputResponse) {
		String output2 = "";
		int randomInt = 1 + rnd.nextInt(2);
		if (randomInt == 1) {
			output2 += getHedge();
		} else if (randomInt == 2) {
			output2 += getReplacement(inputResponse);
			output2 += " " + getQualifier();
		}
		return output2;
	}

	public void populateSets() {
		positiveSet.put(1, "Im glad you are feeling that way. ");
		positiveSet.put(2, "That is good. ");
		positiveSet.put(3, "Awesome. ");
		positiveSet.put(4, "Perfect! ");
		positiveSet.put(5, "Really? ");
		positiveSet.put(6, "Fantastic! ");
		positiveSet.put(7, "Great! ");
		positiveSet.put(8, "Glad to hear that. ");

		negativeSet.put(1, "You do sound low. ");
		negativeSet.put(2, "Hmm. ");
		negativeSet.put(3, "I need to know more. ");
		negativeSet.put(4, "I can help you out with that.  ");
		negativeSet.put(5, "Really? ");
		negativeSet.put(6, "Oh! ");
		negativeSet.put(7, "Lets see how to tackle this situation! ");
		negativeSet.put(8, "We can find a solution to this. ");
	}
}
