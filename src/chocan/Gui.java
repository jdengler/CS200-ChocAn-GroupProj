package chocan;
import javax.swing.*;
import java.awt.*;

public class Gui {
	
	public static void main(String args[]) {
		
		//Frame
	    JFrame frame = new JFrame("ChocAn System");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500,500);
	    
	    //Menu bar and components
	    JMenuBar menuBar = new JMenuBar();
	    JMenu menu1 = new JMenu("Test 1");
	    JMenu menu2 = new JMenu("Test 2");
	    menuBar.add(menu1);
	    menuBar.add(menu2);
	    JMenuItem submenu11 = new JMenuItem("Option 1");
	    JMenuItem submenu12 = new JMenuItem("Option 2");
	    menu1.add(submenu11);
	    menu1.add(submenu12);
	    
	    //Bottom Panel
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel("Test 3");
	    JTextField textField = new JTextField(15);
	    JButton button1 = new JButton("Button1");
	    JButton button2 = new JButton("Button2");
	    panel.add(label);
	    panel.add(textField);
	    panel.add(button1);
	    panel.add(button2);
	    
	    //Text area
	    JTextArea textArea = new JTextArea();
	    
	    
	    frame.getContentPane().add(BorderLayout.SOUTH, panel);
	    frame.getContentPane().add(BorderLayout.NORTH, menuBar);
	    frame.getContentPane().add(BorderLayout.CENTER, textArea);
	    frame.setVisible(true);
	}
}
