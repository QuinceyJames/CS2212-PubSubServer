package states.subscriber;

import events.AbstractEvent;

public abstract class AbstractState {
	
	protected AbstractState()  {
		// TODO: delete IState
		// TODO: uses each state in the demo to show how each state implements it
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
	public abstract void handleEvent(AbstractEvent event, String channelName);
}

