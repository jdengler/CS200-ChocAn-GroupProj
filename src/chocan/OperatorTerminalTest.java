package chocan;

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
       addMember("Ashley Phan",101010101,"104 Happy Street","San Diego","California",55455);
    }
    
    @Test
    void testAddMemberFail() throws FileNotFoundException, IOException, IllegalArgumentException{
        
      thrown.expectMessage("The member number must be 9 digits long!");
      addMember("Ashley Phan",101010101,"104 Happy Street","San Diego","California",55455); 
        
    }
    
    
    @Test
    void testDeleteMember() throws FileNotFoundException, IOException,IllegalArgumentException{
        deleteMember(101010101);
    }
    
    
    
}
