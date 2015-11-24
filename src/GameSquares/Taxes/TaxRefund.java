package GameSquares.Taxes;

import GameSquares.GameSquare;
import Main.Main;
import Main.Player;
import Main.Properties;

public class TaxRefund extends GameSquare {
	private static final long serialVersionUID = 1L;

	public TaxRefund(int id) {
		super(id, type.TaxRefund);
	}

	@Override
	public void onArrive(Player pl) {
		pl.obtainPool();
		System.out.println("Player " + pl.getName() + " recieved "
				+ Integer.toString(Main.pool * Properties.TAX_REFUND_PERCENT / 100) + " from the pool as tax refund");
	}

	@Override
	public String toString() {
		return "Tax Refund";
	}

}
