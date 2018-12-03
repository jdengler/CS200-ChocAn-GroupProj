package chocan;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class ManageAccountsTest {


    @BeforeEach
    void setUp() throws Exception {
        
    }


    @Test
    void testAddMember() throws FileNotFoundException, IOException,IllegalArgumentException{
       ManageAccounts.addMember("Ashley Phan",101010101,"104 Happy Street","San Diego","California",55455);
    }
    
    @Test (expected = IllegalArgumentException.class)
    void testAddMemberFail() throws FileNotFoundException, IOException, IllegalArgumentException{
            ManageAccounts.addMember("Ashley Phan",1010101011,"104 Happy Street","San Diego","California",55455); 
    }
    
}
