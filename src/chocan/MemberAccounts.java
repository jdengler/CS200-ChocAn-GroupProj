// Author: Namito Yokota

package chocan;

import java.util.ArrayList;
import java.util.Comparator;

public class MemberAccounts {
	
	private String name;
	private int number;	
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private boolean status;
	private ArrayList<ServiceRecord> servicesProvided;
	
	public MemberAccounts () {
		
	}
	
	public MemberAccounts (String name, int number, String address, String city, String state, int zipCode, boolean status, ArrayList<ServiceRecord> servicesProvided ) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.status = status;
		this.servicesProvided = servicesProvided;
	}
	
	public MemberAccounts (String name, int number, String address, String city, String state, int zipCode, boolean status ) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.status = status;
		
	}
	
	public void setServicesProvided(ArrayList<ServiceRecord> servicesProvided) {
		this.servicesProvided = servicesProvided;
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
	
	public void setStatus(boolean status) {
		this.status = status;
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
	
	public boolean getStatus() {
		return status;
	}
	
	public ArrayList<ServiceRecord> getServicesProvided() {
		return servicesProvided;
	}
	
	public void addService(ServiceRecord service) {
		servicesProvided.add(service);
	}	
	
    /*Comparator for sorting the list by Member Name*/
    public static Comparator<MemberAccounts> MemberNameComparator = new Comparator<MemberAccounts>() {

	public int compare(MemberAccounts m1, MemberAccounts m2) {
	   String MemberName1 = m1.getName().toUpperCase();
	   String MemberName2 = m2.getName().toUpperCase();

	   //ascending order
	   return MemberName1.compareTo(MemberName2);
    }};
}
