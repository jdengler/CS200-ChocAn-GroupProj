package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OperatorTerminal extends Terminal {
	
	public void operaterMenu() {
		System.out.println("Menu\n1. Manage Accounts\n2. Manage Provider\n");
	}
	
	public void readMembers() throws FileNotFoundException{
		Scanner buffer = new Scanner(new File("Members.txt"));
	    
	    Scanner input = new Scanner(buffer.toString()).useDelimiter(",|\n");
	
	    ManageAccounts ma = new ManageAccounts();
	    
	    while(input.hasNext()) {
	        String name = input.next();
	        int number = input.nextInt();
	        String address = input.next();
	        String city = input.next();
	        String state = input.next();
	        int zipCode = input.nextInt();
	        boolean status = input.nextBoolean();
	       
	        ma.addMember(name, number, address, city, state, zipCode, status);
	    }
	    
	    buffer.close();
	    input.close();
	}

}
