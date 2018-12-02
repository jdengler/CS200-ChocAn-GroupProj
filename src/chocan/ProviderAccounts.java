package chocan;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ProviderAccounts {
	private String name;
	private int number;	
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private ArrayList<ServiceRecord> servicesProvided;
	
	public ProviderAccounts () {
		
	}
	
	public ProviderAccounts (String name, int number, String address, String city, String state, int zipCode) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public int getNumberServices() {
	    return servicesProvided.size();
	}
	
	public double getTotalFees(ArrayList<ServiceRecord> services) throws FileNotFoundException,IOException{
	    double fee = 0;
	    for(ServiceRecord se : services) {
	        fee = fee + se.getServiceFee(se.getServiceCode());
	    }
	    return fee;
	}
	
	public ArrayList<ServiceRecord> getServicesProvided() {
		return servicesProvided;
	}
	
	public void addService(ServiceRecord service){
		servicesProvided.add(service);
	}
	
	public void setServicesProvided(ArrayList<ServiceRecord> servicesProvided) {
        this.servicesProvided = servicesProvided;
    }
}
