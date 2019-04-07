package publishers;

import strategies.publisher.StrategyName;

/**
 * fourth instance of a concrete pubscriber
 * @author rblack43
 */
public class GammaPublisher extends AbstractPublisher {

	/**
	 * (non-Javadoc)
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected GammaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
