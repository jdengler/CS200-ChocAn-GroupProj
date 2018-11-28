package chocan;
import java.util.*;


public class BillChocAn {
    
    private String CurrentDate;
    private String DateOfService;
    private int ServiceCode;
    private int ProviderNumber;
    private int MemberNumber;
    private String Comments;
    
    public BillChocAn() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("deprecation")
    public void setCurrentDate() {
        Date current = new Date(); //Get current date and time
        CurrentDate = current.getMonth() +"-"+current.getDate() + "-" + current.getYear() +" "+current.getHours() +":" +current.getMinutes()+":"+current.getSeconds();
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
        
        DateOfService = month + "-" + day +"-" + year;
    }
    
    public void enterServiceCode() {
        ProviderDirectory providerDirectory = new ProviderDirectory();
        Scanner reader = new Scanner(System.in);
        
        while(true) {
            System.out.println("Enter Service Code: ");
            //TODO Enter error check
            ServiceCode = reader.nextInt();
            
            ProviderDirectoryEntry pde = providerDirectory.findProviderDirectoryEntry(ServiceCode);
           
            if(pde == null) { //If invalid service code
                System.out.println("Error: Invalid Service Code");
                break;
            }
            
            System.out.println(pde.getServiceName());
            System.out.println("Is this the correct service? "); //1 = yes 2 = not correct
            int selection = reader.nextInt();
            
            if(selection == 1) {
                break;
            }
        }
        reader.close();
        
    }
    
    public void enterComments() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter comments: ");
        Comments = reader.nextLine();
        
        reader.close();
    }
    
    public void enterProviderNumber() {
        ManageAccounts manage = new ManageAccounts();
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Provider Number: ");
            ProviderNumber = reader.nextInt();
            int valid = manage.searchProvider(ProviderNumber);
            
            if (String.valueOf(ProviderNumber).length() != 9 || valid == 1) {
                System.out.println("Invalid Provider Number");
            }
            else {
                break;
            }
        }
        reader.close();
    }
    
    public void enterMemberNumber() {
        ManageAccounts manage = new ManageAccounts();
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Member Number: ");
            MemberNumber = reader.nextInt();
            int valid = manage.searchMember(MemberNumber);
            
            if (String.valueOf(MemberNumber).length() != 9 || valid == 1 || valid == 2) {
                if (valid == 2) {
                    System.out.println("Member suspended");
                    break;
                }
                else {
                    System.out.println("Invalid Member Number");
                    break;
                }
            }
            else {
                break;
            }
        }
        reader.close();
        
    }
    
    public ServiceRecord makeServiceRecord() {
        ServiceRecord record = new ServiceRecord(CurrentDate,DateOfService,ProviderNumber,MemberNumber,ServiceCode,Comments);
        return record;
    }
    
    

}

