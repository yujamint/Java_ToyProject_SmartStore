import java.util.Arrays;

public class SmartStore {
    private Customer[] customers = new Customer[0];

    static int customerNum = 0;

    private int VIP_time = Integer.MAX_VALUE;
    private int VIP_payment = Integer.MAX_VALUE;

    private int VVIP_time = Integer.MAX_VALUE;
    private int VVIP_payment = Integer.MAX_VALUE;

    private static final SmartStore smartStore = new SmartStore();

    private SmartStore() {

    }

    public static SmartStore getInstance() {
        return smartStore;
    }

    public void addCustomer(Customer customer) {
        Customer[] temp = new Customer[++customerNum];

        System.arraycopy(customers, 0, temp, 0, customers.length);
        temp[customerNum-1] = customer;

        customers = temp;
    }

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

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getVIP_time() {
        return VIP_time;
    }

    public void setVIP_time(int VIP_time) {
        this.VIP_time = VIP_time;
    }

    public int getVIP_payment() {
        return VIP_payment;
    }

    public void setVIP_payment(int VIP_payment) {
        this.VIP_payment = VIP_payment;
    }

    public int getVVIP_time() {
        return VVIP_time;
    }

    public void setVVIP_time(int VVIP_time) {
        this.VVIP_time = VVIP_time;
    }

    public int getVVIP_payment() {
        return VVIP_payment;
    }

    public void setVVIP_payment(int VVIP_payment) {
        this.VVIP_payment = VVIP_payment;
    }

    public void setVIP_timeAndPayment(int time, int payment) {
        this.VIP_time = time;
        this.VIP_payment = payment;
    }

    public void setVVIP_timeAndPayment(int time, int payment) {
        this.VVIP_time = time;
        this.VVIP_payment = payment;
    }

    public void setCustomers_memberGrade() {
        for (Customer customer : customers)
            customer.setMemberGrade();
    }
}
