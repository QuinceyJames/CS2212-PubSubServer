package pubSubServer;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import events.AbstractEvent;
import subscribers.AbstractSubscriber;

/**
 * A Package-Protected concrete implementation of {@link AbstractChannel}. It
 * helps to implement the "Observer Design Pattern" as it will notify all the
 * {@link subscribers.AbstractSubscriber Subscribers} that are subscribed to
 * this {@link Channel} when a new {@link events.AbstractEvent Event} is posted
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43  
 */
class Channel extends AbstractChannel {

	/**
	 * A set of {@link subscribers.AbstractSubscriber Subscribers} subscribed to
	 * this channel
	 */
	private final Set<AbstractSubscriber> subscribers = new HashSet<AbstractSubscriber>();

	/**
	 * A queue of {@link events.AbstractEvent Events} posted to this {@link Channel}
	 */
	private final Queue<AbstractEvent> events = new ArrayDeque<AbstractEvent>();

	/**
	 * A reference to {@link ChannelAccessControl}
	 */
	private final ChannelAccessControl accessControler = ChannelAccessControl.getInstance();

	/**
	 * The Protected constructor for this class. Use the {@link ChannelCreator} to
	 * create new {@link Channel Channels} and {@link ChannelDiscovery} to find
	 * pre-existing ones
	 * 
	 * @param channelTopic the topic of this channel
	 */
	protected Channel(String channelTopic) {
		super(channelTopic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSubServer.AbstractChannel#publishEvent(events.AbstractEvent)
	 */
	protected void publishEvent(AbstractEvent event) {
		System.out.println(String.format("Channel '%s' has %s.", this.getChannelTopic(), event));
		events.add(event);
		notifySubscribers(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSubServer.AbstractChannel#subscribe(subscribers.AbstractSubscriber)
	 */
	protected void subscribe(AbstractSubscriber subscriber) {
		subscribers.add(subscriber); // add subscriber
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSubServer.AbstractChannel#unsubscribe(subscribers.AbstractSubscriber)
	 */
	protected void unsubscribe(AbstractSubscriber subscriber) {
		subscribers.remove(subscriber); // remove subscriber
	}

	/**
	 * 
	 * If you are reading this outside this class something is wrong. This is a
	 * private method which should be called plain 'notify' unfortunately the name
	 * is not available in java.
	 * 
	 * It iterates over all available subscribed subscribers and notifies them of
	 * the occurrence of the event.
	 * 
	 * @param event the event that's to be disseminated to the subscribers
	 */
	private void notifySubscribers(AbstractEvent event) {
		for (AbstractSubscriber subscriber : subscribers) {
			if (!accessControler.checkIfBlocked(subscriber, getChannelTopic()))
				subscriber.alert(event, getChannelTopic());
		}
	}

}
