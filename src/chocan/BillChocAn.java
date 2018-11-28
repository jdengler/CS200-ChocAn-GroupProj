package chocan;
import java.util.*;


public class BillChocAn {

    public void main(String[] args) {
       //setCurrentDate();
       setDateOfService();
    }
    
    private ServiceRecord billService = new ServiceRecord();
    
    public BillChocAn() {
        // TODO Auto-generated constructor stub
    }
    
    public void setCurrentDate() {
        Date current = new Date(); //Get current date and time
        
        billService.setCurrentDateTime(current);
    }
    
    public void setDateOfService() {
        Scanner reader = new Scanner(System.in); 
        System.out.print("Enter Month: ");
        int month = reader.nextInt();
        System.out.print("Enter Day: ");
        int day = reader.nextInt();
        System.out.print("Enter Year: ");
        int year = reader.nextInt();
        reader.close();
        
        @SuppressWarnings("deprecation")
        Date date = new Date(year,month - 1, day);
        
        System.out.println("Date: " + date);
        
        //billService.setDateOfService(date);
    }
    
    public void enterComments() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter comments: ");
        String comments = reader.nextLine();
        billService.setComments(comments);
        reader.close();
    }
    
    public void enterServiceCode() {
        
        
        
        
    }

}
