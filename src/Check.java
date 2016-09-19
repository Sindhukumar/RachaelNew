import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Check {
	HashMap<String, Integer> mostMiss = new HashMap<String, Integer>();
	ArrayList<String> dict = new ArrayList<String>();

	Check() {
		try {
			File file = new File("/usr/share/dict/words");
			Scanner fileSc = new Scanner(file);
			while (fileSc.hasNext()) {
				dict.add(fileSc.nextLine());
			}
			fileSc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void displayDict(){
		for(String d:dict)
		System.out.println(d);
	}
	
	public void displayMostMiss(){
		System.out.println(mostMiss);
	}

	public boolean checking(String phrase) throws FileNotFoundException {

		boolean isMatch = false, hasError = false;
		String arr[] = phrase.split(" ");
		for (String s : arr) {
			for (String d:dict) {
				if (s.equalsIgnoreCase(d)){
					isMatch = true;
					break;
				}
			}
			if (!isMatch) {
				System.out.println(s + " is not a word");
				hasError = true;
				mostMiss.put(s, mostMiss.get(s)==null?1:mostMiss.get(s)+1);
			}
		}
		return hasError;
	}

}