package chocan.UnusedCode;

import java.util.ArrayList;

import chocan.ServiceRecord;

public class SummaryReport {
    private ArrayList<ServiceRecord> servicesProvided;
    
	public SummaryReport() {
		// TODO Auto-generated constructor stub
	}

	public SummaryReport(ArrayList<ServiceRecord> servicesProvided){
        this.servicesProvided = servicesProvided;
    }

    public ArrayList<ServiceRecord> getServicesProvided() {
        return servicesProvided;
    }
    
}
