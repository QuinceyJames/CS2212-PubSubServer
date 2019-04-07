package publishers.strategies;

/**
 * creates new {@link AbstractStrategy } objects contributes to the Strategy
 * design pattern implements the FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class StrategyFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static StrategyFactory INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private StrategyFactory() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static StrategyFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new StrategyFactory(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * creates a new {@link AbstractStrategy} using an entry from the
	 * {@link StrategyName} enumeration
	 * 
	 * @param strategyName a value from the {@link StrategyName} enumeration
	 *                     specifying the strategy to be created
	 * @return the newly created {@link AbstractStrategy} instance
	 */
	public AbstractStrategy createStrategy(StrategyName strategyName) {

		switch (strategyName) {
		case ALPHA_STRATEGY:
			return new AlphaStrategy();

		case BETA_STRATEGY:
			return new BetaStrategy();

		case GAMMA_STRATEGY:
			return new GammaStrategy();

		default:
			return new DefaultStrategy();
		}
	}

}
