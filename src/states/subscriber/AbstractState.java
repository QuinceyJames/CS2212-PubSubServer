package states.subscriber;



public abstract class AbstractState implements IState {
	
	public AbstractState()  {
		// TODO: delete IState
		// TODO: uses each state in the demo to show how each state implements it
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

