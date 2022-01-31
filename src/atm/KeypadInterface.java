package atm;

import input.Input;

public interface KeypadInterface {
	Input awaitPIN();
	Input awaitChoice();
	Input pressedAcceptKey();
	Input pressedDeclineKey();
	Input pressedWithdrawKey();
	Input pressedDepositKey();
	Input pressedExitKey();
}
