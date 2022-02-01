package dsl;

import state.State;
import state.Transition;
import input.Input;

public class StateTransitionManager {
	
	private State currentState;
	private State nextState;
	
	public StateTransitionManager state(String name) {
		currentState = new State(name);
		return this;
	}
	
	// If the state already exists, make reference using the State and not String
	public StateTransitionManager from(State state) {
		currentState = state;
		return this;
	}
	
	public StateTransitionManager to(String name) {
		nextState = new State(name);
		return this;
	}
	
	public StateTransitionManager to(State state) {
		nextState = state;
		return this;
	}
	
	public StateTransitionManager given(String name) {
		currentState.insertTransition(new Transition(nextState,new Input(name)));
		return this;
	}
	
	public State end() {
		return currentState;
	}
}
