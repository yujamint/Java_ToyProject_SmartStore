package menu;

import customer.Customer;
import exception.CustomerException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerMenu extends Menu {

    public CustomerMenu() { }

    // CustomerMenu 메인
    public void displayCustomerMenu() {
        while (true) {
            System.out.println("");
            System.out.println("==============================");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 정보 열람");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 돌아가기");
            System.out.println("==============================");

            int menuSelect = menuSelect();
            System.out.println();

            if (menuSelect == 1) {
                addCustomer();
            } else if (menuSelect == 2) {
                printCustomerList();
            } else if (menuSelect == 3) {
                editCustomerInformation();
            } else if (menuSelect == 4) {
                deleteCustomer();
            } else if (menuSelect == 5) {
                return;
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.\n");
            }
        }
    }

    public void addCustomer() { // CustomerMenu - 1번 : 회원 추가
        int num = numToAdd();

        for (int i = 0; i < num; i++) {
            System.out.print("========회원 " + (i + 1) + " 정보입력=========");
            Customer customer = new Customer();
            selectInformation(customer);
        }
    }

    public void printCustomerList() { // CustomerMenu - 2번 : 회원 정보 출력
        Customer[] list = customers.getCustomers();

        System.out.println("==========회원 정보===========");
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + "번 회원 => " + list[i]);
        }
    }

    public void editCustomerInformation() { // CustomerMenu - 3번 : 회원 정보 수정
        printCustomerList();
        Customer customer = selectCustomer();
        selectInformation(customer);
    }

    public void deleteCustomer() { // CustomerMenu - 4번 : 회원 삭제
        printCustomerList();
        Customer customer = selectCustomer();

        customers.removeCustomer(customer);

        System.out.println("선택한 회원이 삭제되었습니다.\n");
        printCustomerList();
    }

    public Customer selectCustomer() {
        Customer[] list = customers.getCustomers();
        System.out.print("회원의 번호를 입력하세요. (1~" + list.length + ") : ");
        int input = sc.nextInt();
        return list[input - 1];
    }

    public void selectInformation(Customer customer) {
        while (true) {
            System.out.println("");
            System.out.println("==============================");
            System.out.println("1. 이름");
            System.out.println("2. ID");
            System.out.println("3. 이용 시간");
            System.out.println("4. 총 결제 금액");
            System.out.println("5. 돌아가기");
            System.out.println("==============================");

            int input = menuSelect();
            System.out.println();

            if (input == 1) { // 이름
                while (true) {
                    try {
                        editCustomerName(customer);
                        break;
                    } catch (CustomerException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input == 2) { // ID
                while (true) {
                    try {
                        editCustomerID(customer);
                        break;
                    } catch (CustomerException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input == 3) { // 이용 시간
                while (true) {
                    try {
                        editCustomerSpentTime(customer);
                        customers.setCustomers_memberGrade();
                        break;
                    } catch (InputMismatchException ime) {
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다. 정수만 입력 가능합니다.\n");
                    } catch (CustomerException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input == 4) { // 결제 금액
                while (true) {
                    try {
                        editCustomerTotalPayment(customer);
                        customers.setCustomers_memberGrade();
                        break;
                    } catch (InputMismatchException ime) {
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다. 정수만 입력 가능합니다.\n");
                    } catch (CustomerException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (input == 5) {
                return;
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.\n");
            }
        }
    }

    public int numToAdd() {
        System.out.println("** \'-1\'을 입력하면 메뉴로 되돌아갑니다. **");
        System.out.print("고객을 몇 명 추가하시겠습니까? ");
        int input = -1;
        try {
            input = sc.nextInt();
        } catch (InputMismatchException ime) {
            sc = new Scanner(System.in);
            System.out.println("잘못된 값을 입력했습니다. 정수만 입력 가능합니다.\n");
        }
        return input;
    }

    public void editCustomerName(Customer customer) throws CustomerException {
        System.out.print("회원의 이름을 입력하세요 (알파벳 3글자 이상) : ");
        String name = sc.next();
        customer.setCustomer_name(name);
    }

    public void editCustomerID(Customer customer) throws CustomerException {
        System.out.print("회원의 ID를 입력하세요 (알파벳,숫자,\'_\' 사용 가능 / 5~12글자 / 알파벳으로 시작) : ");
        String id = sc.next();
        customer.setCustomer_id(id);
    }

    public void editCustomerSpentTime(Customer customer) throws CustomerException, InputMismatchException {
        System.out.print("회원의 이용 시간을 입력하세요 : ");
        int spentTime = sc.nextInt();
        customer.setCustomer_spentTime(spentTime);
    }

    public void editCustomerTotalPayment(Customer customer) throws CustomerException, InputMismatchException {
        System.out.print("회원의 총 결제 금액을 입력하세요 : ");
        int totalPayment = sc.nextInt();
        customer.setCustomer_totalPayment(totalPayment);
    }
}
