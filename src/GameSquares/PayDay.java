package GameSquares;

import Main.Player;

public class PayDay extends GameSquare {
	private static final long serialVersionUID = 1L;
	private final int oddPayDayMoney = 300;
	private final int evenPayDayMoney = 400;
	private int diceRolled;

	public PayDay(int id) {
		super(id, type.Payday);
	}

	@Override
	public void onArrive(Player pl) {
		new gui.AdditionalWindows.MessageDisplayer(
				"You are at Bonus Square. You will collect $300 if you have rolled odd, $400 if you have rolled even or come directly.");
		if (diceRolled % 2 != 0)
			pl.addMoney(oddPayDayMoney);
		else
			pl.addMoney(evenPayDayMoney);
	}

	@Override
	public String toString() {
		return "Pay Day. Location: " + id;
	}

}
