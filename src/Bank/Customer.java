package Bank;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactions;


    public Customer(String customerName, Double transaction) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(transaction);
    }

    public static Customer createCustomer(String customerName, Double initialTransaction) {
        return new Customer(customerName, initialTransaction);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
