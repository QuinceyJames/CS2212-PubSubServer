package subscribers.states;

/**
 * an enumeration of all the available IState names that can be created using
 * the {@link StateFactory#createState(StateName)} note that normally, for each
 * new implementation of {@link AbstractState}, a new entry must be added here
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public enum StateName {
	ALPHA_STATE, BETA_STATE, GAMMA_STATE, DEFAULT_STATE;
}
