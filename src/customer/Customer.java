import exception.CustomerIDFormatException;
import exception.CustomerNameFormatException;
import exception.CustomerSpentTimeFormatException;
import exception.CustomerTotalPaymentFormatException;
import group.Group;
import group.Groups;
import group.MemberGrade;

import java.util.regex.Pattern;

public class Customer {
    private final String customer_serialNo; // 자동생성
    static int auto_id = 1;

    private String customer_name; // 3글자 이상
    private String customer_id; // 알파벳 + 숫자 + "_" , 5~12 글자 , 첫 글자는 알파벳
    private int customer_spentTime;
    private int customer_totalPayment;
    private MemberGrade memberGrade = MemberGrade.NONE;

    private Customers customers = Customers.getInstance();
    private Group[] groups = Groups.getInstance().getGroups();

    public Customer() {
        customer_serialNo = String.format("%04d", auto_id++);
        customers.addCustomer(this);

        int none_num = groups[0].getCustomer_num();
        groups[0].setCustomer_num(none_num + 1);
    }

    public String getCustomer_serialNo() {
        return customer_serialNo;
    } // setter X

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) throws CustomerNameFormatException {
        String pattern = "^[a-zA-Z]{3,}$";
        if (Pattern.matches(pattern, customer_name)) {
            this.customer_name = customer_name;
            System.out.println("회원의 이름이 입력되었습니다.");
        }
        else {
            throw new CustomerNameFormatException("잘못된 형식입니다. 정해진 이름 형식에 맞춰 다시 입력해주세요.");
        }
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) throws CustomerIDFormatException {
        String pattern = "^[a-zA-Z][0-9a-zA-Z_]{4,11}$";
        if (Pattern.matches(pattern, customer_id)) {
            this.customer_id = customer_id;
            System.out.println("회원의 ID가 입력되었습니다.");
        }
        else {
            throw new CustomerIDFormatException("잘못된 형식입니다. 정해진 ID 형식에 맞춰 다시 입력해주세요.");
        }
    }

    public int getCustomer_spentTime() {
        return customer_spentTime;
    }

    public void setCustomer_spentTime(int customer_spentTime) throws CustomerSpentTimeFormatException {
        if (customer_spentTime >= 0) {
            this.customer_spentTime = customer_spentTime;
            System.out.println("회원의 사용시간이 입력되었습니다.");
        }
        else {
            throw new CustomerSpentTimeFormatException("사용시간은 0 이상의 숫자만 입력 가능합니다.");
        }
    }

    public int getCustomer_totalPayment() {
        return customer_totalPayment;
    }

    public void setCustomer_totalPayment(int customer_totalPayment) throws CustomerTotalPaymentFormatException {
        if (customer_totalPayment >= 0) {
            this.customer_totalPayment = customer_totalPayment;
            System.out.println("회원의 결제금액이 입력되었습니다.");
        }
        else {
            throw new CustomerTotalPaymentFormatException("결제금액은 0 이상의 숫자만 입력 가능합니다.");
        }
    }

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public Group findGroup() {
        for (int i = 0; i < 4; i++) {
            if (groups[i].getGrade() == this.memberGrade) return groups[i];
        }
        return null;
    }

    public void setMemberGrade() {
        Group now_group = findGroup();
        now_group.setCustomer_num(now_group.getCustomer_num() - 1);

        int general_time = groups[1].getParam().getSpentTime();
        int general_payment = groups[1].getParam().getTotalPayment();
        int vip_time = groups[2].getParam().getSpentTime();
        int vip_payment = groups[2].getParam().getTotalPayment();
        int vvip_time = groups[3].getParam().getSpentTime();
        int vvip_payment = groups[3].getParam().getTotalPayment();

        if (customer_spentTime >= vvip_time && customer_totalPayment >= vvip_payment) {
            this.memberGrade = MemberGrade.VVIP;
            groups[3].setCustomer_num(groups[3].getCustomer_num() + 1);
        }

        else if (customer_spentTime >= vip_time && customer_totalPayment >= vip_payment) {
            this.memberGrade = MemberGrade.VIP;
            groups[2].setCustomer_num(groups[2].getCustomer_num() + 1);
        }

        else if (customer_spentTime >= general_time && customer_totalPayment >= general_payment) {
            this.memberGrade = MemberGrade.GENERAL;
            groups[1].setCustomer_num(groups[1].getCustomer_num() + 1);
        }

        else {
            this.memberGrade = MemberGrade.NONE;
            groups[0].setCustomer_num(groups[0].getCustomer_num() + 1);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_serialNo='" + customer_serialNo + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", customer_spentTime=" + customer_spentTime +
                ", customer_totalPayment=" + customer_totalPayment +
                ", memberGrade=" + memberGrade +
                '}';
    }
}
