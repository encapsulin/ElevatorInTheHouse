package elevatorinthehouse;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("main");
		House house = new House();
		int i = 1;
		while (true) {
			System.out.printf("\n*** Step %d.1: moveVisitorsFromElevator() ***", i);
			house.moveVisitorsFromElevator();
			house.draw();
			System.out.printf("\n(press Enter to continue)");
			System.in.read();

			System.out.printf("\n*** Step %d.2: moveVisitorsToElevator() ***", i);
			house.moveVisitorsToElevator();
			house.draw();
			System.out.printf("\n(press Enter to continue)");
			System.in.read();

			System.out.printf("\n*** Step %d.3: moveElevator() ***", i);
			house.moveElevator();
			house.draw();
			System.out.printf("\n(press Enter to continue)");
			System.in.read();
			i++;
		}
	}

}
