package chocan;
import java.util.ArrayList;
import java.util.Date;
public class ProviderReport {
	
	private ArrayList<ServiceRecord> servicesProvided;
	
	public ProviderReport(){
		
	}	
	
	public ProviderReport(ArrayList<ServiceRecord> servicesProvided){
		this.servicesProvided = servicesProvided;
	}

	public ArrayList<ServiceRecord> getServicesProvided() {
		return servicesProvided;
	}

	public void setServicesProvided(ArrayList<ServiceRecord> servicesProvided) {
		this.servicesProvided = servicesProvided;
	}

	
	public int getTotalMemberConsultations(){
		return servicesProvided.size();
	}
	
	
	
	
}
