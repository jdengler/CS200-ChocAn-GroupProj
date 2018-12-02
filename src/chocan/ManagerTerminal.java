package chocan;
import java.io.FileNotFoundException;
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
}
