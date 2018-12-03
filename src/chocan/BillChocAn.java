package chocan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BillChocAn {
	
	private static Scanner reader = new Scanner(System.in);

	public static ProviderDirectoryEntry validEntry(int code) throws FileNotFoundException,IOException{
		ArrayList<ProviderDirectoryEntry> pde = Terminal.ReadProviderDirectoryEntry();
	    ProviderDirectoryEntry entry = new ProviderDirectoryEntry();
	    for (ProviderDirectoryEntry pd : pde) {
	    	if (pd.getServiceCode() == code) {
	    		entry = pd;
	        }
	    }
	    return entry;
	}
	
	public static void billChocan(String actDate, int providerNum, int serviceCode, int memberNum)throws FileNotFoundException, IOException{
	      ArrayList<MemberAccounts> me = Terminal.ReadMember();
	      ArrayList<ProviderDirectoryEntry> pde = Terminal.ReadProviderDirectoryEntry();
	      ServiceRecord sr = new ServiceRecord();
	      
	      MemberAccounts found = ValidateMember.validateMember(memberNum);
	      
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
