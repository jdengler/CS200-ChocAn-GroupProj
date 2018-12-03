package chocan;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManagerTerminal extends Terminal{
	
	private static Scanner reader = new Scanner(System.in);
	
	public static void managerMenu() throws FileNotFoundException, IOException{
		
		int option = 0;
		
		System.out.println("\nManager Terminal");
		System.out.println("1.) Generate Summary Report"); 
		System.out.println("2.) Generate Member Report"); 
		System.out.println("3.) Generate Provider Report"); 
		System.out.println("4.) Back to Main Terminal");
		System.out.print(" Option: ");
		
		option = reader.nextInt();
		reader.nextLine();
		
		if (option == 1) { // generate summary report
			System.out.println("\nGenerate Summary Report");
			
			System.out.print("Please name the file: ");
		    String name = reader.next();
		    
			printSummaryReport(name);
		}
			
		else if (option == 2) { // generate member report
			System.out.println("\nGenerate Member Report");
			
			System.out.print("Please name the file: ");
		    String name = reader.next();
		    System.out.print("Enter member's number: ");
		    int number = reader.nextInt();
		    reader.nextLine();
			
			generateMember(name, number);
		}
			
		else if (option == 3) { // generate provider report
			System.out.println("\nGenerate Provider Report");
			
			System.out.println("Please name the file: ");
		    String name = reader.next();
		    System.out.print("Enter provider's number: ");
	        int number = reader.nextInt();
	        reader.nextLine();
			
			generateProvider(name, number);
		}
		
		return;
	}

	
	public static void generateMember(String name, int number) throws FileNotFoundException, IOException{
	    ArrayList<MemberAccounts> members = ReadMember();
	    
	    for (MemberAccounts ma : members) {
	        if (ma.getNumber() == number) {
	            printMemberReport(ma, name);
	            return;
	        }
	    }
	    
	    System.out.println("The member does not exist");
	    return;
	}
	
	public static void generateProvider(String name, int number) throws FileNotFoundException, IOException{
        ArrayList<ProviderAccounts> providers = ReadProviders();
        
        for (ProviderAccounts pa : providers) {
            if (pa.getNumber() == number) {
                printProviderReport(pa, name);
                return;
            }
        }
        
        System.out.println("The provider does not exist");
        return;
    }
	
	/*
     * Prints the summary report (used by Manager)
     */
	public static void printSummaryReport(String name) throws FileNotFoundException,IOException{
	      ArrayList<ProviderAccounts> providers = ReadProviders();
	      
	      String filename = "writtenFiles/ServiceRecords/"+name+".txt";
	      double totalFee = 0;
	      int totalConsults = 0;
	      
	      File file = new File(filename);
	      /*Path oPath = Paths.get(filename);
	      File oFile = oPath.toFile();*/
	      try(BufferedWriter input = new BufferedWriter(new FileWriter(file))){
	          for (ProviderAccounts pa : providers) {
	              ArrayList<ServiceRecord> sr = pa.getServicesProvided();
	              input.write(pa.getName()+",");
	              if(sr == null) {
	                  input.write("0"+","+"0\n");
	              }
	              else {
	                  input.write(pa.getNumberServices()+",");
	                  input.write(pa.getTotalFees(sr)+"\n");
	                  totalConsults = totalConsults + pa.getNumberServices();
	                  totalFee = totalFee + pa.getTotalFees(sr);
	              }
	          }
	          input.write("Total number of providers: "+providers.size()+"\n");
	          input.write("Total number of consultations: "+totalConsults+"\n");
	          input.write("Total number of fees: $"+totalFee+"\n");
	      input.close();
	      }
	      
	      System.out.print("\n"+"The summary report was successfully generated and stored in "+name+".txt"+"\n");
	      
	      return;
	}
	
	/*
     * Prints the member report (used by Manager)
     */
	  public static void printMemberReport(MemberAccounts member, String name) throws FileNotFoundException, IOException{
	      
	      String filename = "writtenFiles/MemberReports/"+name+".txt";
	      
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
	  }
	  
	
	  /*
       * Prints the provider report (used by Manager)
       */
	  public static void printProviderReport(ProviderAccounts provider, String name) throws FileNotFoundException, IOException{
	      //ArrayList<ProviderAccounts> pa = ReadProviders();
	      
	      double totalFee = 0;
	      String filename = "writtenFiles/ProviderReports/"+name+".txt";
	      
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
	              input.write("Total number of consultations with members: "+sr.size()+"\n");
                  input.write("Total fees for the week: $"+totalFee+"\n");
	          }
	          else {
	              input.write("Total number of consultations with members: 0\n");
	              input.write("Total fees for the week: $0\n");
	          }
	          input.close();
	      }
	      
	      System.out.print("\n"+"The provider report was successfully generated and stored in "+name+".txt"+"\n");
	  }
}
