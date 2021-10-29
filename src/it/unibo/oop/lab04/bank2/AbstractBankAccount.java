package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.*;

public abstract class AbstractBankAccount implements BankAccount {

    protected static final double ATM_TRANSACTION_FEE = 1;
    protected static final double MANAGEMENT_FEE = 5;
    protected static final double TRANSACTION_FEE = 0.1;
    
    private double balance;
    private int nTransactions;
    private final int usrID;
    
    protected AbstractBankAccount(final int usrID, final double balance) {
        this.usrID = usrID;
        this.balance = balance;
        this.nTransactions = 0;
    }
    
	public void computeManagementFees(int usrID) {
		this.withdraw(usrID, this.computeFee());
	}

	private boolean checkUser(int usrID) {
		return this.usrID == usrID;
	}
	
	private void incrementTransactions() {
		this.nTransactions++;
	}
	
	protected void transactionOp(int usrID, double amount) {
		if (this.checkUser(usrID)) {
			this.balance += amount;
			this.incrementTransactions();
		}
	}
	
	public void deposit(int usrID, double amount) {
		this.transactionOp(usrID, amount);
	}

	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
	}

	public double getBalance() {
		return this.balance;
	}

	public int getNTransactions() {
		return this.nTransactions;
	}

	public void withdraw(int usrID, double amount) {
		if(this.isWithdrawAllowed(amount)) {
			this.transactionOp(usrID, -amount);
		}
	}

	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	
	protected abstract boolean isWithdrawAllowed(double amount);
	
	protected abstract double computeFee();
}
