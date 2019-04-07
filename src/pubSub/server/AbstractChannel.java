package pubSub.server;

import baseEntities.AbstractEntity;
import events.AbstractEvent;
import subscribers.AbstractSubscriber;
import subscribers.ISubscriber;

/**
 * the abstract base class for the channel functionality only implemented this
 * way because channels can potentially have different properties that may
 * affect how the published events are treated.
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public abstract class AbstractChannel extends AbstractEntity<String> {

	/**
	 * The topic of this channel
	 */
	private final String channelTopic;

	/**
	 * The protected constructor for this class. It prints a message to indicate
	 * that a {@link AbstractChannel Channel} has been created. This ensures that
	 * only {@link ChannelFactory} can create channels
	 * 
	 * @param channelTopic the topic of this channel
	 */
	protected AbstractChannel(String channelTopic) {
		super(channelTopic);
		this.channelTopic = channelTopic;
		System.out.println(String.format("%s '%s' has been created.", this, channelTopic));
	}

	/**
	 * @param event the event that's to be published
	 */
	protected abstract void publishEvent(AbstractEvent event);

	/**
	 * @param subscriber the handle of subscriber that wants to subscribe to the
	 *                   channel
	 */
	protected abstract void subscribe(AbstractSubscriber subscriber);

	/**
	 * @param subscriber the handle of the subscriber that wants to unsubscribe from
	 *                   the channel
	 */
	protected abstract void unsubscribe(ISubscriber subscriber);

	/**
	 * @return the topic/name of the concrete implementation of Channel
	 */
	public String getChannelTopic() {
		return channelTopic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
