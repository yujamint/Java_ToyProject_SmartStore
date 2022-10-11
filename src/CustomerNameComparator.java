import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {

        String customerName1 = o1.getCustomer_name();
        String customerName2 = o2.getCustomer_name();

        if (customerName1.compareToIgnoreCase(customerName2) == 0)
            return o1.getCustomer_serialNo().compareTo(o2.getCustomer_serialNo());
        else return customerName1.compareToIgnoreCase(customerName2);
    }
}
