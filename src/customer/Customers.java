import group.Group;
import group.Groups;

import java.util.Arrays;

public class Customers {
    private Customer[] customers = new Customer[0];

    static int customerNum = 0;
    Group[] groups = Groups.getInstance().getGroups();

    private static final Customers CUSTOMERS = new Customers();

    private Customers() {

    }

    public static Customers getInstance() {
        return CUSTOMERS;
    }

    /**
     * 고객 추가,삭제
     */

    // 고객 추가
    public void addCustomer(Customer customer) {
        Customer[] temp = new Customer[++customerNum];

        System.arraycopy(customers, 0, temp, 0, customers.length);
        temp[customerNum-1] = customer;

        customers = temp;
    }

    // 고객 삭제
    public void removeCustomer(Customer customer) {
        int removeIdx = 0;
        for (int i = 0; i < customerNum; i++) {
            if (customers[i].equals(customer)) {
                removeIdx = i;
                break;
            }
        }

        Customer[] temp = new Customer[--customerNum];
        System.arraycopy(customers, 0, temp, 0, removeIdx);
        System.arraycopy(customers, removeIdx + 1, temp, removeIdx, customers.length - removeIdx - 1);
        customers = temp;

        customer = null; // 객체 삭제
    }

    /**
     * 고객 목록 정렬, 출력
     */

    // 이름순 정렬
    public void sortByCustomerName(boolean isAscending) {
        Customer[] temp = new Customer[customerNum];
        System.arraycopy(customers, 0, temp, 0, customerNum);

        Arrays.sort(temp, new CustomerNameComparator(isAscending));
        printCustomerSummary(temp);
    }

    // 총 이용시간순 정렬
    public void sortByCustomerSpentTIme(boolean isAscending) {
        Customer[] temp = new Customer[customerNum];
        System.arraycopy(customers, 0, temp, 0, customerNum);

        Arrays.sort(temp, new CustomerSpentTimeComparator(isAscending));
        printCustomerSummary(temp);
    }

    // 총 결제금액순 정렬
    public void sortByCustomerTotalPayment(boolean isAscending) {
        Customer[] temp = new Customer[customerNum];
        System.arraycopy(customers, 0, temp, 0, customerNum);

        Arrays.sort(temp, new CustomerTotalPaymentComparator(isAscending));
        printCustomerSummary(temp);
    }

    // 고객 목록 출력
    public void printCustomers() {
        for (Customer c : customers) System.out.println(c);
    }

    public void printCustomerSummary(Customer[] customers) {
        for (Group group : groups) {
            String label = group.getGrade().getLabel();
            System.out.println("==============================");
            System.out.println(label + " 그룹 : " + group.getCustomer_num() + "명");
            System.out.println("[조건] " + group.getParam());
            for (Customer customer : customers) {
                if (customer.getMemberGrade() == group.getGrade()) System.out.println(customer);
            }
            System.out.println("");
        }
    }

    /**
     * getter, setter
     */

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void setCustomers_memberGrade() {
        for (Customer customer : customers)
            customer.setMemberGrade();
    }
}
