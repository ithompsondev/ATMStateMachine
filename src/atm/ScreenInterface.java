package atm;

public interface ScreenInterface {
	void outputWelcome();
	void outputInputPrompt();
	void outputIdle();
	void outputMainMenu();
	void outputWithdrawMenu();
	void outputDepositMenu();
	void outputChoiceMenu();
	void outputBalance(double balance);
	void outputGoodbye();
	void outputError(String error);
}
