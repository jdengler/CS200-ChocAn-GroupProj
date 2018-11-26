package chocan;

import java.util.ArrayList;

public class AccountDatabase {
	
	private ArrayList<ProviderAccounts> providerAccountsList;
	private ArrayList<MemberAccounts> memberAccountsList;
	
	public AccountDatabase () {
		
	}
	
	public AccountDatabase (ArrayList<ProviderAccounts> providers, ArrayList<MemberAccounts> members) {
		this.providerAccountsList = providers;
		this.memberAccountsList = members;
	}
	
	public void AddMember(String name, int number, String address, String city, String state, int zipCode, boolean status) {
		MemberAccounts ma = new MemberAccounts(name, number, address, city, state, zipCode, status);
		memberAccountsList.add(ma);
	}
	
	public void DeleteMember (int number) {
		for (MemberAccounts ma : memberAccountsList) {
			if (ma.getNumber() == number) {
				
			}
		}
	}
	
	public void UpdateMember (String name, int number, String address, String city, String state, int zipCode, boolean status) {
		
	}

}
