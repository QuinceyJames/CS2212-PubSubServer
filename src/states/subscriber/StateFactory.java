package states.subscriber;

/**
 * creates new States contributes to the State design pattern implements the
 * FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class StateFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static StateFactory INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private StateFactory() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static StateFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new StateFactory(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * creates a new {@link AbstractState} using an entry from the {@link StateName}
	 * enumeration
	 * 
	 * @param stateName a value from the {@link StateName} enumeration specifying
	 *                  the state to be created
	 * @return the newly created {@link AbstractState} instance
	 */
	public AbstractState createState(StateName stateName) {
		switch (stateName) {
		case ALPHA_STATE:
			return new AlphaState();

		case BETA_STATE:
			return new BetaState();

		case GAMMA_STATE:
			return new GammaState();

		default:
			return new DefaultState();
		}
	}

}
