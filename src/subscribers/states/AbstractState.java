package subscribers.states;

import events.IEvent;

/**
 * A class that can be used in a "State Design Pattern"
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 *
 */
public abstract class AbstractState implements IState {

	/**
	 * The protected constructor for this class. This ensures that only
	 * {@link StateFactory} can create states
	 */
	protected AbstractState() {
	}

	/* (non-Javadoc)
	 * @see subscribers.states.IState#handleEvent(events.AbstractEvent, java.lang.String)
	 */
	@Override
	public abstract void handleEvent(IEvent event, String channelName);

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
