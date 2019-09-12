package Bank;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int findCustomer(String customerName) {
        for(int i=0; i<this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if(customer.getCustomerName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }
}
