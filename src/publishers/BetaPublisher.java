package publishers;

import strategies.publisher.StrategyName;

/**
 * Package-Protected instance of a concrete {@link AbstractPublisher}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
class BetaPublisher extends AbstractPublisher {

	/**
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected BetaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
