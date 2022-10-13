package group;

public class Groups {
    Group[] groups = new Group[4]; // NONE, GENERAL, VIP, VVIP

    private Groups() {
        groups[0] = new Group(MemberGrade.NONE);
        groups[1] = new Group(MemberGrade.GENERAL);
        groups[2] = new Group(MemberGrade.VIP);
        groups[3] = new Group(MemberGrade.VVIP);
    }

    private static final Groups GROUPS = new Groups(); // 싱글톤 패턴

    public static Groups getInstance() {
        return GROUPS;
    }

    public Group[] getGroups() {
        return groups;
    }
}
