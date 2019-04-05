package strategies.publisher;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;

public abstract class AbstractStrategy {

	public AbstractStrategy() {
		// TODO: delete the IStrategy
	}

	public void doPublish(AbstractPublisher publisher) {
		doPublish(EventFactory.createEvent(EventType.DEFAULT_EVENT, publisher, "Default Header", "Default Payload"));
	}

	public void doPublish(AbstractEvent event) {
		ChannelEventDispatcher.getInstance().postEvent(event, ChannelDiscovery.getInstance().listChannels());
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
