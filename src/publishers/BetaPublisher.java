package publishers;

import strategies.publisher.StrategyName;

/**
 * An implementation of a concrete {@link AbstractPublisher}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class BetaPublisher extends AbstractPublisher {

	/**
	 * Protected constructor for {@link BetaPublisher}. To create this object use
	 * {@link PublisherFactory#createPublisher(PublisherType, StrategyName, int)}
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected BetaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
