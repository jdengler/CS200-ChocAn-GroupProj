package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OperatorTerminal extends Terminal {
	
	public static void operaterMenu(Scanner reader) {
		
		int option = 0;
		
		System.out.println("\nOperator Menu");
		System.out.println("1.) Manage Member");
		System.out.println("2.) Manage Provider");
		System.out.println("3.) Quit"); 
		System.out.print(" Option: ");
			
		option = reader.nextInt();
			
		if (option == 1) {
			System.out.println("Manage Member");
			System.out.println("1.) Add Member");
			System.out.println("2.) Delete Member");
			System.out.println("3.) Update Member");
			System.out.println("4.) Quit"); 
			System.out.print(" Option: ");
				
			option = reader.nextInt();
				
			if (option == 1) {
				// add member
			}
				
			else if (option == 2) {
				// delete member
			}
				
			else if (option == 3) {
				// update member
			}
		}
			
		else if (option == 2) {
			System.out.println("\nManage Provider");
			System.out.println("1.) Add Provider");
			System.out.println("2.) Delete Provider");
			System.out.println("3.) Update Provider");
			System.out.println("4.) Quit"); 
			System.out.print(" Option: ");
				
			option = reader.nextInt();
				
			if (option == 1) {
				// add provider
			}
				
			else if (option == 2) {
				// delete provider
			}
				
			else if (option == 3) {
				// update provider
			}
		}
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
