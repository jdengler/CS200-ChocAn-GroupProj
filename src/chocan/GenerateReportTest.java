package chocan;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class GenerateReportTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testGenerateMemberSuccess() throws FileNotFoundException, IOException {
    GenerateReport.generateMember("Harry Potter", 123456789);
  }

  @Test(expected = FileNotFoundException.class)
  public void testGenerateMemberException() throws FileNotFoundException, IOException{
    GenerateReport.generateMember("Doesnt Exist", 123456789);
  }


}