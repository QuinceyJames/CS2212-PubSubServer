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
	private final HashMap<Integer, AbstractPublisher> publisherMap = new HashMap<>();
	private final HashMap<Integer, AbstractSubscriber> subscriberMap = new HashMap<>();

	private Orchestration() {
		try {
			loadStrategies();
			loadStates();
			runDriver();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	private void loadStrategies() throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("Strategies.str"))) {

			for (int publisherID = 0; scanner.hasNextLine(); publisherID++) {
				PublisherType publisherType = PublisherType.values()[scanner.nextInt()];
				StrategyName strategyName = StrategyName.values()[scanner.nextInt()];

				publisherMap.put(publisherID, PublisherFactory.createPublisher(publisherType, strategyName));
			}

		}
	}

	private void loadStates() throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("States.sts"))) {

			for (int subscriberID = 0; scanner.hasNextLine(); subscriberID++) {
				SubscriberType subscriberType = SubscriberType.values()[scanner.nextInt()];
				StateName stateName = StateName.values()[scanner.nextInt()];

				subscriberMap.put(subscriberID, SubscriberFactory.createSubscriber(subscriberType, stateName));
			}

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
