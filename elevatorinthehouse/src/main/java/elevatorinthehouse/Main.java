package elevatorinthehouse;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("main");
		House house = new House();
		int i = 0;
		while(true) {
			System.out.printf("\n*** Step %d ***",i++);
			house.proceed();
			System.out.printf("\n(press Enter to continue)");
			System.in.read();			
		}
	}

}
