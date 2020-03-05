package elevatorinthehouse;

import java.util.ArrayList;
import java.util.List;

class Elevator {

	int capacity = 5;
	int currentFloorIndex;
	List<Visitor> visitors = new ArrayList<>();
	boolean directionUp = true;

	public Elevator(int capacity) {
		super();
		this.capacity = capacity;
	}

	public void draw() {
		String s = "|";
		Character cDirection = '^';
		if (!directionUp)
			cDirection = 'v';
		s += cDirection;

		for (Visitor visitor : visitors)
			s += visitor.targetFloor + ". ";

		for (int i = 0; i < capacity - visitors.size(); i++)
			s += "  .";
		s += cDirection + "|";

		System.out.print(s);
	}

	public void drawEmpty() {
		System.out.print("|                 |");
	}

	public void move1() {
		if (directionUp) {
			if (currentFloorIndex < House.floorsCount)
				currentFloorIndex++;
			if (currentFloorIndex == House.floorsCount) {
				currentFloorIndex--;
				directionUp = !directionUp;
			}
		} else {
			if (currentFloorIndex > 0)
				currentFloorIndex--;
			else if (currentFloorIndex == 0) {
				currentFloorIndex++;
				directionUp = !directionUp;
			}
		}
	}

	public void move() {
		if (directionUp)
			currentFloorIndex++;
		else
			currentFloorIndex--;

		if (currentFloorIndex >= House.floorsCount) {
			currentFloorIndex--;
		}
		if (currentFloorIndex >= House.floorsCount -1) {
			directionUp = !directionUp;
		}		

		if (currentFloorIndex < 0) {
			currentFloorIndex++;
		}
		if (currentFloorIndex == 0) {
			directionUp = !directionUp;
		}		

	}

}
