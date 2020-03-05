package elevatorinthehouse;

import java.util.ArrayList;
import java.util.List;

class Elevator {

	int capacity = 5;
	int currentFloor;
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
			s += visitor.targetFloor + ".";

		for (int i = 0; i < capacity - visitors.size(); i++)
			s += "  .";
		s += cDirection + "|";

		System.out.print(s);
	}

	public void drawEmpty() {
		System.out.print("|                 |");
	}

	public void move() {
		if (directionUp) {
			if (currentFloor < House.floorsCount-1)
				currentFloor++;
			else if (currentFloor == House.floorsCount-1) {
				currentFloor--;
				directionUp = !directionUp;
			}
		}else {
			if (currentFloor > 0)
				currentFloor--;
			else if (currentFloor == 0) {
				currentFloor++;
				directionUp = !directionUp;
			}
		}
	}
	
	int removeMatchingVisitors() {
		int cnt = 0;
		for(Visitor visitor:visitors) {
			if(this.currentFloor == visitor.targetFloor) {
				cnt++;
				visitors.remove(visitor);
			}
		}
		return cnt;
	}
	
	boolean isEmpty() {
		return visitors.size() == 0;
	}
	}

}
