package subscribers;

import subscribers.states.StateName;

/**
 * An implementation of a concrete {@link AbstractSubscriber}
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class AlphaSubscriber extends AbstractSubscriber {

	/**
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected AlphaSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}

}
