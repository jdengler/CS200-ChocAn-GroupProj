package chocan;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class OperatorTerminalTest extends OperatorTerminal{

    @BeforeEach
    void setUp() throws Exception {
        
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void testAddMember() throws FileNotFoundException, IOException,IllegalArgumentException{
       ManageAccounts.addMember("Ashley Phan",101010101,"104 Happy Street","San Diego","California",55455);
    }
    
    void testAddMemberFail() throws FileNotFoundException, IOException, IllegalArgumentException{
        try {
            ManageAccounts.addMember("Ashley Phan",101010101,"104 Happy Street","San Diego","California",55455); 
            fail("Should of thrown an IllegalArgumentException");
        }catch (IllegalArgumentException e) {
            
        }
        
    }
    
}
