package elevatorinthehouse;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Floor {
	final int MAX_VISITORS_PER_FLOOR = 10;
	LinkedList<Visitor> visitors = new LinkedList<Visitor>();
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
		for (int i = 0; i < visitorsCnt; i++) {
			addRandomVisitor();
		}
	}

	public void addRandomVisitor() {
		Visitor visitor = new Visitor();
		while (visitor.targetFloor == this.number)
			visitor = new Visitor();
		visitors.add(visitor);
	}

	@Override
	public String toString() {
		return "Floor " + number + "[ visitors=" + visitors.toString() + "]";
	}

	public void addVisitors(int cnt) {
		while (cnt-- > 0)
			visitors.add(new Visitor());
	}

	void sortVisitorsByTheirTargetFloor() {
		Map<Integer, Integer> unSortedMap = new HashMap<>();

		for (Visitor visitor : this.visitors) {
			Integer val = unSortedMap.get(visitor.targetFloor);
			if (val == null)
				val = 0;
			unSortedMap.put(visitor.targetFloor, val + 1);
		}
	
		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
		
		visitors = new LinkedList<Visitor>();
		reverseSortedMap.keySet().forEach(key->{
			int value = reverseSortedMap.get(key);
			while(value-- > 0)
				visitors.add(new Visitor(key));
		});

	}

}
