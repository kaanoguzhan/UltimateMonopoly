package Main;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
	public static boolean bus = false, monopolyGuy = false;

	public int roll() {
		return new Random().nextInt(6) + 1;
	}

	public int[] roll2() {
		int[] roll = { new Random().nextInt(6) + 1, new Random().nextInt(6) + 1 };
		return roll;
	}

	public ArrayList<Integer> rollWithSpeedDie() {
		ArrayList<Integer> roll = new ArrayList<Integer>();
		roll.add(new Random().nextInt(6) + 1);
		roll.add(new Random().nextInt(6) + 1);
		int rollSpeed = (new Random().nextInt(6) + 1);
		switch (rollSpeed) {
		case 1:
		case 2:
		case 3:
			roll.add(rollSpeed);
			bus = false;
			monopolyGuy = false;
			break;
		case 4:
		case 5:
			bus = false;
			monopolyGuy = true;
			break;
		case 6:
			bus = true;
			monopolyGuy = false;
			break;
		}
		return roll;
	}

	public static boolean isMonopolyGuy() {
		return monopolyGuy;
	}

	public static boolean isBus() {
		return bus;
	}

}
