package chocan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import chocan.MemberAccounts;
import chocan.ProviderAccounts;

public class ManageAccounts {
	
	private static Scanner reader = new Scanner(System.in);
	public static  MemberAccounts ma = new MemberAccounts();
	public static  ProviderAccounts pacc = new ProviderAccounts();
	
	/*
	 * Add new member
	 */
	public static void addMember(String name,int number,String address,String city,String state,int zip) throws FileNotFoundException, IOException,IllegalArgumentException {
	    ArrayList <MemberAccounts> members = Terminal.ReadMember();
       
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
	    ArrayList <MemberAccounts> members = Terminal.ReadMember();
	    int found = -1;
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
	
	/*
	 * Update an existing member
	 */
	
	public static void updateMember(String name,String address,String city,String state,int zip) throws FileNotFoundException, IOException{
	    ArrayList <MemberAccounts> members = Terminal.ReadMember();

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
	
	public static int validProvider(int number)throws FileNotFoundException, IOException,IllegalArgumentException{
        ArrayList <ProviderAccounts> providers = Terminal.ReadProviders();
        int found = 0;
        String temp = Integer.toString(number);
        
        if (temp.length() != 9) {
            throw new IllegalArgumentException("The provider's number must be 9 digits long!");
        }  
        
        for (ProviderAccounts m : providers) {    
            if (m.getNumber() == number) {
                found = 1;
                break;
            }
        }
        return found;
    }
	
	/*
	 * Add new provider
	 */
	
	public static void addProvider(String name,int number,String address,String city,String state,int zip) throws FileNotFoundException, IOException{
	    ArrayList<ProviderAccounts> providers = Terminal.ReadProviders();
	    
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
	    ArrayList<ProviderAccounts> providers = Terminal.ReadProviders();
        
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
            return;
        }
        
        printProviders(providers);
        System.out.println("\nThe provider was sucessfully deleted");
	}
	
	/*
	 * Update existing provider
	 */
	public static void updateProvider(String name,String address,String city,String state,int zip) throws FileNotFoundException, IOException{
        ArrayList <ProviderAccounts> providers = Terminal.ReadProviders();
        
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
