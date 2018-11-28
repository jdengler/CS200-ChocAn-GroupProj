package chocan;
import java.awt.BorderLayout;
import javax.swing.*;

import java.util.*;

public class Terminal {
	
	ManagerTerminal manager = new ManagerTerminal();
	ProviderTerminal provider = new ProviderTerminal();
	OperatorTerminal operator = new OperatorTerminal();

  public void main(String[] args) {
	  
	Scanner reader = new Scanner(System.in);
	int option=0;
	  
	System.out.println("ChocAn System");  
	
	while(true) {
		System.out.println("\tMenu");
		System.out.println("1.) Open Manager Terminal"); 
		System.out.println("2.) Open Provider Terminal"); 
		System.out.println("3.) Open Operator Terminal");
		System.out.println("4.) Quit");
		System.out.println("\tOption: ");
		
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
		
		else {
			break;
		}
	}
	
	reader.close();
	
	// GUI
	/*
	//Frame
	JFrame frame = new JFrame("ChocAn System");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,500);
	    
	//Menu bar and components
	JMenuBar menuBar = new JMenuBar();
	JMenu menu1 = new JMenu("Manager");
	JMenu menu2 = new JMenu("Operator");
	JMenu menu3 = new JMenu("Provider");
	menuBar.add(menu1);
	menuBar.add(menu2);
	menuBar.add(menu3);
	    
	JMenuItem submenu11 = new JMenuItem("Generate Summary Report");
	JMenuItem submenu12 = new JMenuItem("Generate Member Report");
	JMenuItem submenu13 = new JMenuItem("Generate Provider Report");
	menu1.add(submenu11);
	menu1.add(submenu12);
	menu1.add(submenu13);
	    
	JMenuItem submenu21 = new JMenuItem("Add Member");
	JMenuItem submenu22 = new JMenuItem("Delete Member");
	JMenuItem submenu23 = new JMenuItem("Update Member");
	JMenuItem submenu24 = new JMenuItem("Add Provider");
	JMenuItem submenu25 = new JMenuItem("Delete Provider");
	JMenuItem submenu26 = new JMenuItem("Update Provider");
	menu2.add(submenu21);
	menu2.add(submenu22);
	menu2.add(submenu23);
	menu2.add(submenu24);
	menu2.add(submenu25);
	menu2.add(submenu26);
	    
	//Bottom Panel
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Text");
	JTextField textField = new JTextField(15);
	JButton enter = new JButton("Enter");
	panel.add(label);
	panel.add(textField);
	panel.add(enter);
	    
	//Text area
	JTextArea textArea = new JTextArea();
	        
	frame.getContentPane().add(BorderLayout.SOUTH, panel);
	frame.getContentPane().add(BorderLayout.NORTH, menuBar);
	frame.getContentPane().add(BorderLayout.CENTER, textArea);
	frame.setVisible(true);
	*/
  }
  
  public void OpenManagerTerminal () {
	  manager.managerMenu();
  }
  
  public void OpenProviderTerminal () {
	  provider.providerMenu();
  }
  
  public void OpenOperatorTerminal () {
	  operator.operatorMenu();
  }

}
