import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class History extends RachaelFunction {

	private Map<Integer, String> histMap1 = new HashMap<Integer, String>();
	private Map<Integer, String> histMap2 = new HashMap<Integer, String>();
	private Map<Integer, String> histMap3 = new HashMap<Integer, String>();

	public boolean isvague(String s) {
		String delim = " ";
		String[] parts = s.split(delim);
		boolean vague;
		int score = 0;

		for (int j = 0; j < parts.length; j++) {
			if (getIfExists(parts[j]) != -1) {
				score = score + 4;
			} else
				score = score + 1;

		}
		if (score >= 8)
			vague = false;
		else
			vague = true;
		return vague;
	}

	ArrayList<String> loglist = new ArrayList<String>();

	public void setHistMap1() {
		histMap1.put(0, "You said that, ");
		histMap1.put(1, "Do you remeber saying ");
		histMap1.put(2, "You did say that ");
		histMap1.put(3, "Interesting, and you did say");
		histMap1.put(4, "I understand, especially becuase you said, ");
		histMap1.put(5, "Exactly and you even said");

	}

	public String getHistMap1() {
		Random rnd = new Random();
		int i = rnd.nextInt(6);
		return histMap1.get(i);
	}

	public void setHistMap2() {
		histMap2.put(0, "However you said that, ");
		histMap2.put(1, "Do you remeber saying ");
		histMap2.put(2, "But you did say that ");
		histMap2.put(3, "Interesting, but you said ");
		histMap2.put(4, "I understand, but were you confused when you said ");
		histMap2.put(5, "Maybe you felt different when you said ");

	}

	public String getHistMap2() {
		Random rnd = new Random();
		int i = rnd.nextInt(6);
		return histMap2.get(i);
	}

	public void setHistMap3() {
		histMap3.put(0, ". So what were you thinking then ?");
		histMap3.put(1, ". Why did you say it ?");
		histMap3.put(2, ". What were you thinking when you said that ?");
		histMap3.put(3, ". Did you what to elaborate more ?");
		histMap3.put(4, ". Let us talk more about it.");
		histMap3.put(5, ". What was the reason for that statement ?");

	}

	public String getHistMap3() {
		Random rnd = new Random();
		int i = rnd.nextInt(6);
		return histMap3.get(i);
	}

	public String getPos() {
		Random rnd = new Random();
		int r = rnd.nextInt(posList.size()>0?posList.size():1);
		System.out.println(r + "--getPos");
		return posList.get(r);

	}
	public String getNeg() {
		Random rnd = new Random();
		int r = rnd.nextInt(negList.size());
		return negList.get(r);

	}

	

	public String HistQuestion(String s) {
		String res=null;
		int score = value(s);
		Random rnd = new Random();

		int o = rnd.nextInt(2);
		if (o == 0) {
			if (score > 0)
				res = getHistMap1() + getPos() + getHistMap3();
			if (score <0 )
				res = getHistMap1() + getNeg() + getHistMap3();
			
		}

		else {
			if (score > 0)
				res = getHistMap2() + getPos() + getHistMap3();
			if (score <0 )
				res = getHistMap2() + getNeg() + getHistMap3();
		}
		return res;
	}

	

}