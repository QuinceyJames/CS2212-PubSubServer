package publishers;

import events.AbstractEvent;
import strategies.publisher.StrategyName;

public class AlphaPublisher extends AbstractPublisher {

	public AlphaPublisher(StrategyName strategyName) {
		super(strategyName);
	}
}
