package pubSub.local;

import baseEntities.IEntity;

public interface IDiscoveryProxy<T extends IEntity<Y>, Y extends Comparable<?>> {

	/**
	 * Function to find and return an {@link IEntity} given an ID
	 * 
	 * @param entityID the ID number of the looked-up publisher
	 * @return a {@link IEntity} type object corresponding the the ID
	 *         provided as input
	 */
	public T findUsingID(Y entityID);
}
