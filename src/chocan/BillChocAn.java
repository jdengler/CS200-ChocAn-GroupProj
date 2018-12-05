/*
 * Author: Ashley Phan
 */

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


  public static void billChocan(String currentDate, String actDate, int providerNum, int serviceCode, int memberNum)
      throws FileNotFoundException, IOException {
    ArrayList<MemberAccounts> me = Terminal.ReadMember();
    ArrayList<ProviderDirectoryEntry> pde = Terminal.ReadProviderDirectoryEntry();
    ServiceRecord sr = new ServiceRecord();

    MemberAccounts found = ManageAccounts.findMember(memberNum);

    if (found.getStatus() == false) {
      reader.close();
      return;
    }

    //DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    //Date date = new Date();
    //String strDate = dateFormat.format(date);
    sr.setCurrentDateTime(currentDate);

    sr.setDateOfService(actDate);
    sr.setProviderNumber(providerNum);
    sr.setMemberNumber(memberNum);
    String ProviderDir = "";
    for (ProviderDirectoryEntry pd : pde) {
      //System.out.println(pd.getServiceName() + "," + pd.getServiceCode() + "," + pd.getServiceFee());
    	ProviderDir += pd.getServiceName() + "," + pd.getServiceCode() + "," + pd.getServiceFee()+"\n";
    }
    //JOptionPane.showMessageDialog(null,ProviderDir);
    
    ProviderDirectoryEntry valid = ProviderDirectory.validEntry(serviceCode);
    if (valid == null) {
      reader.close();
      return;
    }
    //System.out.println("The total fee for the service " + valid.getServiceName()+"is $"+valid.getServiceFee());
    //JOptionPane.showMessageDialog(null,"The total fee for the service " + valid.getServiceName() + "is $" + valid.getServiceFee());
    int dialogResult = JOptionPane.showConfirmDialog(null, "The total fee for the service " + valid.getServiceName() + " is $" + valid.getServiceFee()+" Would you like to continue? ", "Attention",JOptionPane.YES_NO_OPTION);
    if (dialogResult == JOptionPane.YES_OPTION) {
      // Saving code here
    }

    //System.out.println("Would you like to continue? [Y/N]");
    //reader.nextLine();
    //String check = reader.nextLine();
    if (dialogResult == JOptionPane.NO_OPTION) {
      reader.close();
      return;
    }
    else if(dialogResult == JOptionPane.YES_OPTION){
    	 sr.setServiceCode(serviceCode);

    	    //System.out.println("Enter comments [Press Enter If No Comments]: ");
    	    //reader.nextLine();
    	    String comment = JOptionPane.showInputDialog("Enter comments : ");
    	    //String comment = reader.nextLine();
    	    sr.setComments(comment);

    	    sr.setMemberNumber(found.getNumber());
    	    found.addService(sr);

    	    //Is this redundant?
    	    for (MemberAccounts member : me) {
    	      if (member.getNumber() == found.getNumber()) {
    	        member.addService(sr);
    	        break;
    	      }
    	    }

    	    printBill(me);
    }
   
    return;
  }
  
  public static String getProviderDirectoryInfo() throws FileNotFoundException, IOException{
	  ArrayList<ProviderDirectoryEntry> pde = Terminal.ReadProviderDirectoryEntry();
	  String providerDir = "";
	    for (ProviderDirectoryEntry pd : pde) {
	    	providerDir += pd.getServiceName() + "," + pd.getServiceCode() + "," + pd.getServiceFee()+"\n";
	    }
	    //JOptionPane.showMessageDialog(null,ProviderDir);
	    return providerDir;
  }

  public static void printBill(ArrayList<MemberAccounts> ma)
      throws FileNotFoundException, IOException {
    String filename = "Database/member.txt";

    File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
    try (BufferedWriter input = new BufferedWriter(new FileWriter(file))) {
      for (MemberAccounts member : ma) {
        input.write(
            member.getName() + "," + member.getNumber() + "," + member.getAddress() + "," + member
                .getCity() + "," + member.getState() + "," + member.getZipCode() + "," + member
                .getStatus() + "\n");

        ArrayList<ServiceRecord> sr = member.getServicesProvided();
        if (sr != null) {
          for (ServiceRecord service : sr) {
            input.write("s," + service.getCurrentDateTime() + "," + service.getDateOfService() + ","
                + service.getProviderNumber() + "," + service.getMemberNumber() + "," + service
                .getServiceCode() + "," + service.getComments() + "\n");
          }
        }
      }
      input.close();
    }
    JOptionPane.showMessageDialog(null,"The billed report was successfully generated and stored in member.txt");
  }

}
