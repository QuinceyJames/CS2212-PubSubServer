package orchestration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import publishers.AbstractPublisher;
import publishers.PublisherType;

public class Orchestration {

	private final HashMap<Integer, AbstractPublisher> publisherMap = new HashMap<>();
	private final HashMap<Integer, AbstractPublisher> subscriberMap = new HashMap<>();
	
	public Orchestration() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("Strategies.str"))) {

			String line = null;
			PublisherType[] publisherTypes = PublisherType.values();
			for (int i = 0; (line = reader.readLine()) != null; i++)
				;

		}
	}

	public static void main(String[] args) throws IOException {

	}

	public AbstractPublisher getPublisher(int publisherID) {
		return publisherMap.get(publisherID);
	}
}
