package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OperatorTerminal extends Terminal {
	
	private static Scanner reader = new Scanner(System.in);
	
	public static void operaterMenu() {
		
		int option = 0;
		
		System.out.println("\nOperator Menu");
		System.out.println("1.) Manage Member");
		System.out.println("2.) Manage Provider");
		System.out.println("3.) Quit"); 
		System.out.print(" Option: ");
			
		option = reader.nextInt();
			
		if (option == 1) {
			System.out.println("\nManage Member");
			System.out.println("1.) Add Member");
			System.out.println("2.) Delete Member");
			System.out.println("3.) Update Member");
			System.out.println("4.) Quit"); 
			System.out.print(" Option: ");
				
			option = reader.nextInt();
				
			if (option == 1) { // add member
				String name = "Name";
				int number = 1;
				String address = "Address";
				String city = "City";
				String state = "State";
				int zipCode = 01234;
				int status = 1;
				ManageAccounts ma = new ManageAccounts();
				ma.addMember(name, number, address, city, state, zipCode, status);
			}
				
			else if (option == 2) { // delete member
				int number = 1;
				ManageAccounts ma = new ManageAccounts();
				ma.deleteMember(number);
			}
				
			else if (option == 3) { // update member
				String name = "Name";
				int number = 1;
				String address = "Address";
				String city = "City";
				String state = "State";
				int zipCode = 01234;
				int status = 1;
				ManageAccounts ma = new ManageAccounts();
				ma.updateMember(name, number, address, city, state, zipCode, status);
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
				
			if (option == 1) { // add provider
				String name = "Name";
				int number = 1;
				String address = "Address";
				String city = "City";
				String state = "State";
				int zipCode = 01234;
				ManageAccounts pa = new ManageAccounts();
				pa.addProvider(name, number, address, city, state, zipCode);
			}
				
			else if (option == 2) { // delete provider
				int number = 1;
				ManageAccounts pa = new ManageAccounts();
				pa.deleteProvider(number);
			}
				
			else if (option == 3) { // update provider
				String name = "Name";
				int number = 1;
				String address = "Address";
				String city = "City";
				String state = "State";
				int zipCode = 01234;
				ManageAccounts pa = new ManageAccounts();
				pa.updateProvider(name, number, address, city, state, zipCode);
			}
		}
	}
	
	public static ManageAccounts readMembers() throws FileNotFoundException{
		Scanner buffer = new Scanner(new File("writtenFiles.MemberReports.members.txt"));
	    
	    Scanner input = new Scanner(buffer.toString()).useDelimiter(",|\n");
	
	    ManageAccounts ma = new ManageAccounts();
	    
	    while(input.hasNext()) {
	        String name = input.next();
	        int number = input.nextInt();
	        String address = input.next();
	        String city = input.next();
	        String state = input.next();
	        int zipCode = input.nextInt();
	        int status = input.nextInt();
	       
	        ma.addMember(name, number, address, city, state, zipCode, status);
	    }
	    
	    buffer.close();
	    input.close();
	    return ma;
	}

}
