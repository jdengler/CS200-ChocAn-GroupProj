package chocan;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManagerTerminal extends Terminal{
	
	private static Scanner reader = new Scanner(System.in);
	
	public void managerMenu() throws FileNotFoundException, IOException{
		
		int option = 0;
		
		System.out.println("\nManager Terminal");
		System.out.println("1.) Generate Summary Report"); 
		System.out.println("2.) Generate Member Report"); 
		System.out.println("3.) Generate Provider Report"); 
		System.out.println("4.) Back to Main Terminal");
		System.out.print(" Option: ");
		
		option = reader.nextInt();
		
		if (option == 1) { // generate summary report
			System.out.println("Generate Summary Report");
			printSummaryReport();
		}
			
		else if (option == 2) { // generate member report
			System.out.println("\nGenerate Member Report");
			generateMember();
		}
			
		else if (option == 3) { // generate provider report
			System.out.println("\nGenerate Provider Report");
			generateProvider();
			
		}
	}

	
	private void generateMember() throws FileNotFoundException, IOException{
	    ArrayList<MemberAccounts> members = ReadMember();
	    System.out.print("Enter member's number: ");
	    int number = reader.nextInt();
	    
	    for (MemberAccounts ma : members) {
	        if (ma.getNumber() == number) {
	            printMemberReport(ma);
	        }
	    }
	    
	    return;
	}
	
	private void generateProvider() throws FileNotFoundException, IOException{
        ArrayList<ProviderAccounts> providers = ReadProviders();
        System.out.print("Enter provider's number: ");
        int number = reader.nextInt();
        
        for (ProviderAccounts pa : providers) {
            if (pa.getNumber() == number) {
                printProviderReport(pa);
            }
        }
        
        return;
    }
	
	/*
     * Prints the summary report (used by Manager)
     */
	private void printSummaryReport() throws FileNotFoundException,IOException{
	      ArrayList<ProviderAccounts> providers = ReadProviders();
	      Scanner reader = new Scanner(System.in);
	      System.out.println("Please name the file: ");
	      String name = reader.nextLine();
	      
	      String filename = "/Users/ashleyphan/git/cs200fall2018team2/src/chocan/writtenFiles/ServiceRecords/"+name+".txt";
	      double totalFee = 0;
	      int totalConsults = 0;
	      
	      File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
	      try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
	          for (ProviderAccounts pa : providers) {
	              ArrayList<ServiceRecord> sr = pa.getServicesProvided();
	              input.write(pa.getName()+","+pa.getNumberServices()+","+pa.getTotalFees(sr)+"\n");
	              totalConsults = totalConsults + pa.getNumberServices();
	              totalFee = totalFee + pa.getTotalFees(sr);
	          }
	          input.write("Total number of providers: "+providers.size()+"\n");
	          input.write("Total number of consultations: "+totalConsults+"\n");
	          input.write("Total number of fees: $"+totalFee+"\n");
	      input.close();
	      }
	      
	      System.out.print("\n"+"The summary report was successfully generated and stored in "+name+".txt"+"\n");
	      reader.close();
	}
	
	/*
     * Prints the member report (used by Manager)
     */
	  public void printMemberReport(MemberAccounts member) throws FileNotFoundException, IOException{
	      Scanner reader = new Scanner(System.in);
	      System.out.println("Please name the file: ");
	      String name = reader.nextLine();
	      
	      String filename = "/Users/ashleyphan/git/cs200fall2018team2/src/chocan/writtenFiles/MemberReports/"+name+".txt";
	      
	      
	      File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
	      try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
	          input.write(member.getName()+"\n"+member.getNumber()+"\n"+member.getAddress()+"\n"+member.getCity()+"\n"+member.getState()+"\n"+member.getZipCode()+"\n");
	          
	          ArrayList<ServiceRecord> sr = member.getServicesProvided();
	          if (sr != null) {
	              for(ServiceRecord service : sr) {
	                  input.write(service.getDateOfService()+"\n"+service.getProviderName(service.getProviderNumber())+"\n"+service.getServiceName(service.getServiceCode())+"\n");
	              }  
	          }

	          input.close();
	      }
	      
	      System.out.print("\n"+"The member report was successfully generated and stored in "+name+".txt"+"\n");
	      reader.close();
	  }
	  
	
	  /*
       * Prints the provider report (used by Manager)
       */
	  public void printProviderReport(ProviderAccounts provider) throws FileNotFoundException, IOException{
	      //ArrayList<ProviderAccounts> pa = ReadProviders();
	      
	      Scanner reader = new Scanner(System.in);
	      System.out.println("Please name the file: ");
	      String name = reader.nextLine();
	      double totalFee = 0;
	      String filename = "/Users/ashleyphan/git/cs200fall2018team2/src/chocan/writtenFiles/ProviderReports/"+name+".txt";
	      
	      
	      File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
	      try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
	          input.write(provider.getName()+"\n"+provider.getNumber()+"\n"+provider.getAddress()+"\n"+provider.getCity()+"\n"+provider.getState()+"\n"+provider.getZipCode()+"\n");
	          
	          ArrayList<ServiceRecord> sr = provider.getServicesProvided();
	          if (sr != null) {
	              for(ServiceRecord service : sr) {
	                  input.write(service.getDateOfService()+"\n"+service.getCurrentDateTime()+"\n"+service.getMemberName(service.getMemberNumber())+"\n"+service.getMemberNumber()+"\n"+service.getServiceCode()+"\n"+service.getServiceFee(service.getServiceCode())+"\n");
	                  totalFee = totalFee + service.getServiceFee(service.getServiceCode());
	              }  
	          }
	          input.write("Total number of consultations with members: "+sr.size()+"\n");
	          input.write("Total fee for the week: $"+totalFee+"\n");
	          input.close();
	      }
	      
	      System.out.print("\n"+"The provider report was successfully generated and stored in "+name+".txt"+"\n");
	      reader.close();
	  }
}
