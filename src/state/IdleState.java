package state;

import atm.Screen;

public class IdleState extends State {

	public IdleState(String name, Screen screen) {
		super(name);
		screen.outputIdle();
	}
}
