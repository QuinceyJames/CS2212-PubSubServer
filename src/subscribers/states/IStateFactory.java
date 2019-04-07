package subscribers.states;

public interface IStateFactory {

	/**
	 * creates a new {@link AbstractState} using an entry from the {@link StateName}
	 * enumeration
	 * 
	 * @param stateName a value from the {@link StateName} enumeration specifying
	 *                  the state to be created
	 * @return the newly created {@link AbstractState} instance
	 */
	AbstractState createState(StateName stateName);

}