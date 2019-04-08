package publishers;

/**
 * an enumeration of all the available Publisher types that can be created using
 * the
 * {@link PublisherFactory#createPublisher(PublisherType, publishers.strategies.StrategyName, int)}
 * note that normally, for each new implementation of the
 * {@link AbstractPublisher}, a new entry must be added here
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public enum PublisherType {
	ALPHA_PUBLISHER, BETA_PUBLISHER, GAMMA_PUBLISHER, DEFAULT_PUBLISHER;
}
