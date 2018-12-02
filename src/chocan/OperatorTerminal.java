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
			    addMember();
			    System.out.println("\nThe member has been added");
			    return;
			}
				
			else if (option == 2) { // delete member
				deleteMember();
				System.out.println("\nThe member has been removed");
				return;
			}
				
			else if (option == 3) { // update member
				System.out.println("\nUpdate Member");
				updateMember();
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
				
			if (option == 1) { // add provider
				System.out.println("\nAdd Provider");
				addProvider();
				
				return;
			}
				
			else if (option == 2) { // delete provider
				System.out.println("\nDelete Provider");
				deleteProvider();
				return;
			}
				
			else if (option == 3) { // update provider
				System.out.println("\nUpdate Provider");
				updateProvider();
				return;
			}
		}
	}
	
	public static void addMember() throws FileNotFoundException, IOException{
	    ArrayList <MemberAccounts> members = ReadMember();
	    Scanner reader = new Scanner(System.in);
	    
	    
        System.out.print("Enter member's name: ");
        String name = reader.nextLine();
        ma.setName(name);
        System.out.print("Enter member's number: ");
       // reader.nextLine();
        int number = reader.nextInt();
        ma.setNumber(number);
        System.out.print("Enter member's address: ");
        reader.nextLine();
        String address = reader.nextLine();
        ma.setAddress(address);
        System.out.print("Enter member's city: ");
        String city = reader.nextLine();
        ma.setCity(city);
        System.out.print("Enter member's state: ");
        String state = reader.nextLine();
        ma.setState(state);
        System.out.print("Enter member's zip code: ");
       // reader.nextLine();
        int zip = reader.nextInt();
        ma.setZipCode(zip);
        ma.setStatus(true);
	    
        members.add(ma);
        printMember(members);
        
        reader.close();
        
	}
	
	public static void deleteMember() throws FileNotFoundException, IOException{
	    ArrayList <MemberAccounts> members = ReadMember();
        Scanner reader = new Scanner(System.in);
        
        System.out.println("\nDelete Member");
        System.out.print("Enter member's number: ");
        int number = reader.nextInt();
        int found = -1;
        for (MemberAccounts m : members) {
            if (m.getNumber() == number) {
                members.remove(m);
                found = 1;
            }
        }
        
        if (found == -1) {
            System.out.println("The member does not exist");
            reader.close();
            return;
        }
        printMember(members);
        reader.close();
        
	}
	
	public static void updateMember() throws FileNotFoundException, IOException{
	    ArrayList <MemberAccounts> members = ReadMember();
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Enter member's name: ");
        String name = reader.nextLine();
        
        for (MemberAccounts m : members) {
            if (m.getName().equals(name)) {
                System.out.println("A member with this name already exists, do you wish to continue? [Y/N] ");
                reader.nextLine();
                String check = reader.nextLine();
                if (check.toUpperCase().equals("N")) {
                    reader.close();
                    return;
                }
                else {
                    m.setName(name);
                    m.setNumber(m.getNumber());
                    System.out.print("Enter member's address: ");
                    reader.nextLine();
                    String address = reader.nextLine();
                    m.setAddress(address);
                    System.out.print("Enter member's city: ");
                    String city = reader.nextLine();
                    m.setCity(city);
                    System.out.print("Enter member's state: ");
                    String state = reader.nextLine();
                    m.setState(state);
                    System.out.print("Enter member's zip code: ");
                   // reader.nextLine();
                    int zip = reader.nextInt();
                    m.setZipCode(zip);
                    //m.setStatus(m.getStatus());
                }
            }
        }
        printMember(members);
        reader.close();
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
	
	public static void addProvider() throws FileNotFoundException, IOException{
	    ArrayList<ProviderAccounts> providers = ReadProviders();
	    Scanner reader = new Scanner(System.in);
	    
	    System.out.print("Enter provider's name: ");
        String name = reader.nextLine();
        pacc.setName(name);
        System.out.print("Enter provider's number: ");
        //reader.nextLine();
        int number = reader.nextInt();
        pacc.setNumber(number);
        System.out.print("Enter provider's address: ");
        reader.nextLine();
        String address = reader.nextLine();
        pacc.setAddress(address);
        System.out.print("Enter provider's city: ");
        String city = reader.nextLine();
        pacc.setCity(city);
        System.out.print("Enter provider's state: ");
        String state = reader.nextLine();
        pacc.setState(state);
        System.out.print("Enter provider's zip code: ");
       // reader.nextLine();
        int zip = reader.nextInt();
        pacc.setZipCode(zip);
   
        
        providers.add(pacc);
        printProviders(providers);
        
        System.out.println("\nThe provider was sucessfully added");
        reader.close();
	}
	
	public static void deleteProvider() throws FileNotFoundException, IOException{
	    ArrayList<ProviderAccounts> providers = ReadProviders();
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Enter provider's number: ");
        int number = reader.nextInt();
        int found = -1;
        for (ProviderAccounts p : providers) {
            if (p.getNumber() == number) {
                providers.remove(p);
                found = 1;
            }
        }
        
        if (found == -1) {
            System.out.println("The provider does not exist");
            reader.close();
            return;
        }
        
        printProviders(providers);
        System.out.println("\nThe provider was sucessfully deleted");
        reader.close();
     
	}
	
	public static void updateProvider() throws FileNotFoundException, IOException{
        ArrayList <ProviderAccounts> providers = ReadProviders();
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Enter provider's name: ");
        String name = reader.nextLine();
        
        for (ProviderAccounts p : providers) {
            if (p.getName().equals(name)) {
                System.out.println("A provider with this name already exists, do you wish to continue? [Y/N] ");
                reader.nextLine();
                String check = reader.nextLine();
                if (check.toUpperCase().equals("N")) {
                    reader.close();
                    return;
                }
                else {
                    p.setName(name);
                    p.setNumber(p.getNumber());
                    System.out.print("Enter provider's address: ");
                    //reader.nextLine();
                    String address = reader.nextLine();
                    p.setAddress(address);
                    System.out.print("Enter provider's city: ");
                    String city = reader.nextLine();
                    p.setCity(city);
                    System.out.print("Enter provider's state: ");
                    String state = reader.nextLine();
                    p.setState(state);
                    System.out.print("Enter provider's zip code: ");
                   // reader.nextLine();
                    int zip = reader.nextInt();
                    p.setZipCode(zip);
                }
            }
        }
        printProviders(providers);
        
        System.out.println("\nThe provider was sucessfully updated");
        reader.close();
    }
	
	/*
     * Prints the providers (Used for operator purposes such as add/delete/update provider)
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
    
	/*public ManageAccounts ReadMemberTextFile() throws FileNotFoundException, IOException{
		Path mPath = Paths.get("C:/Eclipse/member.txt");
		//java.net.URL url = getClass().getResource("member.txt");		
		File mFile = mPath.toFile();
		String str;
		
		ArrayList<MemberAccounts> listMemA = new ArrayList<MemberAccounts>();
		
		if(Files.exists(mPath)){
			try(BufferedReader input = new BufferedReader(new FileReader(mFile))){
				 String line; //= input.readLine();
				while((line = input.readLine()) != null && !line.equals("")){
					String[] fields = line.split(",");
					MemberAccounts memA = new MemberAccounts();
					memA.setName(fields[0]); 
					memA.setNumber(Integer.parseInt(fields[1]));
			        memA.setAddress(fields[2]);
			        memA.setCity(fields[3]);
			        memA.setState(fields[4]);
			        memA.setZipCode(Integer.parseInt(fields[5]));
			        memA.setStatus(Boolean.parseBoolean(fields[6]));			        
			        
			        //line = input.readLine();
			        ArrayList<ServiceRecord> servicesProvided = new ArrayList<ServiceRecord>();
			        while((line = input.readLine()) != null && !line.equals("")){
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
				        //line = input.readLine();
			        }
			        memA.setServicesProvided(servicesProvided);
			        
			        listMemA.add(memA);
			        ma.setMemberAccountsList(listMemA);
					}
				}
			}
	
		
		return ma;
		}*/
}


