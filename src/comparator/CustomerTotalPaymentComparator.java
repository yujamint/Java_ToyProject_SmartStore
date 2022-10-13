import customer.Customer;

import java.util.Comparator;

public class CustomerTotalPaymentComparator implements Comparator<Customer> {
    int sign = 1;

    public CustomerTotalPaymentComparator(boolean isAscending) {
        if (!isAscending) sign = -1;
    }

    @Override
    public int compare(Customer o1, Customer o2) {

        int customerPayment1 = o1.getCustomer_totalPayment();
        int customerPayment2 = o2.getCustomer_totalPayment();

        if (customerPayment1 == customerPayment2)
            return o1.getCustomer_serialNo().compareTo(o2.getCustomer_serialNo());
        else return sign * (customerPayment1 - customerPayment2);
    }
}
