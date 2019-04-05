package publishers;

import events.AbstractEvent;
import strategies.publisher.StrategyName;

public class BetaPublisher extends AbstractPublisher {

	public BetaPublisher(StrategyName strategyName) {
		super(strategyName);
	}
}
