package chocan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProviderTerminal {
  
  private static Scanner sc = new Scanner(System.in);
  
  public static void providerMenu() {
    System.out.println("--------Provider Terminal--------\n\n" +
                       "Press (1) to validate a ChocAn member\n" +
                       "Press (2) to bill ChocAn\n" +
                       "Press (3) to request a provider directory");
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
  
  public static void main() {
    providerMenu();
  }

}
