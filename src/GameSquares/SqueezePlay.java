package GameSquares;

import Main.Dice;
import Main.Player;

public class SqueezePlay extends GameSquare {

	private Player[] players = null;

	public SqueezePlay(int id, Player[] players) {
		this.id = id;
	}

	@Override
	public void onArrive(Player pl) {
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
		return "Squeeze Play. Location: " + id;
	}

}
