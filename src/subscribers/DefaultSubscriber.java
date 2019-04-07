package subscribers;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;
import states.subscriber.StateFactory;
import states.subscriber.StateName;

/**
 * third instance of a concrete subscriber
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class DefaultSubscriber extends AbstractSubscriber {

	/**
	 *
	 * (non-Javadoc)
	 * 
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected DefaultSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}
}
