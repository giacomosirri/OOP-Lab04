package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{

	public RestrictedBankAccount(int usrID, double amount) {
		super(usrID, amount);
	}

	protected boolean isWithdrawAllowed(double amount) {
		return amount < this.getBalance();
	}

	protected double computeFee() {
		return AbstractBankAccount.MANAGEMENT_FEE + 
				AbstractBankAccount.TRANSACTION_FEE * this.getNTransactions();
	}

}
