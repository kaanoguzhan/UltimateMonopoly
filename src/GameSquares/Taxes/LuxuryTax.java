package GameSquares.Taxes;

import GameSquares.GameSquare;
import Main.Player;
import Main.Properties;

public class LuxuryTax extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	public LuxuryTax(int id) {
		super(id, type.LuxuryTax);
	}
	
	@Override
	public void onArrive(Player pl) {
		pl.reduceMoney(Properties.LUXURYTAX_AMOUNT);
		Main.Main.pool += Properties.LUXURYTAX_AMOUNT;
		System.out.println("Player " + pl.getName() + " payed "
			+ Integer.toString(Properties.LUXURYTAX_AMOUNT) + " as luxury tax");
	}
	
	@Override
	public String toString() {
		return "Luxury Tax";
	}
	
}
