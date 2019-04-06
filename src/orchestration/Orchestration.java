package orchestration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import driver.DriverStrategySelector;

public class Orchestration {

	private Orchestration() {
		try (Scanner scanner = new Scanner(new File("Driver.dvr"))) {
			while (scanner.hasNextLine())
				DriverStrategySelector.executeCommand(scanner.nextLine());

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Orchestration();
	}

}
