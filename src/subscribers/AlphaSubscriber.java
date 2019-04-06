package subscribers;

import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori, rblack43
 * first instance of a concrete subscriber
 */
public class AlphaSubscriber extends AbstractSubscriber {
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected AlphaSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}
	
}
