package chocan;
import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.print.DocFlavor.URL;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedReader;

public class ProviderTerminal {
  public ProviderDirectory pd = new ProviderDirectory();
  
  private static Scanner sc = new Scanner(System.in);
  
  public void menu() throws FileNotFoundException, IOException {
      
      pd = ReadProviderDirectoryEntry();
	  
	System.out.println("\nProvider Terminal");
	System.out.println("1.) Validate a ChocAn member"); 
	System.out.println("2.) Bill ChocAn"); 
	System.out.println("3.) Request a Provider Directory"); 
	System.out.println("4.) Go back to main terminal");
	System.out.print(" Option: ");
	
    int userChoice = sc.nextInt();
    switch(userChoice) {
        case 1:
          validateMember();
          break;
        case 2:
          billChocan();
          break;
        case 3:
          requestDirectory();
          break;
        default:
          System.out.println("Please enter a valid choice...");
          break;
    }
  }
  
  private static void validateMember() {
    System.out.print("\nEnter member number: ");
    int memNum = sc.nextInt();
    ValidateMember x = new ValidateMember(memNum);
  }
  
  private static void billChocan() {
    
  }
  
  private static void requestDirectory() {
    
  }
  
  public static String readFileAsString(String fileName) throws FileNotFoundException, IOException{ 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  }
  
  public ProviderDirectory ReadProviderDirectoryEntry() throws FileNotFoundException, IOException {
      String filename = "/Users/ashleyphan/git/cs200fall2018team2/src/chocan/writtenFiles/ProviderReports/providerDirectory.txt";
      Path mPath = Paths.get(filename);
    
      File mFile = mPath.toFile();
      String str;
      
      
      ArrayList<ProviderDirectoryEntry> listPde = new ArrayList<ProviderDirectoryEntry>();
      
      if(Files.exists(mPath)){
          try(BufferedReader input = new BufferedReader(new FileReader(mFile))){
              String line = input.readLine();
          
              while (line != null) {
                  System.out.println(line);
                  line = input.readLine();
              }
          }
      }
             /*while(line != null){
                 String[] fields = line.split(",");
                 ProviderDirectoryEntry pde2 = new ProviderDirectoryEntry();
                 pde2.setServiceName(fields[0]); 
                 pde2.setServiceCode(Integer.parseInt(fields[1]));
                 pde2.setServiceFee(Double.parseDouble(fields[2]));               
                 
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
                 ma.addMember(name, number, address, city, state, zipCode, status, servicesProvided);
                 line = input.readLine();*/
      //}
      return pd;
  }
}
