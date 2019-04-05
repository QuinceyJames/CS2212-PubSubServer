package driver;

import java.util.StringTokenizer;
import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import orchestration.Orchestration;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelCreator;
import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import pubSubServer.ChannelDiscovery;

public class SubscriberDriver implements DriverInterface {
	
	@Override
	public void execute(StringTokenizer tokenizer) {
		
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(Integer.parseInt(tokenizer.nextToken()));
		String channelName = tokenizer.nextToken();
		AbstractChannel channel = ChannelDiscovery.getInstance().findChannel(channelName);
		
		if (channel != null) {
			SubscriptionManager.getInstance().subscribe(channelName, subscriber);
		}		
	}
}
