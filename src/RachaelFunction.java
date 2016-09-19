import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class RachaelFunction extends Data

{
	protected HashMap<Integer, String> qualMap = new HashMap<Integer, String>();

	protected static ArrayList<String> logList = new ArrayList<String>();
	protected static ArrayList<String> posList = new ArrayList<String>();
	protected static ArrayList<String> negList = new ArrayList<String>();

	public void addQual() {
		qualMap.put(1, "Wait..before you \"quit\". We should proably talk more about what you said that  ");
		qualMap.put(2, "Don't \"quit\" now. You are making a lot of progress . Remember awhile ago you said ");
		qualMap.put(3, "Are you sure about this ...If you leave now and \"quit\" we wouldn't be able to talk about ");
	}
	
	public ArrayList<String> getLogList() {
		return logList;
	}

	public void setLogList(ArrayList<String> logList) {
		this.logList = logList;
	}

	//
	public int addlog(String resp) {
		logList.add(resp);
		if (value(resp)>=0) posList.add(resp);
		System.out.println("Pos---" + posList);
		if (value(resp)<0) negList.add(resp);
		int size = logList.size();
		return size;
	}

	public void logFile() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("History.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}


		while (logList != null) {
			writer.println(" Session Date:  " + Calendar.getInstance().getTime()+ "\n"+logList);

		}

	}
	
	public int value(String s) {
		String delim = " ";
		String[] parts = s.split(delim);

		int score = 0;

		for (int j = 0; j < parts.length; j++) {
			if (getIfExists(parts[j]) == 1) {
				score = score + 4;
			} else if (getIfExists(parts[j]) == 1)
				score = score - 4;

		}
		if (score < 0) {
			score = score - parts.length;
		} else if (score >= 0) {
			score = score + parts.length;
		}
		return score;
	}

	public double cost() {

		double itemList = logList.size();
		double cost = itemList * 2;
		return cost;
	}

}