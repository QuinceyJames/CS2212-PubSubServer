package driver;

import java.util.Scanner;

/**
 * A class that chooses which {@link DriverStrategy} should be used based on the
 * first word of the command line that is sent to {@link #createDriver(String)}
 *
 */
public class DriverStrategySelector {

	public static void createDriver(String line) {
		Scanner scanner = new Scanner(line);

		switch (scanner.next().toUpperCase()) {
		case "PUB":
			new PublisherDriver().executeDriverStrategy(scanner);
			break;
		case "SUB":
			new SubscriberDriver().executeDriverStrategy(scanner);
			break;
		case "UNSUB":
			new UnsubscribeDriver().executeDriverStrategy(scanner);
			break;
		case "BLOCK":
			new BlockerDriver().executeDriverStrategy(scanner);
			break;
		case "UNBLOCK":
			new UnblockerDriver().executeDriverStrategy(scanner);
			break;
		default:
			System.err.println("UNKNOWN COMMAND");
		}

	}
}
