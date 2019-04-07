package subscribers;

import subscribers.states.StateName;

/**
 * An implementation of a concrete {@link AbstractSubscriber}
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class DefaultSubscriber extends AbstractSubscriber {

	/**
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected DefaultSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}
}
