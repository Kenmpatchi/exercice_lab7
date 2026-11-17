package lab;

import java.util.Date;

public class Account {
	private int accountNumber;
	private double balance;
	private String accountType;
	private Customer owner;
	private Date creationDate;

	public Account(int accountNumber, double balance, String accountType, Customer owner) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
		this.owner = owner;
		this.creationDate = new Date();
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void Diposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void Withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
		}
	}

	public void Transfer(double amount, Account account) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			account.Withdraw(amount);
		}
	}

	public String getAccountDetails() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", accountType=" + accountType
				+ "]";
	}
}
