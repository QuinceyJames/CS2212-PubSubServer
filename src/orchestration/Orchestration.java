package orchestration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import publishers.AbstractPublisher;
import publishers.PublisherType;
import subscribers.AbstractSubscriber;

public class Orchestration {
	private static Orchestration INSTANCE = null;
	private final HashMap<Integer, AbstractPublisher> publisherMap = new HashMap<>();
	private final HashMap<Integer, AbstractSubscriber> subscriberMap = new HashMap<>();
	
	private Orchestration() {
		try (BufferedReader reader = new BufferedReader(new FileReader("Strategies.str"))) {

			String line = null;
			PublisherType[] publisherTypes = PublisherType.values();
			for (int i = 0; (line = reader.readLine()) != null; i++)
				;

		} catch (Exception e) {
			System.err.println("Cannot find Strategies.str");
			System.exit(1);
		}
	}

	public static void main(String[] args) throws IOException {

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
