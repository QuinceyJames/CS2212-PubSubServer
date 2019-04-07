package publishers;

import strategies.publisher.StrategyName;


/**
 * first instance of a concrete pubscriber
 * @author rblack43
 */
public class AlphaPublisher extends AbstractPublisher {

	
	/**
	 * (non-Javadoc)
	 * 
	 * @see AbstractPublisher#AbstractPublisher(StrategyName, int)
	 */
	protected AlphaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}

}
