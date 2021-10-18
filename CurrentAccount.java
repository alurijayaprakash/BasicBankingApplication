import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * This file represents CurrentAccount
 *  The CurrentAccount class performs the basic operations such as deposit the amount 
 * (credit) and withdraw the amount (debit) to a particular account. it has overdraft fecility
 * 
 * @author Jayaprkash Aluri
 * @version 1.1
 */
public class CurrentAccount extends Account {
	private static double overdraftBalance = 10000.0;
	public CurrentAccount(double amount){
		super(amount);
	}
	
	
	/**
	 * The following constructor sets the attributes of the Accunt
	 * to the values that are sent as parameters.
	 * @param accountNumber sets the accooutNumber attribute based on accountNumber.
	 * @param accountHolderName sets the accountHolderName attribute based on accountHolderName.
	 * @param dateOfBirth sets the date of birth of the account holder based on the dateOfBirth parameter.
	 * @param email sets the email attribute
	 * @param phoneNumber sets the phoneNumber attribute
	 * @param amount the initial amount to be set based on the parameter.
	 */
	public CurrentAccount(String accountNumber, String accountHolderName,
			String dateOfBirth, String contactAddress,
			String email, String phoneNumber, double amount) {
		super(accountNumber, accountHolderName, dateOfBirth, contactAddress, email, phoneNumber, amount);
	}

	/**
	 * Credit the amount to this Account.
	 * 
	 * @param amount to credit to this Account.
	 * 
	 * @return true on successfully the amount is credited to this Account.
	 * 
	 * @exception throw an exception InvalidAmountException if the amount 
	 * (parameter) is <= 0 with a message "Amount can't be negative or 0.".
	 */
    
	// @Override
	public boolean credit(double amount) throws InvalidAmountException {
		if (amount <= 0){
			throw new InvalidAmountException("Amount can't be negative or 0.");
        }
		setAmount(getAmount() + amount);
		this.setCountVal(this.getCountVal() + 1);
        return true;
	}
    
    /**
	 * This method performs to debit the amount on this Account.
	 * 
	 * @param amount to debit
	 * 
	 * @return true on successfully debited the amount.
	 * 
	 * @exception throw an exception called InsufficientFundsException if the
	 * amount in this Account is less than the amount to be debited with a message
	 * "Insufficient funds to withdraw the amount."
	 * 
	 * @exception throw an exception called InvalidAmountException if the amount 
	 * is <= 0 with a message "Amount can't be negative or 0.".
	 * 
	 * The above two exceptions are user defined exceptions. Define the sepaeate 
	 * classes for those exceptions in separate files.
	 */

	// @Override
	public boolean debit(double amount) throws InsufficientFundsException,InvalidAmountException {
		if (getAmount() + overdraftBalance < amount){
			throw new InsufficientFundsException("Insufficient funds to withdraw the amount.");
		}
		if (amount <= 0){
            throw new InvalidAmountException("Amount can't be negative or 0.");
        }
		setAmount(getAmount() - amount);
		this.setCountVal(this.getCountVal() + 1);
        return true;
	}

	/**
	 * This method returns the String version of the object.
	 * 
	 * @return the String version of this class object in the following format
	 * "balance in your Current account is:: <Amount>"
	 */
	
	// @Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#0.00");
		return "Account Number: " + this.getAccountNumber() + " balance in your Current account is: " + f.format(this.getAmount());
	}

	/**
	 * The main method is used to test this CurrentAccount class.
	 * 
	 * @param args the command line arguments. No need to pass any command line 
	 * arguments at the time of executing this program.
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		CurrentAccount account = new CurrentAccount(0.0);

		while (scan.hasNextLine()) {
			String tokens[] = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "currentaccount":
					tokens = tokens[1].split(",");
					if (tokens.length == 1)
						account = new CurrentAccount(Double.parseDouble(tokens[1]));
					else {
						account = new CurrentAccount(
							tokens[0], tokens[1], tokens[2], tokens[3], tokens[5],
							tokens[5], Double.parseDouble(tokens[6]));
					}
					System.out.println("Account created and " + account);
					break;
				case "debit":
					try {
						boolean flag = account.debit(Double.parseDouble(tokens[1]));
						if (flag)
							System.out.println("After debit, " + account);
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case "credit":
					try {
						boolean flag = account.credit(Double.parseDouble(tokens[1]));
						if (flag)
							System.out.println("After credit, " + account);
					} catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				default:
					break;
			}
		}
		scan.close();
	}

}
