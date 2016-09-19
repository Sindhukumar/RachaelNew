import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Data {
	public Set<String> hedgeSet = new HashSet<String>();

	private Set<String> salutationSet = new HashSet<String>();

	private Set<String> qualifierSet = new HashSet<String>();

	private Map<String, String> replacementMap = new HashMap<String, String>();

	private Map<String, Integer> keyword = new HashMap<String, Integer>();

	public int addKeyword(String key, int value) {
		return keyword.put(key, value);
	}

	public Data() {
		salutationSet.add("Hi");
		salutationSet.add("Hello");
		salutationSet.add("Greetings");
		hedgeSet.add("Interesting, Please tell me more ");
		hedgeSet.add("Many of my patients tell me the same thing ");
		hedgeSet.add("Please go on");
		hedgeSet.add("That is very common these days I must say. ");
		hedgeSet.add("When did this start? ");
		hedgeSet.add("Hmm...Go on ");
		hedgeSet.add("Really? ");
		hedgeSet.add("I see whats going on here. Give me more details. ");
		hedgeSet.add("How often do you feel this way? ");
		qualifierSet.add(" Why do you say that ");
		qualifierSet.add(" You seem to think that");
		qualifierSet.add(" So, you are concerned that");
		replacementMap.put("i", "you");
		replacementMap.put("me", "you");
		replacementMap.put("my", "your");
		replacementMap.put("am", "are");
		replacementMap.put("mine", "yours");
		replacementMap.put("we", "you");
		replacementMap.put("us","you");
		replacementMap.put("our", "your");
		replacementMap.put("ours", "yours");

		// get the positive words from file
		try {
			File file = new File("/home/oracle/workspace/java/RachaelNew/positive-words.txt");
			Scanner fileSc = new Scanner(file);
			while (fileSc.hasNext()) {
				keyword.put(fileSc.nextLine(), 1);
			}
			fileSc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// get the negative words from file
		try {
			File file = new File("/home/oracle/workspace/java/RachaelNew/negative-words.txt");
			Scanner fileSc = new Scanner(file);
			while (fileSc.hasNext()) {
				keyword.put(fileSc.nextLine(), 2);
			}
			fileSc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// -1 - Not exist, 1 - positive, 2 - negative
	public int getIfExists(String word) {
		for (String key : keyword.keySet()) {
			if (key.equalsIgnoreCase(word)) {
				return keyword.get(key);
			}
		}
		return -1;
	}

	public Set<String> getHedgeSet() {
		return hedgeSet;
	}

	public void setHedgeSet(Set<String> hedgeSet) {
		this.hedgeSet = hedgeSet;
	}

	public Set<String> getSalutationSet() {
		return salutationSet;
	}

	public void setSalutationSet(Set<String> salutationSet) {
		this.salutationSet = salutationSet;
	}

	public Set<String> getQualifierSet() {
		return qualifierSet;
	}

	public void setQualifierSet(Set<String> qualifierSet) {
		this.qualifierSet = qualifierSet;
	}

	public Map<String, String> getReplacementMap() {
		return replacementMap;
	}

	public void setReplacementMap(Map<String, String> replacementMap) {
		this.replacementMap = replacementMap;
	}

	public String randomSet(Set<String> set) {
		int index = new Random().nextInt(set.size());
		Iterator<String> iter = set.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter.next();
	}

	public String getReplacement(String response) {
		String arr[] = response.split(" ");
		String ans = "";
		for (int i = 0; i < arr.length; i++) {
			for (String k : replacementMap.keySet()) {
				if (arr[i].equalsIgnoreCase(k)) {
					arr[i] = replacementMap.get(k);
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			ans = ans + " " + arr[i];
		}
		return ans;
	}
	
	public String getQualifier(){
		return randomSet(qualifierSet);
	}
	
	public String getHedge(){
		return randomSet(hedgeSet);
	}
	
	public String getSalutation(){
		return randomSet(salutationSet);
	}
}