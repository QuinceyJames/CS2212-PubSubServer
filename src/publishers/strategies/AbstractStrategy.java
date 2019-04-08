package publishers.strategies;

import events.EventFactory;
import events.EventType;
import events.IEvent;
import events.IEventFactory;
import pubSub.local.ChannelDiscoveryProxy;
import pubSub.server.IPubSubServerFacade;
import pubSub.server.PubSubServerFacade;
import publishers.IPublisher;

/**
 * Base class for the implementation of the "State Design Pattern" with regards
 * to publisher strategies
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public abstract class AbstractStrategy implements IStrategy {
	protected static final IPubSubServerFacade PUB_SUB_SERVER_FACADE = PubSubServerFacade.getInstance();

	/**
	 * A reference to the {@link pubSub.local.ChannelDiscoveryProxy} singleton
	 */
	protected static final ChannelDiscoveryProxy CHANNEL_DISCOVERY = ChannelDiscoveryProxy.getInstance();
	
	/**
	 * A reference to the {@link events.EventFactory} singleton
	 */
	private static final IEventFactory EVENT_FACTORY = EventFactory.getInstance();

	/**
	 * The protected constructor for a {@link AbstractStrategy}. This ensures that
	 * only {@link StrategyFactory} can create strategies
	 */
	protected AbstractStrategy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.strategies.IStrategy#doPublish(IPublisher)
	 */
	@Override
	public final void doPublish(IPublisher publisher) {
		doPublish(EVENT_FACTORY.createEvent(EventType.DEFAULT_EVENT, publisher, "Default Header", "Default Payload"),
				publisher); // Creates a default event for the publisher
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.strategies.IStrategy#doPublish(IEvent, IPublisher)
	 */
	@Override
	public final void doPublish(IEvent event, IPublisher publisher) {
		System.out.println(String.format("%s publishes %s", publisher, event)); // Prints publisher with event
		doPublishStrategy(event, publisher);
	}

	/**
	 * The strategy logic should be defined in here for each of the concrete classes
	 * 
	 * @param event     the {@link IPublisher} that has requested an event to be
	 *                  published
	 * @param publisher the {@link IEvent} to be published
	 */
	protected abstract void doPublishStrategy(IEvent event, IPublisher publisher);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName(); // toString method
	}
}
