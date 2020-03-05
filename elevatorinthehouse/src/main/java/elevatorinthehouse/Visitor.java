package elevatorinthehouse;

import java.util.Random;

class Visitor {
	int targetFloor;

	public Visitor() {
		Random rnd = new Random();
		targetFloor = 1 + rnd.nextInt(House.floorsCount);
	}
	
	public Visitor(int targetFloor) {
		this.targetFloor = targetFloor;
	}

	@Override
	public String toString() {
		return targetFloor+"";
	}
}
