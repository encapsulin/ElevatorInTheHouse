package elevatorinthehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Floor {
	final int MAX_VISITORS_PER_FLOOR = 10;
	List<Visitor> visitors = new ArrayList<>();
	int number;

	public Floor(int number) {
		Random rnd = new Random();
		int visitorsCnt = rnd.nextInt(MAX_VISITORS_PER_FLOOR);		
		for(int i=0;i<visitorsCnt;i++)
			visitors.add(new Visitor());
		this.number = number;
	}

	@Override
	public String toString() {
		return "Floor "+number+"[ visitors=" + visitors.toString()
				+ "]";
	}
	
	

}
