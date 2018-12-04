package chocan;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ManageAccountsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAddMember() throws FileNotFoundException, IOException,IllegalArgumentException{
        ManageAccounts.addMember("Ashley Phan",101010101,"1902 West Street","Tuscaloosa","Alabama",31902);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFailDeleteMember() throws FileNotFoundException, IOException,IllegalArgumentException{
        ManageAccounts.deleteMember(111111111);
    }

    @Test
    public void testSanityAddProvider()throws FileNotFoundException, IOException,IllegalArgumentException{
        ManageAccounts.addProvider("Ashley Phan",122222221,"1902 West Street","Tuscaloosa","Alabama",31902);
        ManageAccounts.deleteProvider(122222221);
        
        assertEquals(1,ManageAccounts.validProvider(122222221));
        
    }

}
