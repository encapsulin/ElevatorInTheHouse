package elevatorinthehouse;

import java.util.ArrayList;
import java.util.List;

class House {

	final int MIN_FLOORS_LIMIT = 5;
	final int MAX_FLOORS_LIMIT = 20;
	final int MAX_ELEVATOR_CAPACITY = 5;

	static int floorsCount = 3;
	Floor[] floors;
	Elevator elevator;

	public House() {
		elevator = new Elevator(MAX_ELEVATOR_CAPACITY);
		initFloors();
	}

	public void initFloors() {
		floors = new Floor[floorsCount];
		for (int i = 0; i < floorsCount; i++) {
			floors[i] = new Floor(i + 1);
		}
	}

	public void moveElevator() {
		elevator.move();
	}

	public void moveVisitorsFromElevator() {
//		int cnt = elevator.removeMatchingVisitors();
//		floor.addVisitors(cnt);
		Floor floor = floors[elevator.currentFloorIndex];
		List<Visitor> visitorsToMove = new ArrayList<>();
		for (Visitor visitor : elevator.visitors) {
			if (visitor.targetFloor == elevator.currentFloorIndex + 1) {
				visitorsToMove.add(visitor);
			}
		}

		for (Visitor visitor : visitorsToMove) {
			elevator.visitors.remove(visitor);
			floor.addRandomVisitor();
		}

	}

	public void moveVisitorsToElevator() {
		Floor floor = floors[elevator.currentFloorIndex];

		List<Visitor> visitorsToMove = new ArrayList<>();
		for (Visitor visitor : floor.visitors) {
			if (elevator.directionUp && visitor.targetFloor > floor.number
				|| !elevator.directionUp && visitor.targetFloor < floor.number) {
				visitorsToMove.add(visitor);
			} 
		}

		for (Visitor visitor : visitorsToMove) {
			if (elevator.visitors.size() < elevator.capacity) {
				elevator.visitors.add(visitor);
				floor.visitors.remove(visitor);
			}
		}
	}

	public void draw() {
		for (int i = floorsCount - 1; i >= 0; i--) {
			System.out.println();
			if (i == elevator.currentFloorIndex)
				elevator.draw();
			else
				elevator.drawEmpty();
			Floor floor = floors[i];
			System.out.print(floor);
		}

	}

}
