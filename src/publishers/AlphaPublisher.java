package publishers;

import strategies.publisher.StrategyName;

public class AlphaPublisher extends AbstractPublisher {

	protected AlphaPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}

}
