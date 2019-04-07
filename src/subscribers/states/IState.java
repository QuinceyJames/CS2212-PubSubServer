package subscribers.states;

import events.IEvent;

public interface IState {

	/**
	 * The method to call when this object should execute it's implementation of how
	 * it handles an event
	 * 
	 * @param event       the {@link events.AbstractEvent Event} to be handled
	 * @param channelName the channel where the {@link events.AbstractEvent Event}
	 *                    came from
	 */
	void handleEvent(IEvent event, String channelName);

}