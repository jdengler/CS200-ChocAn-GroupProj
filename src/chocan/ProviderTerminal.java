package chocan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.print.DocFlavor.URL;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class ProviderTerminal {
  public ProviderDirectory pd = new ProviderDirectory();
  
  private static Scanner sc = new Scanner(System.in);
  
  public void menu() {
      
      pd = ReadProviderDirectoryEntry();
	  
	System.out.println("\nProvider Terminal");
	System.out.println("1.) Validate a ChocAn member"); 
	System.out.println("2.) Bill ChocAn"); 
	System.out.println("3.) Request a Provider Directory"); 
	System.out.println("4.) Go back to main terminal");
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
    System.out.print("\nEnter member number: ");
    int memNum = sc.nextInt();
    ValidateMember x = new ValidateMember(memNum);
  }
  
  private static void billChocan() {
    
  }
  
  private static void requestDirectory() {
    
  }
  
  public ProviderDirectory ReadProviderDirectoryEntry(){
      Path ePath = Paths.get("C:/Desktop/providerDirectory.txt");
      
      File eFile = ePath.toFile();
      
      ArrayList<ProviderDirectoryEntry> listPde = new ArrayList<ProviderDirectoryEntry>();
      
      return pd;
  }
}
