package chocan;
import java.util.*;

public class ManagerTerminal extends Terminal{
	
	private static Scanner reader = new Scanner(System.in);
	
	public static void managerMenu() {
		
		int option = 0;
		
		System.out.println("\nManager Terminal");
		System.out.println("1.) Generate Summary Report"); 
		System.out.println("2.) Generate Member Report"); 
		System.out.println("3.) Generate Provider Report"); 
		System.out.println("4.) Quit");
		System.out.print(" Option: ");
		
		option = reader.nextInt();
		
		if (option == 1) {
			// generate summary report
		}
			
		else if (option == 2) {
			// generate member report
		}
			
		else if (option == 3) {
			// generate provider report
		}
	}

}
