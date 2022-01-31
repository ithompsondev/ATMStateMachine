package atm;

import java.util.Scanner;

import input.Input;

public class Keypad implements KeypadInterface {
	
	@Override
	public Input awaitPIN() {
		Scanner pinScanner = new Scanner(System.in);
		String enteredPIN = pinScanner.nextLine();
		pinScanner.close();
		return new Input(enteredPIN);
	}

	@Override
	public Input awaitChoice() {
		Scanner choiceScanner = new Scanner(System.in);
		String enteredChoice = choiceScanner.nextLine();
		choiceScanner.close();
		return new Input(enteredChoice);
	}
	
	@Override
	public Input pressedAcceptKey() {
		return new Input("ACCEPT");
	}

	@Override
	public Input pressedDeclineKey() {
		return new Input("DECLINE");
	}

	@Override
	public Input pressedWithdrawKey() {
		return new Input("WITHDRAW");
	}

	@Override
	public Input pressedDepositKey() {
		return new Input("DEPOSIT");
	}

	@Override
	public Input pressedExitKey() {
		return new Input("EXIT");
	}
}
