package chocan.UnusedCode;

import java.util.ArrayList;
import java.util.Date;

/*
 *		Josh Engler
 */
public class ValidateMember {
	
	private CardSwipe swipe = new CardSwipe();
	
	private CardSwipe swipeCard() {
		return swipe;
	}
	
	private void enterNumber(int memberNumber) {
		swipe.setMemberNumber(memberNumber);
	}
	
	public ValidateMember() {
		
	}
	
	public ValidateMember(String memberName, int memberNumber) {
		swipe.setMemberNumber(memberNumber);
		swipe.setMemberName(memberName);
	}
	
	public ValidateMember(int memberNumber) {
	  swipe.setMemberNumber(memberNumber);
	  swipe.setMemberName("");
	}
	
	public void main() {
		ManageAccounts a = new ManageAccounts();
		int validated;			//0 = valid, 1 = invalid num, 2 = status suspended
		validated = a.searchMember(swipe.getMemberNumber());
		
		switch(validated) {
		case 0:
			System.out.println("Validated");
			break;
		case 1:
			System.out.println("Invalid Number");
			break;
		case 2:
			System.out.println("Member suspended");
			break;
		}
		
	}
}
