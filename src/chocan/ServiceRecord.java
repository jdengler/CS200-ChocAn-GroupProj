// Author: Namito Yokota

package chocan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class ServiceRecord extends Terminal {
	
  private String currentDateTime;
  private String dateOfService;
  private int providerNumber;
  private int memberNumber;
  private int serviceCode;
  private String comments;
  
  public ServiceRecord(){
	  
  }
  
  public ServiceRecord(String currentDateTime, String dateOfService, int providerNumber, int memberNumber,
			int serviceCode, String comments) {
		super();
		this.currentDateTime = currentDateTime;
		this.dateOfService = dateOfService;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.serviceCode = serviceCode;
		this.comments = comments;
	}
  
  public String getCurrentDateTime() {
	return currentDateTime;
}

public void setCurrentDateTime(String currentDateTime) {
	this.currentDateTime = currentDateTime;
}

public String getDateOfService() {
	return dateOfService;
}

public void setDateOfService(String dateOfService) {
	this.dateOfService = dateOfService;
} 
  
public String getProviderName(int providerNumber) throws FileNotFoundException, IOException{
    ArrayList<ProviderAccounts> pa = ReadProviders();
    String name = null; 
    
    for (ProviderAccounts provide : pa) {
        if (provide.getNumber() == providerNumber) {
            name = provide.getName();
        }
    }
    return name;
}
  
  public String getMemberName(int memberNumber) throws FileNotFoundException,IOException{
      ArrayList<MemberAccounts> ma = ReadMember();
      String name = null; 
      
      for (MemberAccounts member : ma) {
          if (member.getNumber() == memberNumber) {
              name = member.getName();
          }
      }
      return name;  
	
  }
  

public int getProviderNumber() {
	return providerNumber;
}


public void setProviderNumber(int providerNumber) {
	this.providerNumber = providerNumber;
}

public int getMemberNumber() {
	return memberNumber;
}

public void setMemberNumber(int memberNumber) {
	this.memberNumber = memberNumber;
}

public int getServiceCode() {
	return serviceCode;
}

public void setServiceCode(int serviceCode) {
	this.serviceCode = serviceCode;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}

/*public ProviderDirectoryEntry getProviderDirectoryInfo(int serviceCode) {
	  ProviderDirectory pd = new ProviderDirectory();
	  return pd.findProviderDirectoryEntry(serviceCode);
  }*/
  
public String getServiceName(int serviceCode) throws FileNotFoundException, IOException{
   ArrayList<ProviderDirectoryEntry>pde = ReadProviderDirectoryEntry();
   String name = null;
   for (ProviderDirectoryEntry provide : pde) {
       if (provide.getServiceCode() == serviceCode) {
           name = provide.getServiceName();
       }
   }
   return name;
}

public double getServiceFee(int serviceCode) throws FileNotFoundException, IOException{
    ArrayList<ProviderDirectoryEntry>pde = ReadProviderDirectoryEntry();
    double fee =0;
    for (ProviderDirectoryEntry provide : pde) {
        if (provide.getServiceCode() == serviceCode) {
            fee = provide.getServiceFee();
        }
    }
    return fee;
 }

/*Comparator for sorting the list by Member Name*/
public static Comparator<ServiceRecord> ServiceDateComparator = new Comparator<ServiceRecord>() {

public int compare(ServiceRecord s1, ServiceRecord s2) {
   
   Date date1 = new Date();
	try {
		date1 = new SimpleDateFormat("MM-dd-yyyy").parse(s1.getDateOfService());
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Date date2 = new Date();
	try {
		date2 = new SimpleDateFormat("MM-dd-yyyy").parse(s2.getDateOfService());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   //ascending order
   return date1.compareTo(date2);
}};

}
