package publishers;

import publishers.strategies.StrategyName;

/**
 * An implementation of a concrete {@link AbstractPublisher}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class AlphaPublisher extends AbstractPublisher {

	/**
	 * Protected constructor for {@link AlphaPublisher}. To create this object use
	 * {@link PublisherFactory#createPublisher(PublisherType, StrategyName, int)}
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected AlphaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}

}
