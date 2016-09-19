import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class DataTest {

	@Test
	public void test() {
		Data data = new Data();
		assertTrue(data.getIfExists("a+")==1);
		assertTrue(data.getIfExists("abnormal")==2);
		assertTrue(data.getIfExists("abnormall")==-1);
	}

}
