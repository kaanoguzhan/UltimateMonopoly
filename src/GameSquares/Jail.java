package GameSquares;

import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;

public class Jail extends GameSquare {

	private static final long serialVersionUID = 1L;
	boolean getOutOfJail = false;
	int jailTimeLeft = 3;

	public Jail(int id) {
		super(id, type.Jail);
	}

	@Override
	public void onArrive(Player pl) {
		if (pl.isJailed()) {
			if (pl.hasGetOutOfJail()) {
				getOutOfJail = new GetYesNoInput("You can use GetOutOfJail Card", "Do you want to use it ?").getValue();
			} else if (getOutOfJail = new GetYesNoInput("By paying $50 fee you can get out of jail",
					"Do you want to pay ?").getValue()) {
				pl.payToPool(50);
			}
			// else if rolling double
			// else if staying there 3 rounds
			if (getOutOfJail) {
				pl.setJailed(false);
			} else {
				System.out.println("Player:" + pl.getName() + " is now in jail for " + jailTimeLeft
						+ " rounds(default).");
			}
		} else
			System.out.println("Player:" + pl.getName() + " is now visiting jail.");
	}

	@Override
	public String toString() {
		return "Jail. Location: " + id;
	}

}
