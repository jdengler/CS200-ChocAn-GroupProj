package chocan;
import java.util.*;

public class Entry {
  private String name;
  private String phone;
  private String address;
  private String city;
  private String state;
  private Boolean status;
  private String zip;
  private ArrayList<Services> services;
  
  public Entry(){
	  
  }
  
  public ArrayList<Services> addService(Services s){
	  services.add(s);
	  return services;
  } 

}
