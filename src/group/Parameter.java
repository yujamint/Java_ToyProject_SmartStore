package group;


import exception.LessThanZeroException;

public class Parameter {
    private int spentTime;
    private int totalPayment;

    /**
     * Constructor
     */

    public Parameter() {

    }

    public Parameter(int spentTime, int totalPayment) {
        this.spentTime = spentTime;
        this.totalPayment = totalPayment;
    }

    /**
     * getter, setter, toString()
     */

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) throws LessThanZeroException{
        if (spentTime >= 0) {
            this.spentTime = spentTime;
            System.out.println("최소 이용 시간이 입력되었습니다.");
        }
        else throw new LessThanZeroException("잘못된 값을 입력했습니다. 0 이상의 정수를 입력해주세요.\n");
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) throws LessThanZeroException{
        if (totalPayment >= 0) {
            this.totalPayment = totalPayment;
            System.out.println("최소 이용 시간이 입력되었습니다.");
        }
        else throw new LessThanZeroException("잘못된 값을 입력했습니다. 0 이상의 정수를 입력해주세요.\n");
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "spentTime=" + spentTime +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
