package chocan;

import static org.junit.jupiter.api.Assertions.*;

//namito

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderTerminalTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() throws FileNotFoundException, IOException {
		ProviderTerminal.validateMember(123456789);
		ProviderTerminal.billChocan("12-01-2018", 123123123, 123456, 123456789);
		ProviderTerminal.requestDirectory();
	}

}
