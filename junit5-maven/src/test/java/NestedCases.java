import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Outer Case ")
public class NestedCases {
	
	@Test
	void test() {
		System.out.println("Outer Class Test");
	}

//	@Nested
	@DisplayName("Inner Nested Case ")
	class InnerClass {
		@Test
		void test() {
			System.out.println("Inner Class Test");
		}
	}
}
