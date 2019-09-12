package Bank;

import java.util.ArrayList;

public class Bank {
    private String bankName;

    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) <0) {
            branches.add(new Branch(branchName));
            return true;
        }
        else {
            return false;
        }
    }

    public String getBankName() {
        return bankName;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addNewCustomer(Customer customer, String branchName) {
        int foundPosition = findBranch(branchName);

        if(foundPosition <0) {
            System.out.println(branchName +", branch was not found.");
            return false;
        }

        int customerPosition = branches.get(foundPosition).findCustomer(customer.getCustomerName());

        if(customerPosition >=0) {
            System.out.println(customer.getCustomerName() +", already exists.");
            return false;
        }

        branches.get(foundPosition).getCustomers().add(customer);
        return true;
    }

    public void showCustomerList() {
        for (int h=0; h < getBranches().size(); h++) {
            System.out.println("Customer List for " +branches.get(h).getBranchName());
            System.out.println("-----------------------------------------------------------------");
            if (branches.get(h).getCustomers().size() == 0) {
                System.out.println("No Customers");
                System.out.println();
                continue;
            }

            for(int i=0; i<branches.get(h).getCustomers().size(); i++) {
                System.out.println(branches.get(h).getCustomers().get(i).getCustomerName());
                System.out.println("------------------------------------");
                System.out.println("Transactions");
                System.out.println("--------------------");

                for(int j=0; j< branches.get(h).getCustomers().get(i).getTransactions().size(); j++) {
                    System.out.println(branches.get(h).getCustomers().get(i).getTransactions().get(j));
                }
                System.out.println();

            }
        }

    }

    public boolean addTransaction(String customerName, String branchName, Double transactionAmount) {
        int foundPosition = findBranch(branchName);

        if(foundPosition <0) {
            System.out.println(branchName +", branch was not found.");
            return false;
        }

        int customerPosition = branches.get(foundPosition).findCustomer(customerName);

        if(customerPosition >=0) {
            branches.get(foundPosition).getCustomers().get(customerPosition).getTransactions().add(transactionAmount);
            return true;
        }
        else {
            System.out.println(customerName +", not found.");
            return false;
        }
    }

    private int findBranch(String branchName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if(branch.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }
}
