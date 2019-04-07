package publishers.strategies;

/**
 * an enumeration of all the available
 * IStrategy names that can be created using the
 * {@link StrategyFactory#createStrategy(StrategyName)} note that normally, for
 * each new implementation of the {@link IStrategy} interface, a new entry
 * must be added here
 *  
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2, rblack43
 * 	
 */
public enum StrategyName {
	ALPHA_STRATEGY, BETA_STRATEGY, GAMMA_STRATEGY, DEFAULT_STRATEGY;
}
