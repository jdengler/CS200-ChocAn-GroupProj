/*
 * Author: Ashley Phan
 * Tests the functionality of addMember
 */

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
        ManageAccounts.addMember("Ginny Weasley",101010101,"1902 West Street","Tuscaloosa","Alabama",31902);
        assertEquals(1,ManageAccounts.validMember(101010101));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFailAddMember() throws FileNotFoundException, IOException,IllegalArgumentException{
        ManageAccounts.addMember("Neville Longbottom",55155155,"123 Accident Prone","Orange County","California",99213);
        //assertEquals(0,ManageAccounts.validProvider(55155155));
    }

    @Test
    public void testAddMember2()throws FileNotFoundException, IOException,IllegalArgumentException{
        ManageAccounts.addMember("Draco Malfoy",122222221,"10 Slytherin Lane","Seattle","Washington",55432);
        
        assertEquals(1,ManageAccounts.validMember(122222221));
        
    }

}
