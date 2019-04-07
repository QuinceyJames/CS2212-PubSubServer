package orchestration.driver;

import java.util.Scanner;

import pubSub.local.SubscriberDiscoveryProxy;
import pubSub.local.SubscriptionManagerProxy;
import subscribers.AbstractSubscriber;

/**
 * A Package-Protected concrete implementation of {@link DriverInterface} used to
 * block a {@link subscribers.AbstractSubscriber Subscriber} from a
 * {@link pubSub.pubSub.server.Channel Channel}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class BlockerDriverStrategy implements IDriverStrategy {

	
	/* (non-Javadoc)
	 * @see orchestration.driver.DriverInterface#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractSubscriber subscriber = SubscriberDiscoveryProxy.getInstance().findUsingID(scanner.nextInt());
		SubscriptionManagerProxy.getInstance().block(subscriber, scanner.next());
	}
	
}
