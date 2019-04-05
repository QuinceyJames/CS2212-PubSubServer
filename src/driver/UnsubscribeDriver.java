package driver;

import java.util.Scanner;

import orchestration.Orchestration;
import pubSubServer.SubscriptionManager;
import subscribers.AbstractSubscriber;

public class UnsubscribeDriver implements DriverInterface {

	@Override
	public void execute(Scanner scanner) {
		AbstractSubscriber subscriber = Orchestration.getInstance().getSubscriber(scanner.nextInt());
		SubscriptionManager.getInstance().unSubscribe(scanner.next(), subscriber);
	}
}
