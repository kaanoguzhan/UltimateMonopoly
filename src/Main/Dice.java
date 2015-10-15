package Main;

import java.util.Random;

public class Dice {
	public int roll() {
		return new Random().nextInt(6) + 1;
	}
	
	public int[] roll2() {
		int[] roll = { new Random().nextInt(6) + 1, new Random().nextInt(6) + 1 };
		return roll;
	}
}
