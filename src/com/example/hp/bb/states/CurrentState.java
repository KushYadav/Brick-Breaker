package com.example.hp.bb.states;

public class CurrentState {

	private static State currentState = null;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		CurrentState.currentState = currentState;
	}

}
