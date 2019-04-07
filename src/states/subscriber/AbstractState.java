package states.subscriber;

import events.AbstractEvent;

public abstract class AbstractState {
	
	protected AbstractState()  {}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
	public abstract void handleEvent(AbstractEvent event, String channelName);
}

