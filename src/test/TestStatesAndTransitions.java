package test;

import input.Input;
import state.State;
import state.Transition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStatesAndTransitions {
	State stateAlpha;
	State stateBeta;
	State stateGamma;
	
	Input alphaBetaJump;
	Input betaGammaJump;
	
	Transition alphaToBeta;
	Transition betaToGamma;
	
	@BeforeEach
	void setup() {
		stateAlpha = new State("ALPHA STATE");
		stateBeta = new State("BETA STATE");
		stateGamma = new State("GAMMA STATE");
		alphaBetaJump = new Input("ab_jump");
		betaGammaJump = new Input("bg_jump");
		
		alphaToBeta = new Transition(stateBeta,alphaBetaJump);
		betaToGamma = new Transition(stateGamma,betaGammaJump);
		
		stateAlpha.insertTransition(alphaToBeta);
		stateBeta.insertTransition(betaToGamma);
	}
	
	@Test
	@DisplayName("Comparing Alpha State to Alpha State")
	void testCompareAlphaState() {
		assertEquals(stateAlpha,stateAlpha,"Alpha state should equal Alpha state");
	}
	
	@Test
	@DisplayName("Comparing Beta state to Beta state")
	void testCompareBetaState() {
		assertEquals(stateBeta,stateBeta,"Beta state should equal Beta state");
	}
	
	@Test
	@DisplayName("Comparing Gamma state to Gamma state")
	void testCompareGammaState() {
		assertEquals(stateGamma,stateGamma,"Gamma state should equal Gamma state");
	}
	
	@Test
	@DisplayName("Comparing Alpha state to Beta state")
	void testCompareAlphaToBetaState() {
		assertNotEquals(stateAlpha,stateBeta,"Alpha state should NOT equal Beta state");
	}
	
	@Test
	@DisplayName("Find Alpha state's next state")
	void testFindAlphaNextState() {
		assertEquals(stateAlpha.findNextState(alphaBetaJump),stateBeta,"Alpha jumps to Beta given ab_jump");
	}
	
	@Test
	@DisplayName("Find Beta state's next state")
	void testFindBetaNextState() {
		assertEquals(stateBeta.findNextState(betaGammaJump),stateGamma,"Beta jumps to Gamma given bg_jump");
	}
	
	@Test
	@DisplayName("Compare ab_jump to bg_jump")
	void testCompareABJumpToBGJump() {
		assertNotEquals(alphaBetaJump,betaGammaJump,"ab_jump should NOT equal bg_jump");
	}
	
	@Test
	@DisplayName("Compare ab_jump to ab_jump")
	void testCompareAbJump() {
		assertEquals(alphaBetaJump,alphaBetaJump,"ab_jump should equal ab_jump");
	}
	
	@Test
	@DisplayName("Compare Alpha to Beta Transition")
	void testCompareAlphaToBetaTransition() {
		assertEquals(alphaToBeta,alphaToBeta,"alphaToBeta should equal alphaToBeta");
	}
	
	@Test
	@DisplayName("Compare Alpha to Beta with Beta to Gamma Transition")
	void testCompareAlphaToBetaWithBetaToGammaTransition() {
		assertNotEquals(alphaToBeta,betaToGamma,"alphaToBeta should NOT equal betaToGamma");
	}
}
