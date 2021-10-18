import java.util.Scanner;
import java.util.*;

/**
 * This file used to test all Savings, Current, Checking Account
 * 
 * @author Jayaprkash Aluri
 */

public class AccountTest {
	

	/**
	 * The main method is used to test this Account class.
	 * @param args the command line arguments. No need to pass any command line
	 * arguments at the time of executing this program.
	 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String newtoken[] = scan.nextLine().split(" ");
		newtoken = newtoken[1].split(",");
		Bank bank = new Bank(newtoken[0],newtoken[1],newtoken[2],newtoken[3],newtoken[4],newtoken[5],newtoken[6],newtoken[7],Long.parseLong(newtoken[8]));
		System.out.println("Bank created and " + bank);
		while (scan.hasNextLine()) {
			String tokens[] = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "savingsaccount":
					tokens = tokens[1].split(",");
					SavingsAccount savingsAC = new SavingsAccount(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Double.parseDouble(tokens[6]));
					System.out.println("Account created and " + savingsAC);
					bank.addAccount(savingsAC);
					break;
				case "currentaccount":
					tokens = tokens[1].split(",");
					CurrentAccount currentAC = new CurrentAccount(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Double.parseDouble(tokens[6]));
					System.out.println("Account created and " + currentAC);
					bank.addAccount(currentAC);
					break;
				case "checkingaccount":
					tokens = tokens[1].split(",");
					CheckingAccount checkAC = new CheckingAccount(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Double.parseDouble(tokens[6]));
					System.out.println("Account created and " + checkAC);
					bank.addAccount(checkAC);
					break;
				case "debit":
					try {
						bank.debitTransaction(tokens[1], Double.parseDouble(tokens[2]));
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case "credit":
					try {
						bank.creditTransaction(tokens[1], Double.parseDouble(tokens[2]));
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case "calculateInterest":
					try {
					bank.calculateInterest();
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case "sortbyamount":
					try {
						System.out.println("----------Sort by Amount----------");
						Collections.sort(bank.getListOfBankAccounts(), new Bank.AmountComparator());
						bank.showListOfBankAccounts();
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				case "nonperformingaccounts":
					try {
						System.out.println("----------List of NON-Performing Accounts----------");
						Collections.sort(bank.getListOfBankAccounts(), new Bank.TransactionsComparator());
						bank.showListOfBankAccounts();
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					break;
				default:
					break;
			}
		}
		scan.close();
		System.out.println("Following are the bank details: \n" + bank);
    }

}