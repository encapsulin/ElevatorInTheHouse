package elevatorinthehouse;

import java.util.LinkedList;
import java.util.Random;

class Floor {
	final int MAX_VISITORS_PER_FLOOR = 10;
	LinkedList<Visitor> visitors = new LinkedList<>();
	int number;

	public Floor() {
		
	}
	
	public Floor(int number) {
		this.number = number;
		randomVisitors();
	}
	
	public void randomVisitors() {
		Random rnd = new Random();
		int visitorsCnt = rnd.nextInt(MAX_VISITORS_PER_FLOOR);		
		for(int i=0;i<visitorsCnt;i++) {
			addRandomVisitor();
		}
	}
	
	public void addRandomVisitor() {
		Visitor visitor = new Visitor();
		while(visitor.targetFloor == this.number)
			visitor = new Visitor();
		visitors.add(visitor);
	}

	@Override
	public String toString() {
		return "Floor "+number+"[ visitors=" + visitors.toString()
				+ "]";
	}
	
	public void addVisitors(int cnt) {
		while(cnt-->0)
			visitors.add(new Visitor());
	}
	

}
