package publishers;

import strategies.publisher.StrategyName;

public class BetaPublisher extends AbstractPublisher {

	protected BetaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
