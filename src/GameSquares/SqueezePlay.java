package GameSquares;

import Main.Dice;

public class SqueezePlay extends GameSquare {

	public SqueezePlay(int id) {
		this.id = id;
	}

	@Override
	public void onArrive() {
		Dice dice = new Dice();

		System.out.println("Please roll a die and get $200 from everyone if the number is even.");

		int roll = dice.roll();
		System.out.println("You rolled: " + roll); // GUI rolling die
		if ((roll % 2) == 0) {
			// Player gets $200 from everyone
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
