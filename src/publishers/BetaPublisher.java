package publishers;

import strategies.publisher.StrategyName;

/**
 * second instance of a concrete pubscriber
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class BetaPublisher extends AbstractPublisher {

	/**
	 * (non-Javadoc)
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected BetaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
