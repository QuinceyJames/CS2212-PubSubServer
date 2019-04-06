package driver;

import java.util.Scanner;

import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;

public class UnblockerDriver implements DriverStrategy {
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscovery.getInstance().findSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().unblock(subscriber, scanner.next());
	}
}
