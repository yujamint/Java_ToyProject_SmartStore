import exception.CustomerIDFormatException;
import exception.CustomerNameFormatException;
import exception.CustomerSpentTimeFormatException;
import exception.CustomerTotalPaymentFormatException;

import java.util.regex.Pattern;

public class Customer {
    private final String customer_serialNo; // 자동생성
    private String customer_name; // 3글자 이상
    private String customer_id; // 알파벳 + 숫자 + "_" , 5~12 글자 , 첫 글자는 알파벳
    private int customer_spentTime;
    private int customer_totalPayment;
    private MemberGrade memberGrade;

    static int auto_id = 1;

    public Customer() {
        customer_serialNo = String.format("%04d", auto_id++);
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

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }

}
