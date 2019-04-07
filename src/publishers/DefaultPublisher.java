package publishers;

import strategies.publisher.StrategyName;

/**
 * third instance of a concrete pubscriber
 * @author rblack43
 */
public class DefaultPublisher extends AbstractPublisher {

	/**
	 * (non-Javadoc)
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected DefaultPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
