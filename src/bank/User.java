package bank;

public class User {
	private String name;
	private Account account;
	private Card card;
	
	public User(String name, Account account, Card card) {
		this.name = name;
		this.account = account;
		this.card = card;
	}
	
	public void changeName(String newName) {
		name = newName;
		account.changeAccountHolder(newName);
	}
	
	public String getName() {
		return name;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public Card getCard() {
		return card;
	}
	
	private boolean compareAccounts(Account otherAccount) {
		return account.equals(otherAccount);
	}
	
	private boolean compareCards(Card otherCard) {
		return card.equals(otherCard);
	}
	
	private boolean compareThisUserTo(User otherUser) {
		return compareAccounts(otherUser.getAccount()) && compareCards(otherUser.getCard());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		
		User comparableUser = (User) object;
		return compareThisUserTo(comparableUser);
	}
}
