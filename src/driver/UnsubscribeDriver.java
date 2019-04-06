package driver;

import java.util.Scanner;

import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;

/**
 * A Package-Protected concrete implementation of {@link DriverStrategy} that
 * unsubscribes a {@link subscribers.AbstractSubscriber Subscriber} from a
 * {@link pubSubServer.Channel Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class UnsubscribeDriver implements DriverStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see driver.DriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscovery.getInstance().findSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().unSubscribe(scanner.next(), subscriber);
	}
}
