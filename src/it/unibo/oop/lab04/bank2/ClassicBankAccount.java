package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

	public ClassicBankAccount(final int usrID, final double balance) {
		super(usrID, balance);
	}
	
	protected boolean isWithdrawAllowed(double amount) {
		return true;
	}

	protected double computeFee() {
		return AbstractBankAccount.MANAGEMENT_FEE;
	}

}
