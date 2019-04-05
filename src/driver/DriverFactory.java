package driver;

import java.util.Scanner;

public class DriverFactory {

	public static void createDriver(String line) {
		Scanner scanner = new Scanner(line);
		switch (scanner.next().toUpperCase()) {
		case "PUB":
			new PublisherDriver().execute(scanner);
			break;
		case "SUB":
			new SubscriberDriver().execute(scanner);
			break;
		case "UNSUB":
			new UnsubscribeDriver().execute(scanner);
			break;
		case "BLOCK":
			new BlockerDriver().execute(scanner);
			break;
		case "UNBLOCK":
			new UnblockerDriver().execute(scanner);
			break;
		default:
			System.err.println("UNKNOWN COMMAND");
		}
	}
}
