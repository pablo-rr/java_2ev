package robloxclanmanagementhelper;

public class Member {
    private String memberName;
    private String memberRank;
    private boolean memberActive;
    private int memberScore;
    private int memberWarns;
    
    public Member(String name, String rank, boolean active, int score, int warns){
        memberName = name;
        memberRank = rank;
        memberActive = active;
        memberScore = score;
        memberWarns = warns;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(String memberRank) {
        this.memberRank = memberRank;
    }

    public boolean isMemberActive() {
        return memberActive;
    }

    public void setMemberActive(boolean memberActive) {
        this.memberActive = memberActive;
    }

    public int getMemberScore() {
        return memberScore;
    }

    public void setMemberScore(int memberScore) {
        this.memberScore = memberScore;
    }

    public int getMemberWarns() {
        return memberWarns;
    }

    public void addMemberWarns() {
        this.memberWarns++;
    }
    
    public void removeMemberWarns() {
        this.memberWarns--;
    }
    
}
