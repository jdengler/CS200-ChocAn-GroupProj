package chocan;
import java.util.Date;

public class ServiceRecord {
	
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
  public String getProviderName() {
	return null;
  }
  
  public String getMemberName() {
	return null; 
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

public ProviderDirectoryEntry getProviderDirectoryInfo(int serviceCode) {
	  ProviderDirectory pd = new ProviderDirectory();
	  return pd.findProviderDirectoryEntry(serviceCode);
  }
  

}
