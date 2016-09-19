import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Rachael {
	Data dt = new Data();
	History hs = new History();
	RachaelFunction rf = new RachaelFunction();
	RachaelEmotion re = new RachaelEmotion();
	Check ch= new Check();

	public void Start() throws FileNotFoundException {
		//    System.out.println("Enter your response or Quit to exit");
		Scanner scan = new Scanner(System.in);
		String response = scan.nextLine();
		Interaction(response);
	}

	public void Interaction(String response) throws FileNotFoundException {
		boolean hasError = ch.checking(response);
		while (!hasError){
			if (!response.equalsIgnoreCase("Quit")) {

				boolean isVague = hs.isvague(response);
				int Size = rf.addlog(response);
				System.out.println(Size);

				if (isVague && Size > 10) 
				{
					System.out.println(hs.HistQuestion(response));
					Start();
				} 
				else if (isVague && Size <= 10)
				{
					System.out.println(dt.getHedge());
					Start();
				}
				else 
				{
					Random rn = new Random();
					int index = 1 + rn.nextInt(2);
					if (index == 1) 
					{
						System.out.println(re.getSentiment(response));
						Start();
					} 
					else 
					{
						System.out.println(hs.HistQuestion(response));
						Start();
					}

				}

			} else if (response.equalsIgnoreCase("Quit")) {
				quit(response);

			}
		}
		if (hasError) {
			System.out.println("Sorry I did not get you , Please re-enter your response");
			Start();
		}
	}
	public void quit(String resp) throws FileNotFoundException {
		for (int i = 1; i <= 4; i++)
		{

			if (resp.equalsIgnoreCase("quit") && ((i == 1) || (i == 2) || (i == 3)))
			{
				System.out.println(rf.qualMap.get(i) + hs.HistQuestion(resp));
				Interaction(resp);
			}

			if (resp.equalsIgnoreCase("quit") && (
					i == 4))
			{

				System.out.println("Hmm.. if you really want to leave then alright.");
				System.out.println(
						"Wait!! dont leave already. You still have to pay me for this session. The cost for today's session will be  "
								+ rf.cost());
				rf.logFile();
				System.out.println("Bye! See you next time. Until then try to stay positive and be Happy :)");

			}
		}
	}

}
