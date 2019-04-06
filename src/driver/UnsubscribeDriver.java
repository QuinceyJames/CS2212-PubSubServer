package driver;

import java.util.Scanner;

import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;

public class UnsubscribeDriver implements DriverStrategy {

	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscovery.getInstance().findSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().unSubscribe(scanner.next(), subscriber);
	}
}
