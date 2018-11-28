package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProviderTerminal {
  
  private static Scanner sc = new Scanner(System.in);
  
  public static void providerMenu() {
	  
	System.out.println("\nProvider Terminal");
	System.out.println("1.) validate a ChocAn member"); 
	System.out.println("2.) bill ChocAn"); 
	System.out.println("3.) request a provider directory"); 
	System.out.println("4.) Quit");
	System.out.print(" Option: ");
	
    int userChoice = sc.nextInt();
    switch(userChoice) {
        case 1:
          validateMember();
          break;
        case 2:
          billChocan();
          break;
        case 3:
          requestDirectory();
          break;
        default:
          System.out.println("Please enter a valid choice...");
          break;
    }
  }
  
  private static void validateMember() {
    System.out.print("Please enter member number: ");
    int memNum = sc.nextInt();
    ValidateMember x = new ValidateMember(memNum);
  }
  
  private static void billChocan() {
    
  }
  
  private static void requestDirectory() {
    
  }

}
