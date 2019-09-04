public class BankAccount {

    private String accountNumber;
    private int balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this("123", 100);
    }

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(int amount) {
        balance+=amount;
    }

    public void withdrawFunds(int amount) {
        if ((balance - amount) >= 0) {
            balance -= amount;
        }
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("1", 80);

        System.out.println("acct number is " +ba.getAccountNumber());
        System.out.println("bal is " +ba.getBalance());
        ba.depositFunds(1000);
        System.out.println("new balance is " +ba.getBalance());
        ba.withdrawFunds(20);
        System.out.println("new blance is " +ba.getBalance());
        ba.withdrawFunds(1000);
        System.out.println("new balance is " +ba.getBalance());
    }

}
