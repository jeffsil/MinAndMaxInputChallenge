package Bank;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Jeff Scheirer Bank");

    public static void main(String[] args) {

        boolean quit = false;
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (5 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nExiting...");
                    quit = true;
                    break;

                case 1:
                    addNewBranch();
                    break;

                case 2:
                    addNewCustomerToBranch();
                    break;

                case 3:
                    addTransactionForExistingCustomerForBranch();
                    break;

                case 4:
                    showCustomerList();
                    break;

                case 5:
                    printActions();
                    break;
            }

        }

    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to exit\n" +
                "1  - to add a new branch\n" +
                "2  - to add a customer to that branch with initial transaction\n" +
                "3  - to add a transaction for an existing customer for that branch\n" +
                "4  - to show customer list\n" +
                "5  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    private static void addNewBranch() {
        System.out.println("Enter new branch name: ");
        String branchName = scanner.nextLine();

        if (bank.addNewBranch(branchName)) {
            System.out.println("Branch " +branchName +" has been added");
        } else {
            System.out.println("Branch " +branchName +" already exists");
        }
    }

    private static void addNewCustomerToBranch() {
        System.out.println("Enter branch name for new customer: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter name for new customer: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial transaction amount: ");
        Double transactionAmount = scanner.nextDouble();

        Customer newCustomer = Customer.createCustomer(customerName, transactionAmount);
        bank.addNewCustomer(newCustomer, branchName);
    }

    private static void showCustomerList() {
        bank.showCustomerList();
    }

    private static void addTransactionForExistingCustomerForBranch() {
        System.out.println("Enter branch name for new customer: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter name for new customer: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction amount: ");
        Double transactionAmount = scanner.nextDouble();

        bank.addTransaction(customerName, branchName, transactionAmount);
    }
}
