package publishers;

import strategies.publisher.StrategyName;

/**
 * second instance of a concrete pubscriber
 * @author rblack43
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
