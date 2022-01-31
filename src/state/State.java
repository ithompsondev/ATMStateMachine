package state;

import java.util.ArrayList;

import input.Input;

public class State {
	private String name;
	private ArrayList<Transition> possibleTransitionStates;
	
	public State(String name) {
		this.name = name;
		this.possibleTransitionStates = new ArrayList<>();
	}
	
	public void insertTransition(Transition transition) {
		possibleTransitionStates.add(transition);
	}
	
	public State findNextState(Input providedInput) {
		for (Transition transition: possibleTransitionStates) {
			if (transition.getRequiredInput() == providedInput) {
				return transition.getNextState();
			}
		}
		// Throw a custom exception
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	private boolean compareThisStateTo(State otherState) {
		return name.equals(otherState.getName());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		
		State comparableState = (State) object;
		return compareThisStateTo(comparableState);
	}
}
