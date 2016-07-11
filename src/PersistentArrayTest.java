import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class PersistentArrayTest {

	@Test
	public void test() {
		final int ARRAY_SIZE = 20;
		File testFile = new File("src/testDoc.bin");
		try {
			assertTrue(testFile.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		PersistentArray.initialize("src/testDoc.bin", ARRAY_SIZE, -1);
		PersistentArray pa = new PersistentArray("src/testDoc.bin");
		assertEquals(ARRAY_SIZE, pa.getLength());
		for (int i = 0; i < pa.getLength(); ++i) {
			assertTrue(pa.get(i) == -1);
		}
		pa.set(3, 333);
		assertTrue(pa.get(3) == 333);
		assertEquals(-1 ,pa.get(2));
		assertEquals(-1, pa.get(4));
		pa.set(3, -4);
		assertTrue(pa.get(3) == -4);
		assertTrue(pa.get(19) == -1);	
	    assertTrue(pa.getLength() == 20);
	    pa.close();
	    PersistentArray.delete("src/testDoc.bin");
	    assertFalse(testFile.exists());		
	}

}
