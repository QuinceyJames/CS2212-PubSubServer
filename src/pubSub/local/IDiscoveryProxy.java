package pubSub.local;

import baseEntities.AbstractEntity;
import baseEntities.IEntity;
import publishers.AbstractPublisher;

public interface IDiscoveryProxy<T extends IEntity<Y>, Y extends Comparable<?>> {

	/**
	 * Function to find and return an {@link AbstractEntity} given an ID
	 * 
	 * @param publisherID the ID number of the looked-up publisher
	 * @return a {@link AbstractPublisher} type object corresponding the the ID
	 *         provided as input
	 */
	public T findUsingID(Y entityID);
}
