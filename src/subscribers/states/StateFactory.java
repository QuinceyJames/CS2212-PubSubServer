package subscribers.states;

/**
 * creates new States contributes to the State design pattern implements the
 * FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class StateFactory implements IStateFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static IStateFactory INSTANCE = null;

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
	public static IStateFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new StateFactory(); // create a new instance if null

		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see subscribers.states.IStateFactory#createState(subscribers.states.StateName)
	 */
	@Override
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
