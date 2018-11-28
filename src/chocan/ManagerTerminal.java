package chocan;
import java.util.*;

public class ManagerTerminal extends Terminal{
	
	public static void managerMenu() {
		
		Scanner reader = new Scanner(System.in);
		int option = 0;
		
		while(true) {
			System.out.println("\nManager Terminal");
			System.out.println("1.) Generate Summary Report"); 
			System.out.println("2.) Generate Member Report"); 
			System.out.println("3.) Generate Provider Report"); 
			System.out.println("4.) Quit");
			System.out.print(" Option: ");
			
			option = reader.nextInt();
			
			if (option == 1) {
				// generate summary report
				continue;
			}
			
			else if (option == 2) {
				// generate member report
				continue;
			}
			
			else if (option == 3) {
				// generate provider report
				continue;
			}
			
			else {
				break;
			}
		}
		reader.close();
	}

}
