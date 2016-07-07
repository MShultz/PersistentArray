import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class PersistentArrayTest {

	@Test
	public void test() {
		File testFile = new File("src/testDoc.bin");
		try {
			assertTrue(testFile.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		PersistentArray.initialize("src/testDoc.bin", 20, -1);
		PersistentArray pa = new PersistentArray("src/testDoc.bin");
		for (int i = 0; i < 20; ++i) {
			assertTrue(pa.get(i) == -1);
		}
		pa.set(3, 333);
		assertTrue(pa.get(3) == 333);
		pa.set(3, -4);
		assertTrue(pa.get(3) == -4);
		assertTrue(pa.get(19) == -1);	
	    assertTrue(pa.getLength() == 20);
	    pa.close();
	    PersistentArray.delete("src/testDoc.bin");
	    assertFalse(testFile.exists());
		
	}

}
