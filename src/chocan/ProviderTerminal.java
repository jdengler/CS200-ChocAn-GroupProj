package chocan;
import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.print.DocFlavor.URL;

//import com.sun.corba.se.spi.ior.Writeable;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class ProviderTerminal extends Terminal {
  
  private static Scanner sc = new Scanner(System.in);
  
  public void providerMenu() throws FileNotFoundException, IOException {
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
    //sc.close();
  }
  
  private MemberAccounts validateMember() throws FileNotFoundException, IOException{
    ArrayList<MemberAccounts> me = ReadMember();
    System.out.println("Enter member number: ");
    int found = -1;
    MemberAccounts ma = new MemberAccounts();
    int memNum = sc.nextInt();
    for(MemberAccounts account : me) {
        if(account.getNumber() == memNum) {
            found = 0;
            if (account.getStatus() == false) {
                System.out.println("\nSuspended");
            }
            else {
                System.out.println("\nValidated");
            }
            ma = account;
        }
    }
    if (found == -1) {
        System.out.println("\nInvalid");
    }
    return ma;
  }
  
  private ProviderDirectoryEntry validEntry(int code) throws FileNotFoundException,IOException{
      ArrayList<ProviderDirectoryEntry> pde = ReadProviderDirectoryEntry();
      ProviderDirectoryEntry entry = new ProviderDirectoryEntry();
      for (ProviderDirectoryEntry pd : pde) {
          if (pd.getServiceCode() == code) {
              entry = pd;
          }
      }
      return entry;
  }
  
  private void billChocan()throws FileNotFoundException, IOException{
      ArrayList<MemberAccounts> me = ReadMember();
      ArrayList<ProviderDirectoryEntry> pde = ReadProviderDirectoryEntry();
      ServiceRecord sr = new ServiceRecord();
      
      Scanner reader = new Scanner(System.in);
      MemberAccounts found = validateMember();
      
      if (found.getStatus() == false) {
          reader.close();
          return;
      }
      
      DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
      Date date = new Date();
      String strDate = dateFormat.format(date);
      sr.setCurrentDateTime(strDate);
      
      System.out.println("Enter date of service (MM-DD-YYYY): ");
      String actDate = reader.nextLine();
      sr.setDateOfService(actDate);
      
      System.out.println("Enter provider number: ");
      int providerNum = reader.nextInt();
      sr.setProviderNumber(providerNum);
      
      for (ProviderDirectoryEntry pd: pde){
          System.out.println(pd.getServiceName()+","+pd.getServiceCode()+","+pd.getServiceFee());
      }
      
      System.out.println("Enter the six-digit service code: ");
      int serviceCode = reader.nextInt();
      ProviderDirectoryEntry valid = validEntry(serviceCode);
      if (valid == null) {
          reader.close();
          return;
      }
      System.out.println("The service corresponding the code you have entered is " + valid.getServiceName());
      System.out.println("Is this the correct service? [Y/N]");
      reader.nextLine();
      String check = reader.nextLine();
      if (check.toUpperCase().equals("N")) {
          reader.close();
          return;
      }
      sr.setServiceCode(serviceCode);
      
      
      System.out.println("Enter comments [Press Enter If No Comments]: ");
      //reader.nextLine();
      String comment = reader.nextLine();
      sr.setComments(comment);
      
      sr.setMemberNumber(found.getNumber());
      found.addService(sr);

      
      for(MemberAccounts member:me) {
          if (member.getNumber() == found.getNumber()) {
              member.addService(sr);
              break;
          }
      }
      
      printBill(me);
      
      reader.close();
  }
  
  private void requestDirectory() throws FileNotFoundException, IOException {
      rewriteDirectory();
  }
  
  private void printBill(ArrayList<MemberAccounts> ma) throws FileNotFoundException, IOException{
      String filename = "/Users/ashleyphan/git/cs200fall2018team2/src/chocan/writtenFiles/Database/member.txt";
      
      
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
      System.out.print("\n"+"The billed report was successfully generated and stored in member.txt"+"\n");
  }
}
