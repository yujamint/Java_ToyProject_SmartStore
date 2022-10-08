import exception.CustomerException;

import java.util.Scanner;

public class Main {

    public static void main_menu() {
        System.out.println("1. 고객 관리(고객 정보 추가, 수정, 삭제)");
        System.out.println("2. 고객 리스트");
        System.out.println("3. 고객 분류 기준 설정");
    }

    public static void main(String[] args) throws CustomerException {
        Customer c = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        Customer c4 = new Customer();

        // 일련번호 자동생성 확인
        System.out.println(c.getCustomer_serialNo());
        System.out.println(c2.getCustomer_serialNo());
        System.out.println(c3.getCustomer_serialNo());
        System.out.println(c4.getCustomer_serialNo());

        // 입력 성공 예시
        try {
            c.setCustomer_name("yujamint");
            c.setCustomer_id("abcde12345");
            c.setCustomer_spentTime(35);
            c.setCustomer_totalPayment(100000);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }

        // 입력 실패 예시
        try {
            c.setCustomer_name("jam");
            c.setCustomer_id("abcde12345");
            c.setCustomer_spentTime(15);
            c.setCustomer_totalPayment(-45);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
    }
}
