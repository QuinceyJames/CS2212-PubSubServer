package orchestration.driver;

import java.util.Scanner;

import pubSub.local.SubscriberDiscoveryProxy;
import pubSub.local.SubscriptionManagerProxy;
import subscribers.ISubscriber;

/**
 * A Package-Protected concrete implementation of {@link DriverInterface} that
 * subscribes a {@link subscribers.AbstractSubscriber Subscriber} to a
 * {@link pubSub.pubSub.server.Channel Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class SubscriberDriverStrategy implements IDriverStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * orchestration.driver.IDriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		ISubscriber subscriber = SubscriberDiscoveryProxy.getInstance().findUsingID(scanner.nextInt());
		SubscriptionManagerProxy.getInstance().subscribe(scanner.next(), subscriber);
	}
}
