package chocan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.print.DocFlavor.URL;

public class OperatorTerminal extends Terminal {
	
	private static Scanner reader = new Scanner(System.in);
	public static  MemberAccounts ma = new MemberAccounts();
	public static  ProviderAccounts pacc = new ProviderAccounts();

	public static void operaterMenu() throws FileNotFoundException, IOException {

		int option = 0;
		
		System.out.println("\nOperator Menu");
		System.out.println("1.) Manage Member");
		System.out.println("2.) Manage Provider");
		System.out.println("3.) Go back to main terminal"); 
		System.out.print(" Option: ");
			
		option = reader.nextInt();
		reader.nextLine();
			
		if (option == 1) {
			System.out.println("\nManage Member");
			System.out.println("1.) Add Member");
			System.out.println("2.) Delete Member");
			System.out.println("3.) Update Member");
			System.out.println("4.) Go back to main terminal"); 
			System.out.print(" Option: ");
				
			option = reader.nextInt();
			reader.nextLine();
				
			if (option == 1) { // add member
			    System.out.println("\nAdd Member");
			    System.out.print("Enter member's name: ");
		        String name = reader.nextLine();
		        System.out.print("Enter member's number: ");
		        int number = reader.nextInt();
		        reader.nextLine();
		        System.out.print("Enter member's address: ");
		        String address = reader.nextLine();
		        System.out.print("Enter member's city: ");
		        String city = reader.nextLine();
		        System.out.print("Enter member's state: ");
		        String state = reader.nextLine();
		        System.out.print("Enter member's zip code: ");
		        int zip = reader.nextInt();
		        reader.nextLine();
		        
			    addMember(name,number,address,city,state,zip);
			    System.out.println("\nThe member has been added");
			    return;
			}
				
			else if (option == 2) { // delete member
			    System.out.println("\nDelete Member");
		        System.out.print("Enter member's number: ");
		        int number = reader.nextInt();
		        reader.nextLine();
				deleteMember(number);
				System.out.println("\nThe member has been removed");
				return;
			}
				
			else if (option == 3) { // update member
				System.out.println("\nUpdate Member");
				
				ArrayList <MemberAccounts> members = ReadMember();
		        
		        System.out.print("Enter member's name: ");
		        String name = reader.nextLine();
		        
		        for (MemberAccounts m : members) {
		            if (m.getName().equals(name)) {
		                System.out.print("A member with this name already exists, do you wish to continue? [Y/N]: ");
		                String check = reader.nextLine();
		                if (check.toUpperCase().equals("N")) {
		                    reader.close();
		                    return;
		                }
		                else {
		                    System.out.print("Enter member's address: ");
		                    String address = reader.nextLine();
		                    System.out.print("Enter member's city: ");
		                    String city = reader.nextLine();
		                    System.out.print("Enter member's state: ");
		                    String state = reader.nextLine();
		                    System.out.print("Enter member's zip code: ");
		                    int zip = reader.nextInt();
		                    reader.nextLine();
		                    updateMember(name,address,city,state,zip);
		                }
		            }
		        }
				
				System.out.println("\nThe member has been updated");
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
			reader.nextLine();
				
			if (option == 1) { // add provider
				System.out.println("\nAdd Provider");
				System.out.print("Enter provider's name: ");
		        String name = reader.nextLine();
		        System.out.print("Enter provider's number: ");
		        int number = reader.nextInt();
		        reader.nextLine();
		        System.out.print("Enter provider's address: ");
		        String address = reader.nextLine();
		        System.out.print("Enter provider's city: ");
		        String city = reader.nextLine();
		        System.out.print("Enter provider's state: ");
		        String state = reader.nextLine();
		        System.out.print("Enter provider's zip code: ");
		        int zip = reader.nextInt();
		        reader.nextLine();
				addProvider(name,number,address,city,state,zip);
				
				return;
			}
				
			else if (option == 2) { // delete provider
				System.out.println("\nDelete Provider");
				System.out.println("Enter provider's number: ");
		        int number = reader.nextInt();
		        reader.nextLine();
				deleteProvider(number);
				return;
			}
				
			else if (option == 3) { // update provider
				System.out.println("\nUpdate Provider");
				
				ArrayList <ProviderAccounts> providers = ReadProviders();
		        
		        System.out.print("Enter provider's name: ");
		        String name = reader.nextLine();
		        
		        for (ProviderAccounts p : providers) {
		            if (p.getName().equals(name)) {
		                System.out.println("A provider with this name already exists, do you wish to continue? [Y/N] ");
		                String check = reader.nextLine();
		                if (check.toUpperCase().equals("N")) {
		                    reader.close();
		                    return;
		                }
		                else {
		                    System.out.print("Enter provider's address: ");
		                    String address = reader.nextLine();
		                    System.out.print("Enter provider's city: ");
		                    String city = reader.nextLine();
		                    System.out.print("Enter provider's state: ");
		                    String state = reader.nextLine();
		                    System.out.print("Enter provider's zip code: ");
		                    int zip = reader.nextInt();
		                    reader.nextLine();
		                    updateProvider(name,address,city,state,zip);
		                }
		            }
		        }
				
				return;
			}
		}
	}
	
	/*
	 * Add new member
	 */
	public static void addMember(String name,int number,String address,String city,String state,int zip) throws FileNotFoundException, IOException,IllegalArgumentException {
	    ArrayList <MemberAccounts> members = ReadMember();
	    
	    
       
        ma.setName(name);
        
        try {
            String temp = Integer.toString(number);
            if (temp.length() != 9) {
                throw new IllegalArgumentException("The member number must be 9 digits long!");
            }      
        }
        finally {
            ma.setNumber(number); 
        }
        
        ma.setAddress(address);     
        ma.setCity(city);
        ma.setState(state);
        ma.setZipCode(zip);
        ma.setStatus(true);
	    
        members.add(ma);
        printMember(members);
	}
	
	/*
	 * Delete existing member
	 */
	public static void deleteMember(int number) throws FileNotFoundException, IOException,IllegalArgumentException{
	    ArrayList <MemberAccounts> members = ReadMember();
        int found = -1;
        
        try {
            String temp = Integer.toString(number);
            if (temp.length() != 9) {
                throw new IllegalArgumentException("The member number must be 9 digits long!");
            }      
        }
        finally {
            for (MemberAccounts m : members) {
                if (m.getNumber() == number) {
                    members.remove(m);
                    found = 1;
                    break;
                }
            }
            if (found == -1) {
                reader.close();
                throw new IllegalArgumentException("The member does not exist!");
            }
            printMember(members);
        }
        
      
	}
	
	/*
	 * Update an existing member
	 */
	
	public static void updateMember(String name,String address,String city,String state,int zip) throws FileNotFoundException, IOException{
	    ArrayList <MemberAccounts> members = ReadMember();

        for (MemberAccounts m : members) {
            if (m.getName().equals(name)) {
                m.setName(name);
                m.setNumber(m.getNumber());
                m.setAddress(address);
                m.setCity(city);
                m.setState(state);
                m.setZipCode(zip);    
            }
        }
        printMember(members);
	}
	
	public static void printMember(ArrayList<MemberAccounts> ma) throws FileNotFoundException, IOException{
	      String filename = "Database/member.txt";
	      
	      File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
	      try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
	          for (MemberAccounts member : ma) {
	              input.write(member.getName()+","+member.getNumber()+","+member.getAddress()+","+member.getCity()+","+member.getState()+","+member.getZipCode()+","+member.getStatus()+"\n");
	          
	              ArrayList<ServiceRecord> sr = member.getServicesProvided();
	              if (sr != null) {
	                  for(ServiceRecord service : sr) {
	                      input.write("s,"+ service.getCurrentDateTime()+","+service.getDateOfService()+","+service.getProviderNumber()+","+service.getMemberNumber()+","+service.getServiceCode()+","+service.getComments()+"\n");
	                  }  
	              }
	          }
	          input.close();
	      }
	  }
	
	
	/*
	 * Add new provider
	 */
	
	public static void addProvider(String name,int number,String address,String city,String state,int zip) throws FileNotFoundException, IOException{
	    ArrayList<ProviderAccounts> providers = ReadProviders();
	    
	    
        pacc.setName(name);
        pacc.setNumber(number);
        pacc.setAddress(address);
        pacc.setCity(city);
        pacc.setState(state);
        pacc.setZipCode(zip);
   
        
        providers.add(pacc);
        printProviders(providers);
        
        System.out.println("\nThe provider was sucessfully added");
	}
	
	/*
	 * Delete existing provider
	 */
	public static void deleteProvider(int number) throws FileNotFoundException, IOException{
	    ArrayList<ProviderAccounts> providers = ReadProviders();
        
        
        int found = -1;
        for (ProviderAccounts p : providers) {
            if (p.getNumber() == number) {
                providers.remove(p);
                found = 1;
                break;
            }
        }
        
        if (found == -1) {
            System.out.println("The provider does not exist");
            reader.close();
            return;
        }
        
        printProviders(providers);
        System.out.println("\nThe provider was sucessfully deleted");
	}
	
	/*
	 * Update existing provider
	 */
	public static void updateProvider(String name,String address,String city,String state,int zip) throws FileNotFoundException, IOException{
        ArrayList <ProviderAccounts> providers = ReadProviders();
        
        
        for (ProviderAccounts p : providers) {
            if (p.getName().equals(name)) {
                p.setName(name);
                p.setNumber(p.getNumber());
                p.setAddress(address);
                p.setCity(city);
                p.setState(state);
                p.setZipCode(zip);
                
                printProviders(providers);
            }
        }

        System.out.println("\nThe provider was sucessfully updated");
    }
	
	/*
     * Prints the list of providers and the corresponding Service Records
     */
     public static void printProviders(ArrayList<ProviderAccounts> pa) throws FileNotFoundException, IOException{
        String filename = "Database/provider.txt";
        Path oPath = Paths.get(filename);
        
        File oFile = oPath.toFile();
        try(BufferedWriter input = new BufferedWriter(new FileWriter(oFile))){
            for (ProviderAccounts provider : pa) {
                input.write(provider.getName()+","+provider.getNumber()+","+provider.getAddress()+","+provider.getCity()+","+provider.getState()+","+provider.getZipCode()+"\n");
            
                ArrayList<ServiceRecord> sr = provider.getServicesProvided();
                if (sr != null) {
                    for(ServiceRecord service : sr) {
                        input.write("s,"+ service.getCurrentDateTime()+","+service.getDateOfService()+","+service.getProviderNumber()+","+service.getMemberNumber()+","+service.getServiceCode()+","+service.getComments()+"\n");
                    }  
                }
            }
            input.close();
        }
    }
}


