package state;

import input.Input;

public class Transition {
	private State nextState;
	private Input requiredInput;
	
	public Transition(State nextState, Input requiredInput) {
		this.nextState = nextState;
		this.requiredInput = requiredInput;
	}
	
	public State getNextState() {
		return nextState;
	}
	
	public Input getRequiredInput() {
		return requiredInput;
	}
	
	private boolean compareNextStates(State state) {
		return nextState == state;
	}
	
	private boolean compareRequiredInput(Input input) {
		return requiredInput == input;
	}
	
	private boolean compareThisTransitionTo(Transition otherTransition) {
		return compareNextStates(otherTransition.getNextState()) && compareRequiredInput(otherTransition.getRequiredInput());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
	
		Transition comparableTransition = (Transition) object;
		return compareThisTransitionTo(comparableTransition);
	}
}
