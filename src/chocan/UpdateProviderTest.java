package chocan;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

//Josh Engler
public class UpdateProviderTest {

	@Before
	public void setUp() throws Exception {
	}

	//Test for success
	@Test
	public void testSuccessUpdateProvider() throws FileNotFoundException, IOException {
		ManageAccounts.updateProvider("Rubeus Hagrid", 123456789, "1 Forbidden Forest Drive", "Hogwarts", "Scotland", 77777);
		assertEquals(1, ManageAccounts.validProvider(123456789));
	}
	
	//Test for failure (empty string inputs)
	@Test (expected = IllegalArgumentException.class)
	public void testStringFailureUpdateProvider() throws FileNotFoundException, IOException, IllegalArgumentException {
		ManageAccounts.updateProvider("", 123456789, "", "", "", 77777);
	}
	
	//Test for failure (Zip code length > max)
	@Test (expected = IllegalArgumentException.class)
	public void testIntFailureUpdateProvider() throws FileNotFoundException, IOException, IllegalArgumentException {
		ManageAccounts.updateProvider("Rubeus Hagrid", 123456789, "1 Forbidden Forest Drive", "Hogwarts", "Scotland", 777777);
	}

}
