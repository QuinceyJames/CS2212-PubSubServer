package driver;

import java.util.StringTokenizer;

import orchestration.Orchestration;
import subscribers.AbstractSubscriber;
import pubSubServer.AbstractChannel;
import pubSubServer.SubscriptionManager;
import pubSubServer.ChannelDiscovery;

public class UnblockerDriver {
	public void execute(StringTokenizer tokenizer) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(Integer.parseInt(tokenizer.nextToken()));
		String channelName = tokenizer.nextToken();
		AbstractChannel channel = ChannelDiscovery.getInstance().findChannel(channelName);
		if (channel != null) {
		SubscriptionManager.getInstance().Unblock(subscriber, channelName);
		}

}
}
