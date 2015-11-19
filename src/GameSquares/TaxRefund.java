package GameSquares;

import Main.Player;

public class TaxRefund extends GameSquare {
	private static final long serialVersionUID = 1L;
	
	public TaxRefund(int id) {
		super(id, type.TaxRefund);
	}
	@Override
	public void onArrive(Player pl) {
		Main.Main.pool = Main.Main.pool/2;
		pl.addMoney(Main.Main.pool/2);
	}

	@Override
	public String toString() {
		return "tax refund";
	}

}
