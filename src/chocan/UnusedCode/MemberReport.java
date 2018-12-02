package chocan.UnusedCode;
import java.util.Date;

import chocan.ServiceRecord;

import java.util.ArrayList;

public class MemberReport {

	private ArrayList<ServiceRecord> servicesProvided;
	
	public MemberReport(ArrayList<ServiceRecord> servicesProvided) {
	  this.servicesProvided = servicesProvided;
	}
	
	public ArrayList<ServiceRecord> getServicesProvided() {
	  return this.servicesProvided;
	}
	
	public void setServicesProvided(ArrayList<ServiceRecord> servicesProvided) {
	  this.servicesProvided = servicesProvided;
	}
	
	
}
