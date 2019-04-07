package driver;

import java.util.Scanner;

import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;

/**
 * A Package-Protected concrete implementation of {@link IDriverStrategy} that
 * unblocks a {@link subscribers.AbstractSubscriber Subscriber} from a
 * {@link pubSubServer.Channel Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class UnblockerDriverStrategy implements IDriverStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see driver.IDriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscovery.getInstance().findSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().unblock(subscriber, scanner.next());
	}

}
