import stanford.karel.*;

public class DefendDemocracyKarel extends SuperKarel {
	
	public void run() {
		while (frontIsClear()) {
			if (checkMiddleBeeper()) {
				cleanExtraBeepers();
			}
			
			move();
		}
		
		if (checkMiddleBeeper()) {
			cleanExtraBeepers();
		}
	}
	
	private boolean checkMiddleBeeper() {
		if (noBeepersPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	private void cleanExtraBeepers() {
		cleanNorthBeepers();
		cleanSouthBeepers();
	}
	
	private void cleanNorthBeepers() {
		turnLeft();
		move();
		
		while (beepersPresent()) {
			pickBeeper();
		}
		
		turnAround();
		move();
		turnLeft();
	}
	
	private void cleanSouthBeepers() {
		turnRight();
		move();
		
		while (beepersPresent()) {
			pickBeeper();
		}
		
		turnAround();
		move();
		turnRight();
	}
}
