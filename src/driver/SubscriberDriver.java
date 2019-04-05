package driver;

import java.util.Scanner;

import orchestration.Orchestration;
import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;

public class SubscriberDriver implements DriverInterface {

	@Override
	public void execute(Scanner scanner) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().subscribe(scanner.next(), subscriber);
	}
}
