package pubSub.local;

import pubSub.server.AbstractChannel;
import subscribers.AbstractSubscriber;
import subscribers.ISubscriber;

public interface ISubscriptionManagerProxy {

	/**
	 * Completes the subscription of the provided ISubscriber to the appropriate
	 * AbstractChannel specified by the channelName
	 * 
	 * @param channelName the name of the {@link AbstractChannel Channel} to which
	 *                    the {@link subscribers.AbstractSubscriber Subscriber}
	 *                    wants to subscribe
	 * @param subscriber  the reference to an {@link subscribers.AbstractSubscriber
	 *                    Subscriber} object
	 */
	void subscribe(String channelTopic, AbstractSubscriber subscriber);

	/**
	 * Completes the unsubscription of the provided ISubscriber from the specified,
	 * by the channelName, AbstractChannel
	 * 
	 * @param channelName the name of the {@link AbstractChannel Channel} from which
	 *                    the {@link subscribers.AbstractSubscriber Subscriber}
	 *                    wants to unsubscribe
	 * @param subscriber  the reference to an {@link subscribers.AbstractSubscriber
	 *                    Subscriber} object
	 */
	void unSubscribe(String channelName, ISubscriber subscriber);

	/**
	 * Proxy to
	 * {@link ChannelAccessControl#unBlockSubscriber(AbstractSubscriber, String)}
	 * 
	 * @param subscriber  who to unblock
	 * @param channelName from which channel
	 * @return true if the {@link subscribers.AbstractSubscriber} was previously
	 *         blocked. Otherwise return false.
	 */
	boolean unblock(ISubscriber subscriber, String channelName);

	/**
	 * Proxy to
	 * {@link ChannelAccessControl#blockSubscriber(AbstractSubscriber, String)}
	 * 
	 * @param subscriber  who to block
	 * @param channelName from which channel
	 * @return true if the {@link AbstractSubscriber Subscriber} was not previously
	 *         blocked on this channel. Otherwise it returns false.
	 */
	boolean block(AbstractSubscriber subscriber, String channelName);

	/**
	 * Proxy to
	 * {@link ChannelAccessControl#checkIfBlocked(AbstractSubscriber, String)}
	 * 
	 * @param subscriber  who to block
	 * @param channelName from which channel
	 * @return true if the {@link AbstractSubscriber Subscriber} was not previously
	 *         blocked on this channel. Otherwise it returns false.
	 */
	boolean checkIfBlocked(ISubscriber subscriber, String channelName);

}