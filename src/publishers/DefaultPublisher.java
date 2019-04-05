package publishers;

import events.AbstractEvent;
import strategies.publisher.StrategyName;

public class DefaultPublisher extends AbstractPublisher {

	public DefaultPublisher(StrategyName strategyName) {
		super(strategyName);
	}
}
