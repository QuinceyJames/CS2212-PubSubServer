package subscribers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pubSubServer.AbstractChannel;
import states.subscriber.StateName;


/**
 * @author kkontog, ktsiouni, mgrigori
 *  
 *  implements the Singleton Design Pattern
 *  
 *  holds the collection of AbstractChannel type entities and provides the methods for manipulating thes collections
 */
public class SubscriberPoolManager {

	private static SubscriberPoolManager instance = null;
	private Map<Integer, AbstractSubscriber> subscribersMap = new HashMap<Integer, AbstractSubscriber>();

	private SubscriberPoolManager() {
		//from orcestration
	}

	protected static SubscriberPoolManager getInstance() {
		if (instance == null)
			instance = new SubscriberPoolManager();
		return instance;
	}
	
	/**
	 * can be used to list all the Channels available in the PubSubServer
	 * @return a list of type {@link AbstractChannel}
	 */
	protected Map<Integer, AbstractSubscriber> listSubscribers() {
		return subscribersMap;
	}

	
	/**
	 * returns the object of AbstractChannel using a name as lookup information
	 * @param channelName the name of the AbstractChannel to be returned
	 * @return the appropriate instance of an AbstractChannel subclass
	 */
	protected AbstractSubscriber findSubscriber(Integer subscriberID) {
		return subscribersMap.get(subscriberID);
	}	
}

