package pubSub.local;

import pubSub.server.ChannelAccessControl;
import pubSub.server.IChannel;
import subscribers.ISubscriber;

public interface ISubscriptionManagerProxy {

	/**
	 * Completes the subscription of the provided ISubscriber to the appropriate
	 * AbstractChannel specified by the channelName
	 * 
	 * @param channelTopic the name of the {@link IChannel Channel} to which the
	 *                     {@link ISubscriber Subscriber} wants to subscribe
	 * @param subscriber   the reference to an {@link subscribers.ISubscriber
	 *                     Subscriber} object
	 */
	void subscribe(String channelTopic, ISubscriber subscriber);

	/**
	 * Completes the unsubscription of the provided ISubscriber from the specified,
	 * by the channelName, AbstractChannel
	 * 
	 * @param channelName the name of the {@link IChannel Channel} from which the
	 *                    {@link subscribers.ISubscriber Subscriber} wants to
	 *                    unsubscribe
	 * @param subscriber  the reference to an {@link subscribers.ISubscriber
	 *                    Subscriber} object
	 */
	void unSubscribe(String channelName, ISubscriber subscriber);

	/**
	 * Proxy to {@link ChannelAccessControl}
	 * 
	 * @param subscriber  who to unblock
	 * @param channelName from which channel
	 * @return true if the {@link subscribers.ISubscriber} was previously blocked.
	 *         Otherwise return false.
	 */
	boolean unblock(ISubscriber subscriber, String channelName);

	/**
	 * Proxy to {@link ChannelAccessControl}
	 * 
	 * @param subscriber  who to block
	 * @param channelName from which channel
	 * @return true if the {@link ISubscriber Subscriber} was not previously blocked
	 *         on this channel. Otherwise it returns false.
	 */
	boolean block(ISubscriber subscriber, String channelName);

	/**
	 * Proxy to {@link ChannelAccessControl}
	 * 
	 * @param subscriber  who to block
	 * @param channelName from which channel
	 * @return true if the {@link ISubscriber Subscriber} was not previously blocked
	 *         on this channel. Otherwise it returns false.
	 */
	boolean checkIfBlocked(ISubscriber subscriber, String channelName);

}