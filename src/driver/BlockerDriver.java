package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import orchestration.Orchestration;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.SubscriptionManager;
import pubSubServer.ChannelAccessControl;
import subscribers.AbstractSubscriber;

public class BlockerDriver {
	
	public void execute(StringTokenizer tokenizer) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(Integer.parseInt(tokenizer.nextToken()));
		String channelName = tokenizer.nextToken().trim();
		AbstractChannel channel = ChannelDiscovery.getInstance().findChannel(channelName);
		if (channel != null) {
			SubscriptionManager.getInstance().Block(subscriber, channelName);
		}
		
		
		
	}
}
