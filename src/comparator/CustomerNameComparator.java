package comparator;

import customer.Customer;

import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
    int sign = 1;

    public CustomerNameComparator(int isAscending) {
        sign *= isAscending;
    }

    @Override
    public int compare(Customer o1, Customer o2) {

        String customerName1 = o1.getCustomer_name();
        String customerName2 = o2.getCustomer_name();

        if (customerName1 == null && customerName2 != null){
            return -1 * sign;
        }
        else if (customerName1 != null && customerName2 == null){
            return 1 * sign;
        }
        else if (customerName1 == null && customerName2 == null) {
            return 0;
        }
        else {
            int result = customerName1.compareToIgnoreCase(customerName2);
            if (result != 0) {
                return result * sign;
            }
        }

        return o1.getCustomer_serialNo().compareToIgnoreCase(o2.getCustomer_serialNo());
    }
}
