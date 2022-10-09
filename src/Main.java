import exception.CustomerException;

import java.util.Scanner;

public class Main {

    public static void mainMenu() {
        System.out.println("1. 고객 관리(고객 정보 추가, 수정, 삭제)");
        System.out.println("2. 고객 리스트");
        System.out.println("3. 고객 분류 기준 설정");
    }

    public static void main(String[] args) throws CustomerException {
        SmartStore smartStore = SmartStore.getInstance();
        smartStore.setVIP_timeAndPayment(20, 50000);

        Customer c = new Customer();
        System.out.println("객체 1 추가");

        for (Customer cs : smartStore.getCustomers())
            System.out.println(cs);
        System.out.println("");

        Customer c2 = new Customer();
        Customer c3 = new Customer();
        System.out.println("객체 2,3 추가");

        for (Customer cs : smartStore.getCustomers())
            System.out.println(cs);
        System.out.println("");

        smartStore.removeCustomer(c2);
        System.out.println("객체 2 삭제");

        for (Customer cs : smartStore.getCustomers())
            System.out.println(cs);
        System.out.println("");

        try {
            c.setCustomer_name("yujamint");
            c.setCustomer_id("abcde12345");
            c.setCustomer_spentTime(35);
            c.setCustomer_totalPayment(100000);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }

        for (Customer cs : smartStore.getCustomers())
            System.out.println(cs);
        System.out.println("");

        smartStore.setCustomers_memberGrade();

        for (Customer cs : smartStore.getCustomers())
            System.out.println(cs);
        System.out.println("");
    }
}
