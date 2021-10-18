/**
 * 
 * The Account class performs the basic operations such as deposit the amount 
 * (credit) and withdraw the amount (debit) to a particular account.
 * 
 * @author Jayapraaksh Aluri
 * 
 * @version 1.0
 */

public abstract class Account implements AccountInterface {

	/**
	 * The attributes of this Account class.
	 */
	private String accountNumber;
	private String accountHolderName;
	private String dateOfBirth;
	private String contactAddress;
	private String email;
	private String phoneNumber;
	private double amount;
	public String account_type;
	private long countVal;
	

	/**
	 * The following is a constructor that sets the amount to the attribute amount
	 * of the class Account.
	 * 
	 * @param amount
	 */
	public Account(double amount) {
		this.amount = amount;
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
	public Account(String accountNumber, String accountHolderName,
			String dateOfBirth, String contactAddress,
			String email, String phoneNumber, double amount) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.dateOfBirth = dateOfBirth;
		this.contactAddress = contactAddress;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
		this.countVal = 1;
	}

	public abstract boolean debit (double amount) throws InsufficientFundsException, 
    InvalidAmountException;
    public abstract boolean credit (double amount) throws InvalidAmountException;

	

	/**
	 * This method returns the String version of the object.
	 * 
	 * @return the String version of this class object in the following format
	 * "balance in your account is: <Amount>"
	 */
	public String toString() {
		return  "Account Number: " + this.accountNumber + " and balance in your account is: "+ this.amount;
	}


	/**
	 * This method returns the balance amount from this Account.
	 * @return the amount from this Account object.
	 */
	public double getAmount() {
		return this.amount;
	}

    /**
     * @return String return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return String return the accountHolderName
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * @param accountHolderName the accountHolderName to set
     */
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    /**
     * @return String return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return String return the contactAddress
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * @param contactAddress the contactAddress to set
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

	public long getCountVal() {
		return countVal;
	}

	public void setCountVal(long countVal) {
		this.countVal = countVal;
	}
}
