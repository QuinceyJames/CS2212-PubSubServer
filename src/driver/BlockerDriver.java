package driver;

import java.util.Scanner;

import orchestration.Orchestration;
import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;

public class BlockerDriver implements DriverInterface {

	public void execute(Scanner scanner) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().block(subscriber, scanner.next());
	}
}
