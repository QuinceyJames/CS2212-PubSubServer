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
 * second instance of a concrete subscriber
 * @author kkontog, ktsiouni, mgrigori, rblack43
 */
public class BetaSubscriber extends AbstractSubscriber {

	
	/**
	 *
	 * (non-Javadoc)
	 * 
	 * @see AbstractSubscriber#AbstractSubscriber(StateName, int)
	 */
	protected BetaSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}
}
