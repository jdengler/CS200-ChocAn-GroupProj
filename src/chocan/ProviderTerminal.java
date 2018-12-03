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
import javax.swing.JOptionPane;

//import com.sun.corba.se.spi.ior.Writeable;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class ProviderTerminal extends Terminal {
  
  private static Scanner reader = new Scanner(System.in);
  
  public static void providerMenu() throws FileNotFoundException, IOException {
	System.out.println("\nProvider Terminal");
	System.out.println("1.) Validate a ChocAn member"); 
	System.out.println("2.) Bill ChocAn"); 
	System.out.println("3.) Request a Provider Directory"); 
	System.out.println("4.) Go back to main terminal");
	System.out.print(" Option: ");
	
    int option = reader.nextInt();
    reader.nextLine();
    
    if (option == 1) { // validate member
    	System.out.println("Enter member number: ");
    	int memNum = reader.nextInt();
    	reader.nextLine();
    	validateMember(memNum);
    }
    
    else if (option == 2) { // bill chocan
    	System.out.println("Enter date of service (MM-DD-YYYY): ");
        String actDate = reader.nextLine();
        System.out.println("Enter provider number: ");
        int providerNum = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter the six-digit service code: ");
        int serviceCode = reader.nextInt();
        System.out.println("Enter member number: ");
        int memberNum = reader.nextInt();
        reader.nextLine();
        
    	billChocan(actDate, providerNum, serviceCode, memberNum);
    }
    
    else if (option == 3) { // request provider directory
    	requestDirectory();
    }
  }
  
  public static MemberAccounts validateMember(int memNum) throws FileNotFoundException, IOException{
	    ArrayList<MemberAccounts> me = ReadMember();
	    int found = -1;
	    MemberAccounts ma = new MemberAccounts();
	    
	    for(MemberAccounts account : me) {
	        if(account.getNumber() == memNum) {
	            found = 0;
	            if (account.getStatus() == false) {
	                System.out.println("\nSuspended");
	                JOptionPane.showMessageDialog(null, "The member with member number "+memNum+" has been suspended.");
	            }
	            else {
	                System.out.println("\nValidated");
	                JOptionPane.showMessageDialog(null, "Validated member number");
	            }
	            ma = account;
	        }
	    }
	    if (found == -1) {
	        System.out.println("\nInvalid");
	        JOptionPane.showMessageDialog(null, "Invalid member number");
	    }
	    return ma;
	  }
  
  public static ProviderDirectoryEntry validEntry(int code) throws FileNotFoundException,IOException{
      ArrayList<ProviderDirectoryEntry> pde = ReadProviderDirectoryEntry();
      ProviderDirectoryEntry entry = new ProviderDirectoryEntry();
      for (ProviderDirectoryEntry pd : pde) {
          if (pd.getServiceCode() == code) {
              entry = pd;
          }
      }
      return entry;
  }
  
  public static void billChocan(String actDate, int providerNum, int serviceCode, int memberNum)throws FileNotFoundException, IOException{
      ArrayList<MemberAccounts> me = ReadMember();
      ArrayList<ProviderDirectoryEntry> pde = ReadProviderDirectoryEntry();
      ServiceRecord sr = new ServiceRecord();
      
      MemberAccounts found = validateMember(memberNum);
      
      if (found.getStatus() == false) {
          reader.close();
          return;
      }
      
      DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
      Date date = new Date();
      String strDate = dateFormat.format(date);
      sr.setCurrentDateTime(strDate);
      
      sr.setDateOfService(actDate);
      sr.setProviderNumber(providerNum);
      sr.setMemberNumber(memberNum);
      
      for (ProviderDirectoryEntry pd: pde){
          System.out.println(pd.getServiceName()+","+pd.getServiceCode()+","+pd.getServiceFee());
      }
      
      ProviderDirectoryEntry valid = validEntry(serviceCode);
      if (valid == null) {
          reader.close();
          return;
      }
      //System.out.println("The total fee for the service " + valid.getServiceName()+"is $"+valid.getServiceFee());
      JOptionPane.showMessageDialog(null, "The total fee for the service " + valid.getServiceName()+"is $"+valid.getServiceFee());
      int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to continue? ","Attention",JOptionPane.YES_NO_OPTION);
      if(dialogResult == JOptionPane.YES_OPTION){
        // Saving code here
      }
      
      //System.out.println("Would you like to continue? [Y/N]");
      //reader.nextLine();
      //String check = reader.nextLine();
      if (dialogResult == JOptionPane.NO_OPTION) {
          reader.close();
          return;
      }
      sr.setServiceCode(serviceCode);
      
      
      //System.out.println("Enter comments [Press Enter If No Comments]: ");
      //reader.nextLine();
      String comment = JOptionPane.showInputDialog("Enter comments : ");
      //String comment = reader.nextLine();
      sr.setComments(comment);
      
      sr.setMemberNumber(found.getNumber());
      found.addService(sr);

      //Is this redundant?
      for(MemberAccounts member:me) {
          if (member.getNumber() == found.getNumber()) {
              member.addService(sr);
              break;
          }
      }
      
      printBill(me);
      
      return;
  }
  
  public static void requestDirectory() throws FileNotFoundException, IOException {
      rewriteDirectory();
  }
  
  public static void printBill(ArrayList<MemberAccounts> ma) throws FileNotFoundException, IOException{
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
      System.out.print("\n"+"The billed report was successfully generated and stored in member.txt"+"\n");
      JOptionPane.showMessageDialog(null, "The billed report was successfully generated and stored in member.txt");
      
  }
}
