package test;

import state.State;
import dsl.StateTransitionManager;
import input.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStateTransitionManager {
	State stateOne;
	State stateTwo;
	State stateThree;
	
	@BeforeEach
	void setup() {
		stateOne = new StateTransitionManager()
							.state("START")
								.to("FINISH")
								.given("REDLINE")
							.end()
							;
		stateTwo = new StateTransitionManager()
							.state("FINISH")
								.to("PIT")
								.given("SIGNAL")
							.end()
							;
		stateThree = new StateTransitionManager()
							.from(stateOne)
								.to("PIT")
								.given("FLAG")
							.end()
							;
	}
	
	@Test
	@DisplayName("Go from start to finish")
	void testStartToFinish() {
		assertEquals(stateOne,new State("START"),"Start State confirmed");
		assertEquals(stateTwo,new State("FINISH"),"End State confirmed");
		assertEquals(stateOne.findNextState(new Input("REDLINE")),stateTwo,"Transition from START to FINISH");
	}
	
	@Test
	@DisplayName("Go from finish to pit")
	void testFinishToPit() {
		assertEquals(stateTwo,new State("FINISH"),"Finish State confirmed");
		assertEquals(stateTwo.findNextState(new Input("SIGNAL")),new State("PIT"),"Pit State confirmed");
	}
	
	@Test
	@DisplayName("Go from start to pit")
	void testStartToPit() {
		assertEquals(stateOne,new State("START"),"Start State confirmed");
		assertEquals(stateOne,stateThree,"Start States are the same");
		assertEquals(stateOne.findNextState(new Input("FLAG")),new State("PIT"),"Transition from START to PIT");
	}
}
