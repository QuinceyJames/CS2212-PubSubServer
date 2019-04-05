package publishers;

import strategies.publisher.StrategyName;

public class DefaultPublisher extends AbstractPublisher {

	protected DefaultPublisher(StrategyName strategyName, int publisherID) {
		super(strategyName, publisherID);
	}
}
