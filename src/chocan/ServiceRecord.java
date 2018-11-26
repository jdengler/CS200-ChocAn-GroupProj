package chocan;
import java.util.Date;

public class ServiceRecord {
	
  private Date date;
  private int providerNumber;
  private int memberNumber;
  private int serviceCode;
  private String comments;
  
  private String getProviderName() {
	return null;
  }
  
  private String getMemberName() {
	return null; 
  }
  
  private /*ProviderDirectoryEntry*/ int getProviderDirectoryInfo(int serviceCode) {
	  return 1;
  }
  
  public ServiceRecord(){
	  
  }
}
