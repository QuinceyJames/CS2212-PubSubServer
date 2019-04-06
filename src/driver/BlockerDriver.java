package driver;

import java.util.Scanner;

import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;

/**
 * A Package-Protected concrete implementation of {@link DriverStrategyInterface} used to
 * block a {@link subscribers.AbstractSubscriber} from a
 * {@link pubSubServer.Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class BlockerDriver implements DriverStrategyInterface {

	
	/* (non-Javadoc)
	 * @see driver.DriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscovery.getInstance().findSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().block(subscriber, scanner.next());
	}
	
}
