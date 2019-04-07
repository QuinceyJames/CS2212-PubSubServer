package publishers;

import strategies.publisher.StrategyName;

/**
 * An implementation of a concrete {@link AbstractPublisher}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class DefaultPublisher extends AbstractPublisher {

	/**
	 * Protected constructor for {@link DefaultPublisher}. To create this object use
	 * {@link PublisherFactory#createPublisher(PublisherType, StrategyName, int)}
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected DefaultPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
