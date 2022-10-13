package group;

public class Group {
    private MemberGrade grade;
    private Parameter param;
    private int customer_num = 0;
    private boolean isInitialized;

    public Group(MemberGrade memberGrade) {
        grade = memberGrade;
        param = new Parameter();
        isInitialized = false;
    }

    /**
     * getter, setter
     */

    public MemberGrade getGrade() {
        return grade;
    }

    public Parameter getParam() {
        return param;
    }

    public int getCustomer_num() {
        return customer_num;
    }

    public void setCustomer_num(int customer_num) {
        this.customer_num = customer_num;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }
}
