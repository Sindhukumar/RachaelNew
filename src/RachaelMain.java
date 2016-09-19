
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RachaelMain {
	
	public static void main(String arg[]) throws FileNotFoundException {
		RachaelEmotion re = new RachaelEmotion();
		re.populateSets();
		Rachael rl = new Rachael();
		System.out.println("Hi Good Morning, How are you Doing . "
				+ "Please enter your response or press Quit to exit");
		rl.Start();

	}
}
