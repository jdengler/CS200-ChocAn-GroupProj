package chocan;
import java.util.ArrayList;


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
	
	public double getTotalWeeklyFees(){
		double total =0;
		ProviderDirectoryEntry pde = new ProviderDirectoryEntry();
		for(ServiceRecord sr : servicesProvided){			
			pde = sr.getProviderDirectoryInfo(sr.getServiceCode());
			if(pde != null){
				total += pde.getServiceFee();
			}
		}
		
		return total;
	}
	
	public void main() {
		
	}
	
}
