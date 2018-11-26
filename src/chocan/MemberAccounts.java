package chocan;

public class MemberAccounts {
	
	private String name;
	private int number;	
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private boolean status;
	
	public MemberAccounts () {
		
	}
	
	public MemberAccounts (String name, int number, String address, String city, String state, int zipCode, boolean status) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.status = status;
	}
}
