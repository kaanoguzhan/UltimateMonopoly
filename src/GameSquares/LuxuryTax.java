package GameSquares;

import Main.Player;

public class LuxuryTax extends GameSquare{
	private static final long	serialVersionUID	= 1L;
	
	private static final int taxAmount = 75;
	
	public LuxuryTax(int id) {
		super(id, type.LuxuryTax);
	}
	
	@Override
	public void onArrive(Player pl) {
		pl.reduceMoney(taxAmount);
		Main.Main.pool += taxAmount;
		System.out.println("Player "+ pl.getName()+ " payed " 
				+ Integer.toString(taxAmount)+" as luxury tax");
	}

	@Override
	public String toString() {
		return "luxury tax";
	}
	
}
