package states.subscriber;

import events.AbstractEvent;

public abstract class AbstractState {

	/**
	 * The protected constructor for this class. This ensures that only
	 * {@link StateFactory} can create states
	 */
	protected AbstractState() {
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public abstract void handleEvent(AbstractEvent event, String channelName);
}
