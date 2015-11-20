package GameSquares;

import Main.Player;
import Main.Properties;

public class PayDay extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	public PayDay(int id) {
		super(id, type.Payday);
	}
	
	public void onArrive(Player pl, int amount) {
		new gui.AdditionalWindows.MessageDisplayer(
			"You are at Bonus Square. You will collect $300 if you have rolled odd, $400 if you have rolled even or come directly.");
		if (amount % 2 != 0)
			pl.addMoney(Properties.PAYDAY_ODD);
		else
			pl.addMoney(Properties.PAYDAY_EVEN);
	}
	
	@Override
	public void onArrive(Player pl) {
	}
	
	@Override
	public String toString() {
		return "Pay Day. Location: " + id;
	}
}
