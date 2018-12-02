package chocan;
import java.util.*;

public class ManagerTerminal extends Terminal{
	
	private static Scanner reader = new Scanner(System.in);
	
	public static void menu() {
		
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
			GenerateReport.GenerateSummaryReport();
		}
			
		else if (option == 2) { // generate member report
			System.out.println("\nGenerate Member Report");
			System.out.print("Enter member's number: ");
			int number = reader.nextInt();
			GenerateReport.GenerateMemberReport(number);
		}
			
		else if (option == 3) { // generate provider report
			System.out.println("\nGenerate Provider Report");
			System.out.print("Enter provider's number: ");
			int number = reader.nextInt();
			GenerateReport.GenerateProviderReport(number);
		}
	}

	
	
}
