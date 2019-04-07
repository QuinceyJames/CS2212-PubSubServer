package states.subscriber;

import events.AbstractEvent;

/**
 * A class that can be used in a "State Design Pattern"
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 *
 */
public abstract class AbstractState {

	/**
	 * The protected constructor for this class. This ensures that only
	 * {@link StateFactory} can create states
	 */
	protected AbstractState() {
	}

	/**
	 * The method to call when this object should execute it's implementation of how
	 * it handles an event
	 * 
	 * @param event       the {@link events.AbstractEvent Event} to be handled
	 * @param channelName the channel where the {@link events.AbstractEvent Event}
	 *                    came from
	 */
	public abstract void handleEvent(AbstractEvent event, String channelName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
