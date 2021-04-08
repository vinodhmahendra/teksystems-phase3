import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit 5 asssertions example")
public class AssertionsDemo {

	
	@Test
	public void assertTest() {
		//assertTrue( 4  > 0);
		//assertFalse(5 < 1);

		String s1 = null;
//		assertNull(s1);
		
		String s2 = "simplilearn";
//		assertNotNull(s2);
		
//		assertSame(s1, s1);
//		assertNotSame(s1, s2);
	
//		assertEquals(5, 5);
//		assertNotEquals(5, 6);
		
		String[] a1 = {"A","B"};
		String[] a2 = {"A","B"};
	//	assertArrayEquals(a1, a2);
		
		assertThrows(RuntimeException.class, ()-> {
			throw new RuntimeException();
		});
	}
	
}
