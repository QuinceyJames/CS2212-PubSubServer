package subscribers;

import states.subscriber.StateName;

/**
 * first instance of a concrete subscriber
 * @author kkontog, ktsiouni, mgrigori, rblack43
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
