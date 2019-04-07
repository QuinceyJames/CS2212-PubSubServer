package states.subscriber;

import events.AbstractEvent;

/**
 * An implementation of a concrete {@link AbstractState}
 *
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 * 
 */
public class GammaState extends AbstractState {

	/**
	 * Protected constructor for {@link AlphaSubscriber}. To create this object use
	 * {@link StateFactory#createState(StateName)}
	 */
	protected GammaState() {
		super(); // Calls parent
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see states.subscriber.AbstractState#handleEvent(events.AbstractEvent,
	 * java.lang.String)
	 */
	@Override
	public void handleEvent(AbstractEvent event, String channelName) {
		// This is where we would implement how the event is handled
	}

}
