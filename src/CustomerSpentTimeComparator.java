import java.util.Comparator;

public class CustomerSpentTimeComparator implements Comparator<Customer> {
    int sign = 1;

    public CustomerSpentTimeComparator(boolean isAscending) {
        if (!isAscending) sign = -1;
    }

    @Override
    public int compare(Customer o1, Customer o2) {

        int customerTime1 = o1.getCustomer_spentTime();
        int customerTime2 = o2.getCustomer_spentTime();

        if (customerTime1 == customerTime2)
            return o1.getCustomer_serialNo().compareTo(o2.getCustomer_serialNo());
        else return sign * (customerTime1 - customerTime2);
    }
}
