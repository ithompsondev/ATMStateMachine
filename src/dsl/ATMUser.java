package dsl;

import bank.Account;
import bank.Card;
import bank.User;

public class ATMUser {
	private Account account;
	private Card card;
	private User user;
	
	// TODO: Error checking
	
	public ATMUser create() {
		this.account = new Account();
		this.card = new Card();
		this.user = new User();
		return this;
	}
	
	public ATMUser name(String accountName) {
		account.setAccountHolder(accountName);
		user.setName(accountName);
		return this;
	}
	
	public ATMUser accNumber(String accountNr) {
		account.setAccountNr(accountNr);
		return this;
	}
	
	public ATMUser cardNumber(String cardNr) {
		card.setCardNr(cardNr);
		return this;
	}
	
	public ATMUser pin(String accountPIN) {
		account.setAccountPIN(accountPIN);
		card.setCardPIN(accountPIN);
		return this;
	}
	
	public Account issue() {
		return account;
	}
	
	public Card print() {
		return card;
	}
	
	public User register() {
		user.setAccount(account);
		user.setCard(card);
		return user;
	}
}
