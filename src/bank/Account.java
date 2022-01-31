package bank;

public class Account {
	private String accountHolder;
	private String accountNr;
	private String accountPIN;
	private double balance;
	
	public Account(String accountHolder, String accountNr, String accountPIN) {
		this.accountHolder = accountHolder;
		this.accountNr = accountNr;
		this.accountPIN = accountPIN;
		this.balance = 0.0;
	}
	
	public void setAccountBalance(double newBalance) {
		balance = newBalance;
	}
	
	public void increaseAccountBalance(double changeInBalance) {
		balance += changeInBalance;
	}
	
	public void decreaseAccountBalance(double changeInBalance) {
		balance -= changeInBalance;
	}
	
	public double checkAccountBalance() {
		return balance;
	}
	
	public void changeAccountHolder(String newAccountHolder) {
		accountHolder = newAccountHolder;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public String getAccountNr() {
		return accountNr;
	}
	
	public String getAccountPIN() {
		return accountPIN;
	}
	
	private boolean compareAccountHolders(String otherAccountHolder) {
		return accountHolder.equals(otherAccountHolder);
	}
	
	private boolean compareAccountNumbers(String otherAccountNr) {
		return accountNr.equals(otherAccountNr);
	}
	
	private boolean compareThisAccountTo(Account otherAccount) {
		return compareAccountHolders(otherAccount.getAccountHolder()) && compareAccountNumbers(otherAccount.getAccountNr());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		
		Account comparableAccount = (Account) object;
		return compareThisAccountTo(comparableAccount);
	}
}
