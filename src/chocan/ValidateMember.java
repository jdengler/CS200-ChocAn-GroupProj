package chocan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class ValidateMember {
	
	public static MemberAccounts validateMember(int memNum) throws FileNotFoundException, IOException{
	    ArrayList<MemberAccounts> me = Terminal.ReadMember();
	    int found = -1;
	    MemberAccounts ma = new MemberAccounts();
	    ma.setStatus(false);
	    
	    for(MemberAccounts account : me) {
	        if(account.getNumber() == memNum) {
	            found = 0;
	            if (account.getStatus() == false) {
	                //System.out.println("\nSuspended");
	                JOptionPane.showMessageDialog(null, "The member with member number "+memNum+" has been suspended.");
	            }
	            else {
	                //System.out.println("\nValidated");
	                JOptionPane.showMessageDialog(null, "Valid member number");
	            }
	            ma = account;
	        }
	    }
	    if (found == -1) {
	        //System.out.println("\nInvalid");
	        JOptionPane.showMessageDialog(null, "Invalid member number");
	    }
	    return ma;
	  }
}
