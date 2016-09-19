import static org.junit.Assert.*;

import org.junit.Test;

public class SentimentTest {

	@Test
	   public void test_sentiment() {
		  boolean check = false;
		  RachaelEmotion re = new RachaelEmotion();
	      String response = re.getSentiment("sad");
	      if(response.contains("Im glad you are feeling that way. ")){
	    	  check = true;
	      }
	      assertTrue(check == true) ;
	   }
}