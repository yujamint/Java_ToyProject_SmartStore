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
        smartStore.setVVIP_timeAndPayment(50, 150000);

        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        Customer c4 = new Customer();


        try {
            c1.setCustomer_name("yujamint");
            c1.setCustomer_id("testId1");
            c1.setCustomer_spentTime(35);
            c1.setCustomer_totalPayment(100000);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }

        try {
            c2.setCustomer_name("jamjam");
            c2.setCustomer_id("testid2");
            c2.setCustomer_spentTime(4);
            c2.setCustomer_totalPayment(35000);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }

        try {
            c3.setCustomer_name("dbwoals");
            c3.setCustomer_id("testId3");
            c3.setCustomer_spentTime(66);
            c3.setCustomer_totalPayment(280000);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }

        try {
            c4.setCustomer_name("woa");
            c4.setCustomer_id("testd4");
            c4.setCustomer_spentTime(81);
            c4.setCustomer_totalPayment(140000);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        smartStore.setCustomers_memberGrade();

        smartStore.printCustomers();
        System.out.println("");

        smartStore.sortByCustomerName(false);
        System.out.println("");

        smartStore.sortByCustomerSpentTIme(false);
        System.out.println("");

        smartStore.sortByCustomerTotalPayment(false);
    }
}
