package driver;

import java.util.Scanner;

import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;

/**
 * A Package-Protected concrete implementation of {@link IDriverStrategy} that
 * subscribes a {@link subscribers.AbstractSubscriber Subscriber} to a
 * {@link pubSubServer.Channel Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class SubscriberDriverStrategy implements IDriverStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see driver.IDriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscovery.getInstance().findSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().subscribe(scanner.next(), subscriber);
	}
}
