package atm;

public class Screen implements ScreenInterface {

	@Override
	public void outputWelcome() {
		System.out.println("Welcome");
	}

	@Override
	public void outputInputPrompt() {
		System.out.print("/> ");
	}

	@Override
	public void outputIdle() {
		System.out.println("Insert card");
	}

	@Override
	public void outputMainMenu() {
		System.out.println("[1] Withdraw funds");
		System.out.println("[2] Deposit funds");
		System.out.println("[3] View account balance");
	}

	@Override
	public void outputWithdrawMenu() {
		System.out.println("Enter amount to withdraw");
		outputInputPrompt();
	}

	@Override
	public void outputDepositMenu() {
		System.out.println("Enter amount to deposit");
		outputInputPrompt();
	}

	@Override
	public void outputChoiceMenu() {
		System.out.println("[y] Accept");
		System.out.println("[n] Decline");
		System.out.println("[x] Exit");
	}
	
	@Override
	public void outputBalance(double balance) {
		System.out.printf("Remaining account balance: %.2f",balance);
	}

	@Override
	public void outputGoodbye() {
		System.out.println("Thank you for using this ATM. Goodbye");
	}

	@Override
	public void outputError(String error) {
		System.err.println(error);
	}

}
