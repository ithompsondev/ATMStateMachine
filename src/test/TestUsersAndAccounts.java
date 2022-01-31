package test;

import bank.User;
import bank.Account;
import bank.Card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUsersAndAccounts {
	User userOne;
	User userTwo;
	
	Account accountOne;
	Account accountTwo;
	
	Card cardOne;
	Card cardTwo;
	
	@BeforeEach
	void setup() {
		accountOne = new Account("John Smith","1234567890","12345");
		accountTwo = new Account("Mary Sue","0987654321","54321");
		cardOne = new Card("2468101214","12345");
		cardTwo = new Card("3691215181","54321");
		userOne = new User(accountOne.getAccountHolder(),accountOne,cardOne);
		userTwo = new User(accountTwo.getAccountHolder(),accountTwo,cardTwo);
	}
	
	@Test
	@DisplayName("Compare accountOne with accountOne")
	void testCompareAccountOne() {
		assertEquals(accountOne,accountOne,"accountOne should equal accountOne");
	}
	
	@Test
	@DisplayName("Compare accountOne with accountTwo")
	void testCompareAccountOneWithAccountTwo() {
		assertNotEquals(accountOne,accountTwo,"accountOne should NOT equal accountTwo");
	}
	
	@Test
	@DisplayName("Compare cardOne with cardTwo")
	void testCompareCardOne() {
		assertEquals(cardOne,cardOne,"cardOne should equal cardOne");
	}
	
	@Test
	@DisplayName("Compare cardTwo with cardTwo")
	void testCompareCardOneWithCardTwo() {
		assertNotEquals(cardOne,cardTwo,"cardOne should NOT equal cardTwo");
	}
	
	@Test
	@DisplayName("Compare userOne with userOne")
	void testCompareUserOne() {
		assertEquals(userOne,userOne,"userOne should equal userOne");
	}
	
	@Test
	@DisplayName("Compare userOne with userTwo")
	void testCompareUserOneWithUserTwo() {
		assertNotEquals(userOne,userTwo,"userOne should NOT equal userTwo");
	}
	
	@Test
	@DisplayName("Set new account balance")
	void testSetNewAccountBalanceAndCheck() {
		double newBalance = 134.09;
		accountOne.setAccountBalance(newBalance);
		assertEquals(accountOne.checkAccountBalance(),newBalance,"New account balance of R134.09");
	}
	
	@Test
	@DisplayName("Increase account balance")
	void testIncreaseAccountBalanceAndCheck() {
		double delta = 25.0;
		accountTwo.increaseAccountBalance(delta);
		assertEquals(accountTwo.checkAccountBalance(),delta,"Account balance after increase should be 25.0");
	}
	
	@Test
	@DisplayName("Decrease account balance")
	void testDecreaseAccountBalanceAndCheck() {
		double delta = 25.0;
		accountTwo.setAccountBalance(0.0);
		accountTwo.decreaseAccountBalance(delta);
		assertEquals(accountTwo.checkAccountBalance(),-delta,"Account balance decrease should be -25.0");
	}
}
