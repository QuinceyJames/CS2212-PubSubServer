package subscribers;

import events.AbstractEvent;
import pubSubServer.SubscriptionManager;
import states.subscriber.StateFactory;
import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori
 * an example concrete subscriber
 */
public class BetaSubscriber extends AbstractSubscriber  {


	protected BetaSubscriber(StateName stateName) {
		super(stateName);
	}
	
	/* (non-Javadoc)
	 * @see subscribers.ISubscriber#setState(states.subscriber.StateName)
	 */
	public void setState(StateName stateName) {
		state = StateFactory.createState(stateName);
	}

	// TODO: make a toString()
}
