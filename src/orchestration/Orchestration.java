package orchestration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import driver.DriverFactory;
import publishers.AbstractPublisher;
import publishers.PublisherFactory;
import publishers.PublisherType;
import states.subscriber.StateName;
import strategies.publisher.StrategyName;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberFactory;
import subscribers.SubscriberType;

public class Orchestration {
	private static Orchestration INSTANCE = null;

	private Orchestration() {
		try {
			runDriver();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	private void runDriver() throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("Driver.dvr"))) {

			while (scanner.hasNextLine())
				DriverFactory.createDriver(scanner.nextLine());

		}
	}

	public static void main(String[] args) throws IOException {
		new Orchestration();
	}

	public AbstractPublisher getPublisher(int publisherID) {
		return publisherMap.get(publisherID);
	}

	public AbstractSubscriber getSubscriber(int subscriberID) {
		return subscriberMap.get(subscriberID);
	}

	public static Orchestration getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Orchestration();

		return INSTANCE;
	}

}
