package driver;

import java.util.StringTokenizer;

import orchestration.Orchestration;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;

public class UnSubscribeDriver implements DriverInterface {

		@Override
		public void execute(StringTokenizer tokenizer) {
			AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(Integer.parseInt(tokenizer.nextToken()));
			String channelName = tokenizer.nextToken();
			AbstractChannel channel = ChannelDiscovery.getInstance().findChannel(channelName);
				
			if (channel != null) {
				SubscriptionManager.getInstance().unSubscribe(channelName, subscriber);
			}		
		}
}
