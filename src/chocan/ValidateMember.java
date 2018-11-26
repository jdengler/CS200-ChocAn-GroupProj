package chocan;

import java.util.ArrayList;
import java.util.Date;

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
	
	public ValidateMember(int memberNumber) {
		
	}
}
