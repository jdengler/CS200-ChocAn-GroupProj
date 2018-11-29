package chocan;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


import java.util.*;

public class Terminal {

  static ManageAccounts ma = new ManageAccounts(); 
  public static void main(String[] args) throws FileNotFoundException, IOException {
	  
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
			OpenManagerTerminal();
		}
		
		else if (option == 2) { // provider terminal
			OpenProviderTerminal();
		}
		
		else if (option == 3) { // operator terminal
			OpenOperatorTerminal();
		}
	}
	
	System.out.println("\nEnd");
	
	reader.close();
  }
  
  public static void OpenManagerTerminal () {
	  ManagerTerminal.menu();
  }
  
  public static void OpenProviderTerminal () {
	  ProviderTerminal.menu();
  }
  

  public static void OpenOperatorTerminal () throws FileNotFoundException, IOException {
	  OperatorTerminal ot = new OperatorTerminal();
	  ot.operaterMenu();
  }


}
