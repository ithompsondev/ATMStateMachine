package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bank.Account;
import bank.Card;
import bank.User;
import dsl.ATMUser;

public class TestATMUserDSL {
	Account account;
	Card card;
	User user;
	ATMUser atmUser;
	
	@BeforeEach
	void setup() {
		atmUser = new ATMUser()
				.create()
				.name("John Smith")
				.accNumber("1234567890")
				.cardNumber("0987654321")
				.pin("12345")
				;
		account = atmUser.issue();
		card 	= atmUser.print();
		user 	= atmUser.register();
	}
	
	@Test
	@DisplayName("DSL constructs a new account")
	void testDSLAccountConstruction() {
		assertEquals(account.getAccountHolder(),"John Smith","Account holder is John Smith");
		assertEquals(account.getAccountNr(),"1234567890","Account number is 1234567890");
		assertEquals(account.getAccountPIN(),"12345","Account PIN is 12345");
	}
	
	@Test
	@DisplayName("DSL constructs a new card")
	void testDSLCardConstruction() {
		assertEquals(card.getCardNr(),"0987654321","Card number is 0987654321");
		assertEquals(card.getCardPIN(),"12345","Card PIN is 12345");
	}
	
	@Test
	@DisplayName("DSL constructs a new user")
	void testDSLUserConstruction() {
		assertEquals(user.getName(),"John Smith","User name is John Smith");
		assertEquals(user.getAccount(),account,"User account matches constructed account");
		assertEquals(user.getCard(),card,"User card matches constructed card");
	}
}
