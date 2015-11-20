package GameSquares.Taxes;

import GameSquares.GameSquare;
import Main.Player;
import Main.Properties;

public class TaxRefund extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	public TaxRefund(int id) {
		super(id, type.TaxRefund);
	}
	@Override
	public void onArrive(Player pl) {
		Main.Main.pool = (Main.Main.pool * Properties.TAX_REFUND_PECENT) / 100;
		pl.addMoney((Main.Main.pool * Properties.TAX_REFUND_PECENT) / 100);
		System.out.println("Player "+ pl.getName()+ " recieved " 
			+ Integer.toString(Main.Main.pool/2)+" from the pool as tax refund");
	}
	
	@Override
	public String toString() {
		return "Tax Refund";
	}
	
}