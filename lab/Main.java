package lab;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank("biat");
		Customer customer = bank.CreateCustomer("hamza", "123412", "hamza@gmail.com");
		bank.CreateAccount(customer, 0, "type", 123.123);
		System.out.println(bank.CustomerDetails(customer));
		System.out.println(bank.BankStatic());

	}

}
