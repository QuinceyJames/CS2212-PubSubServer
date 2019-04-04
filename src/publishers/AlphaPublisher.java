package publishers;

import events.AbstractEvent;
import pubSubServer.ChannelEventDispatcher;
import strategies.publisher.StrategyName;

public class AlphaPublisher extends AbstractPublisher {

	public AlphaPublisher(StrategyName strategyName) {
		super(strategyName);
	}

	@Override
	public void publish() {
		
	}

	@Override
	public void publish(AbstractEvent event) {
		publishingStrategy.doPublish(event);
	}

}
