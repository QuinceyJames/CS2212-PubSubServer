package subscribers;

import states.subscriber.StateName;

/**
 * Package-Protected instance of a concrete {@link AbstractSubscriber}
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
class GammaSubscriber extends AbstractSubscriber {

	/**
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected GammaSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}
}
