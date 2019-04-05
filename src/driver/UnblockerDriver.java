package driver;

import java.util.StringTokenizer;

import orchestration.Orchestration;
import publishers.AbstractPublisher;
import subscribers.AbstractSubscriber;
import pubSubServer.ChannelAccessControl;
import pubSubServer.SubscriptionManager;

public class UnblockerDriver {
	public void execute(StringTokenizer tokenizer) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(Integer.parseInt(tokenizer.nextToken()));
		String channelName = tokenizer.nextToken();
		SubscriptionManager.getInstance().Unblock(subscriber, channelName);

}
}
