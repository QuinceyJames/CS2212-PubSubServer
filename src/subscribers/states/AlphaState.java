package subscribers.states;

import events.IEvent;
import subscribers.AlphaSubscriber;

/**
 * An implementation of a concrete {@link AbstractState}
 *
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 * 
 */
public class AlphaState extends AbstractState {

	/**
	 * Protected constructor for {@link AlphaSubscriber}. To create this object use
	 * {@link StateFactory#createState(StateName)}
	 */
	protected AlphaState() {
		super(); // Calls parent
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see subscribers.states.AbstractState#handleEvent(events.AbstractEvent,
	 * java.lang.String)
	 */
	@Override
	public void handleEvent(IEvent event, String channelName) {
		// This is where we would implement how the event is handled
	}
}
