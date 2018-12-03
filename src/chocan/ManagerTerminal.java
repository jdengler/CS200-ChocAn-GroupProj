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
		    
			GenerateReport.printSummaryReport(name);
		}
			
		else if (option == 2) { // generate member report
			System.out.println("\nGenerate Member Report");
			
			System.out.print("Please name the file: ");
		    String name = reader.next();
		    System.out.print("Enter member's number: ");
		    int number = reader.nextInt();
		    reader.nextLine();
			
			GenerateReport.generateMember(name, number);
		}
			
		else if (option == 3) { // generate provider report
			System.out.println("\nGenerate Provider Report");
			
			System.out.println("Please name the file: ");
		    String name = reader.next();
		    System.out.print("Enter provider's number: ");
	        int number = reader.nextInt();
	        reader.nextLine();
			
			GenerateReport.generateProvider(name, number);
		}
		
		return;
	}
}
