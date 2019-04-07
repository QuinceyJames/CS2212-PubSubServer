package publishers;

import strategies.publisher.StrategyName;


/**
 * first instance of a concrete pubscriber
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
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
