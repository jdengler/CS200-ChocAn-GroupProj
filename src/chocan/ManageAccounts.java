package chocan;

import java.util.ArrayList;

public class ManageAccounts {
	
	private ArrayList<ProviderAccounts> providerAccountsList;
	private ArrayList<MemberAccounts> memberAccountsList;
	
	public ManageAccounts () {
		
	}
	
	public ManageAccounts (ArrayList<ProviderAccounts> providers, ArrayList<MemberAccounts> members) {
		this.providerAccountsList = providers;
		this.memberAccountsList = members;
	}
	
	public void addMember(String name, int number, String address, String city, String state, int zipCode, boolean status) {
		MemberAccounts ma = new MemberAccounts(name, number, address, city, state, zipCode, status);
		memberAccountsList.add(ma);
	}
	
	public void deleteMember (int number) {
		int index=0;
		for (MemberAccounts ma : memberAccountsList) {
			index++;
			if (ma.getNumber() == number) {
				memberAccountsList.remove(index);
			}
		}
	}
	
	public void updateMember (String name, int number, String address, String city, String state, int zipCode, boolean status) {
		for (MemberAccounts ma : memberAccountsList) {
			if (ma.getNumber() == number) {
				ma.setName(name);
				ma.setNumber(number);
				ma.setAddress(address);
				ma.setCity(city);
				ma.setState(state);
				ma.setZipCode(zipCode);
				ma.setStatus(status);
			}
		}
	}
	
	public void addProvider(String name, int number, String address, String city, String state, int zipCode, boolean status) {
		ProviderAccounts ma = new ProviderAccounts(name, number, address, city, state, zipCode, status);
		providerAccountsList.add(ma);
	}
	
	public void deleteProvider(int number) {
		int index=0;
		for (ProviderAccounts ma : providerAccountsList) {
			index++;
			if (ma.getNumber() == number) {
				providerAccountsList.remove(index);
			}
		}
	}
	
	public void updateProvider (String name, int number, String address, String city, String state, int zipCode, boolean status) {
		for (ProviderAccounts ma : providerAccountsList) {
			if (ma.getNumber() == number) {
				ma.setName(name);
				ma.setNumber(number);
				ma.setAddress(address);
				ma.setCity(city);
				ma.setState(state);
				ma.setZipCode(zipCode);
				ma.setStatus(status);
			}
		}
	}

}
