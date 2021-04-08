import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("junit 5 standard test class example")
public class StandardTest {
	
	@BeforeAll
	static void initAll() {
		System.out.println("before all the test methods.");
	}
	
	@BeforeEach
	void init() {
		System.out.println("before each test method -- >");
	}
	
	@Test
	void succeedingTest() {
		System.out.println("succeeding test");
	}
	
	@Test
	void failingTest() {
		System.out.println("Failing Test");
		fail("always test fails");
	}
	
	@Test
	@Disabled("For Demonstration Purposes")
	void skippedTest() {
		
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After Each method is invoked");
	}
	
	@AfterAll
	static void tearDownAll() {
		System.out.println("After All method is invoked");
	}

}
