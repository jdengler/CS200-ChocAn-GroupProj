package chocan.UnusedCode;

public class CardSwipe {
    
    private String memberName;
    private int memberNumber;
    
    public CardSwipe() {
        
    }
    
    public CardSwipe(String memberName, int memberNumber) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
    }

    public String getMemberName() {
        return memberName;
    }
    
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    
    public int getMemberNumber() {
        return memberNumber;
    }
    
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
    
}