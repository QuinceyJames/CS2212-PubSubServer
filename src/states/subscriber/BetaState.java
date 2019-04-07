package states.subscriber;

import events.AbstractEvent;

public class BetaState extends AbstractState {

	/**
	 * Protected constructor for {@link AlphaSubscriber}. To create this object use
	 * {@link StateFactory#createState(StateName)}
	 */
	protected BetaState() {
		super(); //Calls parent
	}
	
	public void handleEvent(AbstractEvent event, String channelName) {
		
	}
	
	
}
