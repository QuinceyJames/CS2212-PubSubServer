package pubSub.server;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import events.IEvent;
import pubSub.local.ChannelDiscoveryProxy;
import subscribers.ISubscriber;

/**
 * A Package-Protected concrete implementation of {@link AbstractChannel}. It
 * helps to implement the "Observer Design Pattern" as it will notify all the
 * {@link subscribers.ISubscriber Subscribers} that are subscribed to
 * this {@link Channel} when a new {@link events.IEvent Event} is posted
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43  
 */
public class Channel extends AbstractChannel {

	/**
	 * A set of {@link subscribers.ISubscriber Subscribers} subscribed to
	 * this channel
	 */
	private final Set<ISubscriber> subscribers = new HashSet<>();

	/**
	 * A queue of {@link events.IEvent Events} posted to this {@link Channel}
	 */
	private final Queue<IEvent> events = new ArrayDeque<>();

	/**
	 * The Protected constructor for this class. Use the {@link ChannelFactory} to
	 * create new {@link Channel Channels} and {@link ChannelDiscoveryProxy} to find
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
	 * @see pubSub.server.AbstractChannel#publishEvent(events.IEvent)
	 */
	protected void publishEvent(IEvent event) {
		System.out.println(String.format("Channel '%s' has %s.", this.getChannelTopic(), event));
		events.add(event);
		notifySubscribers(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.AbstractChannel#subscribe(subscribers.ISubscriber)
	 */
	protected void subscribe(ISubscriber subscriber) {
		subscribers.add(subscriber); // add subscriber
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.AbstractChannel#unsubscribe(subscribers.ISubscriber)
	 */
	protected void unsubscribe(ISubscriber subscriber) {
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
	private void notifySubscribers(IEvent event) {
		for (ISubscriber subscriber : subscribers) {
			if (!ChannelAccessControl.getInstance().checkIfBlocked(subscriber, getChannelTopic()))
				subscriber.alert(event, getChannelTopic());
		}
	}

}
