package chocan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.print.DocFlavor.URL;

public class OperatorTerminal extends Terminal {
	
	private static Scanner reader = new Scanner(System.in);
	public  ManageAccounts ma = new ManageAccounts();
	

	public  void operaterMenu() throws FileNotFoundException, IOException {
		ma = ReadMemberTextFile();

	
		

		int option = 0;
		
		System.out.println("\nOperator Menu");
		System.out.println("1.) Manage Member");
		System.out.println("2.) Manage Provider");
		System.out.println("3.) Go back to main terminal"); 
		System.out.print(" Option: ");
			
		option = reader.nextInt();
			
		if (option == 1) {
			System.out.println("\nManage Member");
			System.out.println("1.) Add Member");
			System.out.println("2.) Delete Member");
			System.out.println("3.) Update Member");
			System.out.println("4.) Go back to main terminal"); 
			System.out.print(" Option: ");
				
			option = reader.nextInt();
				
			if (option == 1) { // add member
				System.out.println("\nAdd Member");
				System.out.print("Enter member's name: ");
				String name = reader.next();
				System.out.print("Enter member's number: ");
				int number = reader.nextInt();
				System.out.print("Enter member's address: ");
				String address = reader.next();
				System.out.print("Enter member's city: ");
				String city = reader.next();
				System.out.print("Enter member's state: ");
				String state = reader.next();
				System.out.print("Enter member's zip code: ");
				int zipCode = reader.nextInt();
				ManageAccounts ma = new ManageAccounts();
				//ma.addMember(name, number, address, city, state, zipCode, true);
			}
				
			else if (option == 2) { // delete member
				System.out.println("\nDelete Member");
				System.out.print("Enter member's number: ");
				int number = reader.nextInt();
				ManageAccounts ma = new ManageAccounts();
				ma.deleteMember(number);
			}
				
			else if (option == 3) { // update member
				System.out.println("\nUpdate Member");
				System.out.print("Enter member's name: ");
				String name = reader.next();
				System.out.print("Enter member's number: ");
				int number = reader.nextInt();
				System.out.print("Enter member's address: ");
				String address = reader.next();
				System.out.print("Enter member's city: ");
				String city = reader.next();
				System.out.print("Enter member's state: ");
				String state = reader.next();
				System.out.print("Enter member's zip code: ");
				int zipCode = reader.nextInt();
				ManageAccounts ma = new ManageAccounts();
				ma.updateMember(name, number, address, city, state, zipCode, true);
			}
		}
			
		else if (option == 2) {
			System.out.println("\nManage Provider");
			System.out.println("1.) Add Provider");
			System.out.println("2.) Delete Provider");
			System.out.println("3.) Update Provider");
			System.out.println("4.) Go back to main terminal"); 
			System.out.print(" Option: ");
				
			option = reader.nextInt();
				
			if (option == 1) { // add provider
				System.out.println("\nAdd Provider");
				System.out.print("Enter provider's name: ");
				String name = reader.next();
				System.out.print("Enter provider's number: ");
				int number = reader.nextInt();
				System.out.print("Enter provider's address: ");
				String address = reader.next();
				System.out.print("Enter provider's city: ");
				String city = reader.next();
				System.out.print("Enter provider's state: ");
				String state = reader.next();
				System.out.print("Enter provider's zip code: ");
				int zipCode = reader.nextInt();
				ManageAccounts ma = new ManageAccounts();
				ma.addProvider(name, number, address, city, state, zipCode);
			}
				
			else if (option == 2) { // delete provider
				System.out.println("\nDelete Provider");
				System.out.print("Enter provider's number: ");
				int number = reader.nextInt();
				ManageAccounts ma = new ManageAccounts();
				ma.deleteProvider(number);
			}
				
			else if (option == 3) { // update provider
				System.out.print("Enter provider's name: ");
				String name = reader.next();
				System.out.print("Enter provider's number: ");
				int number = reader.nextInt();
				System.out.print("Enter provider's address: ");
				String address = reader.next();
				System.out.print("Enter provider's city: ");
				String city = reader.next();
				System.out.print("Enter provider's state: ");
				String state = reader.next();
				System.out.print("Enter provider's zip code: ");
				int zipCode = reader.nextInt();
				ManageAccounts ma = new ManageAccounts();
				ma.updateProvider(name, number, address, city, state, zipCode);
			}
		}
	}
	
	/*public static ManageAccounts readMembers() throws FileNotFoundException{
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
	        boolean status = input.nextBoolean();
	       
	        ma.addMember(name, number, address, city, state, zipCode, status);
	    }
	    
	    buffer.close();
	    input.close();
	    return ma;
	}*/
	
	public ManageAccounts ReadMemberTextFile() throws FileNotFoundException, IOException{
		Path mPath = Paths.get("C:/Eclipse/member.txt");
		//java.net.URL url = getClass().getResource("member.txt");		
		File mFile = mPath.toFile();
		
		ArrayList<MemberAccounts> listMemA = new ArrayList<MemberAccounts>();
		
		if(Files.exists(mPath)){
			try(BufferedReader input = new BufferedReader(new FileReader(mFile))){
				 String line = input.readLine();
				while(line != null){
					String[] fields = line.split(",");
					MemberAccounts memA = new MemberAccounts();
					memA.setName(fields[0]); 
					memA.setNumber(Integer.parseInt(fields[1]));
			        memA.setAddress(fields[2]);
			        memA.setCity(fields[3]);
			        memA.setState(fields[4]);
			        memA.setZipCode(Integer.parseInt(fields[5]));
			        memA.setStatus(Boolean.parseBoolean(fields[6]));			        
			        
			        line = input.readLine();
			        ArrayList<ServiceRecord> servicesProvided = new ArrayList<ServiceRecord>();
			        while(line != null){
			        	String[] serviceFields = line.split(",");
				        ServiceRecord sr = new ServiceRecord();
				        if(serviceFields != null){
				        	sr.setCurrentDateTime(serviceFields[0]);
					        sr.setDateOfService(serviceFields[1]);
					        sr.setProviderNumber(Integer.parseInt(serviceFields[2]));
					        sr.setMemberNumber(Integer.parseInt(serviceFields[3]));
					        sr.setServiceCode(Integer.parseInt(serviceFields[4]));
					        sr.setComments(serviceFields[5]);
				        }  
				        servicesProvided.add(sr);
				        line = input.readLine();
			        }
			        memA.setServicesProvided(servicesProvided);
			        
			        listMemA.add(memA);
			       ma.setMemberAccountsList(listMemA);
			        //ma.addMember(name, number, address, city, state, zipCode, status, servicesProvided);
			        line = input.readLine();
				}
				}
			}
	
		
		return ma;
		}
}


