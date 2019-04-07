package subscribers;

import events.IEvent;

public interface ISubscriber {

	/**
	 * Function called each time an event is published to one of the channels that
	 * the {@link AbstractSubscriber} is subscribed to
	 * 
	 * @param event       the AbstractEvent that's received
	 * @param channelName the name of the channel that sent the AbstractEvent to the
	 *                    AbstractSubscriber
	 */
	void alert(IEvent event, String channelName);

	/**
	 * Function to subscribe an {@link AbstractSubscriber} to an
	 * {@link pubSub.server.AbstractChannel Channel}
	 * 
	 * @param channelName name of type String used to specify channel
	 */
	void subscribe(String channelName);

	/**
	 * Function to unsubscribe an {@link AbstractSubscriber} to an
	 * {@link pubSub.server.AbstractChannel Channel}
	 * 
	 * @param channelName name of type String used to specify channel
	 */
	void unsubscribe(String channelName);

}