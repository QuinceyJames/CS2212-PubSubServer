package orchestration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import driver.DriverStrategySelector;

/**
 * This class serves as the entry point to the pubSub server by reading in 
 * the Driver file and calling the Driver Package
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class Orchestration {

	private Orchestration() {
		try (Scanner scanner = new Scanner(new File("Driver.dvr"))) {
			while (scanner.hasNextLine()) //continue until Driver text file has been depleted
				DriverStrategySelector.executeCommand(scanner.nextLine()); //call Driver

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Orchestration(); 
	}

}
