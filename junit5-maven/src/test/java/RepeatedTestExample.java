import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTestExample {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before all test method called");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each test method called");
	}
	
	@DisplayName("Add Operation Test")
	@RepeatedTest(5)
	void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println("Running addNumber test --->" +repetitionInfo.getCurrentRepetition());
		Assertions.assertEquals(2, Calculator.add(1,1)," 1 + 1 should equal 2");
	}
	
	@AfterEach
	public void cleanUpEach() {
		System.out.println("After Each cleanup() method called");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("After all test method called");
	}
}
