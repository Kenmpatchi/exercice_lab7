package lab;

import java.util.ArrayList;

public class Customer {
	private int customerId;
	private String name;
	private String phoneNumber;
	private String email;
	private ArrayList<Account> accounts;

	public Customer(int customerId, String name, String phoneNumber, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		accounts = new ArrayList<Account>();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public Account OpenAccount(int accountId, String accountType, double amount, Customer customer) {
		Account account = new Account(accountId, amount, accountType, customer);
		accounts.add(account);
		return account;
	}

	public void CloseAccount(Account account) {
		if (account.getBalance() == 0 && accounts.contains(account)) {
			accounts.remove(account);
		}
	}

	public void DepositMoney(double amount, Account account) {
		if (accounts.contains(account)) {
			account.Diposit(amount);
		}
	}

	public void WithdrawMoney(double amount, Account account) {
		if (accounts.contains(account)) {
			account.Withdraw(amount);
		}
	}

	public void TransferMoney(Account account1, Account account2, double amount) {
		if (accounts.contains(account1) && accounts.contains(account2)) {
			account1.Transfer(amount, account2);
			account2.Withdraw(amount);
		}
	}

	public void ViewAccounts() {
		for (Account account : accounts) {
			System.out.println(account.getAccountDetails());
		}
	}

}
