package chocan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Gui extends JFrame{
	
	private static String ENTER = "Enter";
    static JButton enterButton;
    public static JTextArea output;
    public static JTextField input;
    static JFrame frame;
    static JPanel panel;
    public static String testString = "test";
	static Terminal term = new Terminal();
	
	  public static void createFrame()
	  {
		ButtonListener buttonListener = new ButtonListener();  
	    
		//Frame
		frame = new JFrame("ChocAn System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		
		//Terminal Buttons
		JButton manTerminal = new JButton(new AbstractAction("Manager Terminal") {
			@Override
			public void actionPerformed(ActionEvent e) {
		    	try{OpenMTerminal();}
		    	catch(Exception ex){}
		    }
		});
		
		JButton provTerminal = new JButton(new AbstractAction("Provider Terminal") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {OpenPTerminal();}
				catch(Exception ex) {}
			}
		});
		JButton opTerminal = new JButton(new AbstractAction("Operator Terminal") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {OpenOTerminal();}
				catch(Exception ex) {}
			}
		});
		
		//Text area
		panel = makeInputPanel();
	    
	    frame.getContentPane().add(BorderLayout.LINE_START, manTerminal);
	    frame.getContentPane().add(BorderLayout.CENTER, provTerminal);
	    frame.getContentPane().add(BorderLayout.LINE_END, opTerminal);
	    frame.getContentPane().add(BorderLayout.PAGE_END, panel);
	    frame.pack();
	    frame.setLocationByPlatform(true);
	    // Center of screen
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.setResizable(false);
	    input.requestFocus();
	}
  
  public static void main(String[] args) {
	  try
      {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch (Exception ex)
      {
          ex.printStackTrace();
      }
      createFrame();
  }
  
  
  
  public void OpenMTerminal () {
	  JMenuBar menuBar = new JMenuBar();
	  
//		JButton manTerminal = new JButton(new AbstractAction("Manager Terminal") {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//	    	try{OpenMTerminal();}
//	    	catch(Exception ex){}
//	    }
//	});
	  JMenu menu1 = new JMenu(new AbstractAction("Generate Summary Report") {
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 try{ManagerTerminal.printSummaryReport();}
			 catch(Exception ex){}
		 }
	  });

	  
	  JMenu menu2 = new JMenu(new AbstractAction("Generate Member Report") {
		 int number;
		 @Override
		 public void actionPerformed(ActionEvent e) {
			 try{ManagerTerminal.generateMember();}
			 catch(Exception ex){}
		 }
	  });

	  JMenu menu3 = new JMenu("Generate Provider Report");
	  menuBar.add(menu1);
	  menuBar.add(menu2);
	  menuBar.add(menu3);
	  
	  JPanel newPanel = new JPanel();
	  newPanel.add(menuBar);
	  setFrame(newPanel);
  }
  
  public static void OpenPTerminal () throws FileNotFoundException, IOException {
	  Terminal.OpenProviderTerminal();
  }
  
  public static void OpenOTerminal () throws FileNotFoundException, IOException {
	  Terminal.OpenOperatorTerminal();
  }
  
  public static class ButtonListener implements ActionListener
  {
      public void actionPerformed(final ActionEvent ev)
      {
          if (!input.getText().trim().equals(""))
          {
              String cmd = ev.getActionCommand();
              if (ENTER.equals(cmd))
              {
                  output.append(input.getText());
                  if (input.getText().trim().equals(testString)) output.append(" = " + testString);
                  else output.append(" != " + testString);
                  output.append("\n");
              }
          }
          input.setText("");
          input.requestFocus();
      }
  }
  
  public static void setFrame(JPanel panelTemp)
  {    
	  JPanel contentPane = (JPanel) frame.getContentPane();

	  contentPane.removeAll();
	  contentPane.add(BorderLayout.NORTH, panelTemp);
	  contentPane.add(BorderLayout.PAGE_END, makeInputPanel());
	  contentPane.revalidate(); 
	  contentPane.repaint();
  }
  
  public static JPanel makeInputPanel() {
	  	JPanel panel = new JPanel();
	  	output = new JTextArea(15, 50);
	    output.setWrapStyleWord(true);
	    output.setEditable(false);
	    JScrollPane scroller = new JScrollPane(output);
	    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	  
	  
		ButtonListener buttonListener = new ButtonListener(); 

	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setOpaque(true);
		
		JPanel inputpanel = new JPanel();
	    inputpanel.setLayout(new FlowLayout());
	    input = new JTextField(20);
	    enterButton = new JButton("Enter");
	    enterButton.setActionCommand(ENTER);
	    enterButton.addActionListener(buttonListener);

	    input.setActionCommand(ENTER);
	    input.addActionListener(buttonListener);
	    
	    panel.add(scroller);
	    inputpanel.add(input);
	    inputpanel.add(enterButton);
	    panel.add(inputpanel);
	    
	    return panel;
}
}
