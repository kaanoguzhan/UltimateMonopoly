package GameSquares.Taxes;

import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import GameSquares.GameSquare;
import Main.Player;
import Main.Properties;

public class IncomeTax extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	public IncomeTax(int id) {
		super(id, type.IncomeTax);
	}
	
	@Override
	public void onArrive(Player pl) {
		int prc = (pl.getMoney() * Properties.INCOMETAX_PERCENT) / 100;
		boolean payAmount = new GetYesNoInput("Income Tax", "<html>Would you like to pay 200$?<br>"
			+ "If you choose no you will pay 10% of your money </html>").getValue();
		
		pl.reduceMoney(payAmount ? Properties.INCOMETAX_AMOUNT : prc);
		Main.Main.pool += payAmount ? Properties.INCOMETAX_AMOUNT : prc;
	}
	
	@Override
	public String toString() {
		return "Income Tax";
	}
	
}
