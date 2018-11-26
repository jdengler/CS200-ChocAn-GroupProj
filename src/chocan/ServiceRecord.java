package chocan;
import java.util.Date;

public class ServiceRecord {
	
  private Date currentDateTime;
  private Date dateOfService;
  private int providerNumber;
  private int memberNumber;
  private int serviceCode;
  private String comments;
  
  public ServiceRecord(){
	  
  }
  
  public ServiceRecord(Date currentDateTime, Date dateOfService, int providerNumber, int memberNumber,
			int serviceCode, String comments) {
		super();
		this.currentDateTime = currentDateTime;
		this.dateOfService = dateOfService;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.serviceCode = serviceCode;
		this.comments = comments;
	}
  
  public Date getCurrentDateTime() {
	return currentDateTime;
}

public void setCurrentDateTime(Date currentDateTime) {
	this.currentDateTime = currentDateTime;
}

public Date getDateOfService() {
	return dateOfService;
}

public void setDateOfService(Date dateOfService) {
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
