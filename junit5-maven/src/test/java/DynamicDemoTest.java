import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

public class DynamicDemoTest {
	
	// static test
	@Test
	void test() {
		assertEquals(5, Calculator.add(3, 2));
	}
	
	@TestFactory
	Collection<DynamicTest> test_from_collection(){
		return Arrays.asList(
					dynamicTest("simple dynamic test",() -> assertTrue(true)),
					dynamicTest("My Executable Class",new MyExecutable()));		
	}
}

class MyExecutable implements Executable{

	@Override
	public void execute() throws Throwable {
		System.out.println("Hello World");
		
	}
	
}
