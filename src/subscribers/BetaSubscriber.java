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
 * @author kkontog, ktsiouni, mgrigori an example concrete subscriber
 */
public class BetaSubscriber extends AbstractSubscriber {

	protected BetaSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see subscribers.ISubscriber#setState(states.subscriber.StateName)
	 */
	public void setState(StateName stateName) {
		state = StateFactory.createState(stateName);
	}
}
