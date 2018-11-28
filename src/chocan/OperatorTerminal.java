package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OperatorTerminal extends Terminal {
	
	public void operaterMenu() {
		Scanner reader = new Scanner(System.in);
		int option = 0;
		
		while(true) {
			System.out.println("\tOperator Menu");
			System.out.println("1.) Manage Member");
			System.out.println("2.) Manage Provider");
			System.out.println("3.) Quit"); 
			
			option = reader.nextInt();
			
			if (option == 1) {
				System.out.println("\tManage Member");
				System.out.println("1.) Add Member");
				System.out.println("2.) Delete Member");
				System.out.println("3.) Update Member");
				System.out.println("4.) Quit"); 
				
				option = reader.nextInt();
				
				if (option == 1) {
					// add member
					continue;
				}
				
				else if (option == 2) {
					// delete member
					continue;
				}
				
				else if (option == 3) {
					// update member
					continue;
				}
				
				else {
					break;
				}
			}
			
			else if (option == 2) {
				System.out.println("\tManage Provider");
				System.out.println("1.) Add Provider");
				System.out.println("2.) Delete Provider");
				System.out.println("3.) Update Provider");
				System.out.println("4.) Quit"); 
				
				option = reader.nextInt();
				
				if (option == 1) {
					// add provider
					continue;
				}
				
				else if (option == 2) {
					// delete provider
					continue;
				}
				
				else if (option == 3) {
					// update provider
					continue;
				}
				
				else {
					break;
				}
			}
			
			else {
				break;
			}
		}
		
		reader.close();
	
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
