package chocan;

import java.util.*;

public class Terminal {

  static ManageAccounts ma = new ManageAccounts(); 
  public static void main(String[] args) {
	  
	int option=0;
	
	Scanner reader = new Scanner(System.in);
	
	while(option != 4) {
		System.out.println("\nChocAn System Menu");
		System.out.println("1.) Open Manager Terminal"); 
		System.out.println("2.) Open Provider Terminal"); 
		System.out.println("3.) Open Operator Terminal");
		System.out.println("4.) Quit");
		System.out.print(" Option: ");
		
		option = reader.nextInt();
		
		if (option == 1) { // manager terminal
			OpenManagerTerminal(reader);
		}
		
		else if (option == 2) { // provider terminal
			OpenProviderTerminal(reader);
		}
		
		else if (option == 3) { // operator terminal
			OpenOperatorTerminal(reader);
		}
	}
	
	System.out.println("\nEnd");
	
	reader.close();
  }
  
  public static void OpenManagerTerminal (Scanner reader) {
	  ManagerTerminal.menu();
  }
  
  public static void OpenProviderTerminal (Scanner reader) {
	  ProviderTerminal.menu();
  }
  
  public static void OpenOperatorTerminal (Scanner reader) {
	  OperatorTerminal.menu();
  }

}
