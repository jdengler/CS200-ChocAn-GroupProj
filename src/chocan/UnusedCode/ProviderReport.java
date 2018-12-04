package chocan.UnusedCode;
import chocan.ProviderDirectory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import chocan.ProviderDirectoryEntry;
import chocan.ServiceRecord;


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
	
	public double getTotalWeeklyFees() throws FileNotFoundException, IOException {
		double total =0;
		ProviderDirectoryEntry pde = new ProviderDirectoryEntry();
		for(ServiceRecord sr : servicesProvided){			
			pde = ProviderDirectory.validEntry(sr.getServiceCode());
			if(pde != null){
				total += pde.getServiceFee();
			}
		}
		
		return total;
	}
	
	public void main() {
		
	}
	
}
