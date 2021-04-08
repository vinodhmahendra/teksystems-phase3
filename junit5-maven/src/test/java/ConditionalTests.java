import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("conditional tests")
public class ConditionalTests {

	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void executeOnWindows() {
		System.out.println("this method executes on windows  os");
	}
	
	@Test
	@EnabledOnOs({OS.LINUX})
	public void executeOnLinux() {
		System.out.println("this method executes on linuxs  os");
	}
}
