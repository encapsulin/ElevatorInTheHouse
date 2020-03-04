package elevatorinthehouse;

import java.util.Random;

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
			 for(int i=0; i<floorsCount;i++) {
				 floors[i] = new Floor(i+1);
			 }
	 }
	 
	 public void proceed() {
		 moveVisitorsToFromElevator();
		 moveElevator();		 
		 draw();
	 }
	 
	 private void moveElevator() {
		// TODO Auto-generated method stub
		 elevator.move();
	}

	private void moveVisitorsToFromElevator() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		 for(int i=floorsCount-1;i>=0 ;i--) {
			 System.out.println();
			 if(i==elevator.currentFloor)
				 elevator.draw();
			 else 
				 elevator.drawEmpty();
			 Floor floor = floors[i];
			 System.out.print(floor);
		 }
		 
	 }
		
}
