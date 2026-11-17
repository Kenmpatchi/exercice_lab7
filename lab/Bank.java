package lab;

import java.util.ArrayList;

public class Bank {
	private String BankName;
	private ArrayList<Customer> customers;
	private ArrayList<Account> accounts;

	public Bank(String bankName) {
		super();
		BankName = bankName;
		this.customers = new ArrayList<Customer>();
		this.accounts = new ArrayList<Account>();
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public ArrayList<Customer> getcustomers() {
		return customers;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public Customer CreateCustomer(String name, String phoneNumber, String email) {
		int customerId = 0;
		if (!customers.isEmpty()) {
			customerId = accounts.getLast().getAccountNumber() + 1;
		}
		Customer customer = new Customer(customerId, name, phoneNumber, email);
		customers.add(customer);
		return customer;
	}

	public void DeleteCustomer(Customer customer) {
		if (customers.contains(customer)) {
			customers.remove(customer);
			for (Account account : customer.getAccounts()) {
				accounts.remove(account);
			}
		}
	}

	public Account CreateAccount(Customer customer, int accountId, String accountType, double amount) {
		Account account = customer.OpenAccount(accountId, accountType, amount, customer);
		accounts.add(account);
		return account;
	}

	public void CloseAccount(Account account) {
		if (account.getBalance() == 0) {
			accounts.remove(account);
			for (Customer customer : customers) {
				if (customer.getAccounts().contains(account)) {
					customer.CloseAccount(account);
					return;
				}
			}
		}
	}

	public String CustomerDetails(Customer customer) {
		customer.ViewAccounts();
		return "Customer [customerId=" + customer.getCustomerId() + ", name=" + customer.getName() + ", phoneNumber="
				+ customer.getPhoneNumber() + ", email="
				+ customer.getEmail() + "]";
	}

	public String BankStatic() {
		double balance = 0;
		for (Account account : accounts) {
			balance += account.getBalance();
		}
		return "total number of cutomers : " + customers.size() + " total number of accounts : " + accounts.size()
				+ " total balance in the bank : " + balance;
	}
}
