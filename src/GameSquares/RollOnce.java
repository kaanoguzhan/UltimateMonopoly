package GameSquares;

import Main.Dice;

public class RollOnce extends GameSquare {

	public RollOnce(int id) {
		this.id = id;
	}

	@Override
	public void onArrive() {
		Dice dice = new Dice();

		System.out.println("Please roll a die and get a roll once card. If the numbers match, you will get $100.");

		int roll = dice.roll();
		System.out.println("You rolled: " + roll); // GUI rolling die
		int card = dice.roll();
		System.out.println("Card shows: " + card); // GUI showing card
		if (roll == card) {
			// Player gets $100
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
