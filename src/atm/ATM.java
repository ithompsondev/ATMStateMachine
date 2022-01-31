package atm;

import state.IdleState;
import state.State;
import state.Transition;
import input.Input;

public class ATM {
	private Keypad keypad;
	private Screen screen;
	private String bankName;
	private State currentState;
	
	public ATM(String bankName) {
		this.bankName = bankName;
		this.keypad = new Keypad();
		this.screen = new Screen();
	}
	
	private void setCurrentOperatingState(State state) {
		currentState = state;
	}
	
	public void initializeATMInIdleState() {
		IdleState idle = new IdleState("IDLE",screen);
		State awaitPIN = new State("AWAIT_PIN");
		Input insertCard = new Input("INSERT_CARD");
		idle.insertTransition(new Transition(awaitPIN,insertCard));
		
		setCurrentOperatingState(idle);
	}
	
	public Input operateATMInIdleState() {
		screen.outputChoiceMenu();
		screen.outputInputPrompt();
		Input idleInput = keypad.awaitChoice();
		return idleInput;
	}
	
	// TODO: Refactoring, check for single responsibility
	// TODO: State control flow processor
	
	public static void main(String[] args) {
		ATM newATM = new ATM("New Bank");
		newATM.initializeATMInIdleState();
		newATM.operateATMInIdleState();
	}
}
