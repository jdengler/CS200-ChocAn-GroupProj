package chocan;

public class ManageMember {
	
	public void AddMember(String name, int number, String address, String city, String state, int zipCode, boolean status) {
		MemberAccounts ma = new MemberAccounts(name, number, address, city, state, zipCode, status);
	}
	
	public void DeleteMember(String name) {
		
	}
	
	public void UpdateMember() {
		
	}

}
