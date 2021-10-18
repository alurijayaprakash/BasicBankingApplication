import java.util.*;

public class Bank {
    private String name;
    private String branchName;
    private String branchAddress;
    private String ifscCode;
    private long micrCode;
    private CurrentAccount currentAccount;
    ArrayList<Account> listOfBankAccounts;


    public Bank(String accountNumber, String name, String branchName, String contactAddress, String email, String phoneNumber, String branchAddress, String ifscCode, long micrCode) {
        this.name = name;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.ifscCode = ifscCode;
        this.micrCode = micrCode;
        this.currentAccount = new CurrentAccount(accountNumber,branchName, "-", contactAddress, email, phoneNumber, 1000);
        listOfBankAccounts = new ArrayList<Account>();
        listOfBankAccounts.add(currentAccount);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return this.branchAddress;
    }

    public void setBranchAddress(String address) {
        this.branchAddress = address;
    }

    public String getIfscCode() {
        return this.ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public long getMicrCode() {
        return this.micrCode;
    }

    public void setMicrCode(long micrCode) {
        this.micrCode = micrCode;
    }

    public String getAccounts() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < listOfBankAccounts.size(); i++) {
            sb.append(listOfBankAccounts.get(i) + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", branchName='" + getBranchName() + "'" +
            ", address='" + getBranchAddress() + "'" +
            ", ifscCode='" + getIfscCode() + "'" +
            ", micrCode='" + getMicrCode() + "'" +
            ", Accounts=\n'" + getAccounts() + "'" +
            "}";
    }


    public boolean addAccount(Account account){
        listOfBankAccounts.add(account);
        return true;
    }

    public Account searchAccounts(String accountNumber) {
        for (int i = 0; i < listOfBankAccounts.size(); i++) {
            Account account = listOfBankAccounts.get(i);
            // System.out.println("Search A/C NO Func " + accountNumber);
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public boolean debitTransaction(String accountNumber, double amount) throws InvalidAccountNumber, InvalidAmountException, InsufficientFundsException{
        Account account = searchAccounts(accountNumber);
        // System.out.println("Debit Func " + accountNumber);
        if (account == null) {
            throw new InvalidAccountNumber("Invalid Account Number... Please try again...");
        }

        if (account instanceof CheckingAccount) {
            System.out.println(account);
            creditTransaction(this.currentAccount.getAccountNumber(), CheckingAccount.fees);
            return true;
        }

        account.debit(amount);
        System.out.println(account);
        return true;
    }

    public boolean creditTransaction(String accountNumber, double amount)  throws InvalidAccountNumber, InvalidAmountException, InsufficientFundsException{
        Account account = searchAccounts(accountNumber);
        // System.out.println("Credit Func " + accountNumber);
        if (account == null) {
            throw new InvalidAccountNumber("Invalid Account Number... Please try again...");
        }
        if (account instanceof CheckingAccount) {
            account.credit(amount);
            creditTransaction(this.currentAccount.getAccountNumber(), CheckingAccount.fees);
        }
        
        account.credit(amount);

        System.out.println(account);
        return true;
    }

    public void calculateInterest() throws InvalidAmountException {
        for (int i = 0; i < listOfBankAccounts.size(); i++) {
            Account account = listOfBankAccounts.get(i);
            if (account instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) account;
                sa.calculateInterest();
                System.out.println(account);
            }
        }
    }

    public ArrayList<Account> getListOfBankAccounts() {
        return listOfBankAccounts;
    }

    public void showListOfBankAccounts(){
        // System.out.println("Printing Bank Accounts in the Bank");
        for (Account account : listOfBankAccounts){
            System.out.println("Here" + account);
        }
    }

    //Amount Comparator
    public static class AmountComparator implements Comparator<Account>{
        public int compare(Account a1, Account a2){
            return Double.compare(a1.getAmount(), a2.getAmount());
        }   
    }

    //Amount Comparator
    public static class TransactionsComparator implements Comparator<Account>{
        public int compare(Account a1, Account a2){
            return Long.compare(a1.getCountVal(), a2.getCountVal());
        }   
    }
}
