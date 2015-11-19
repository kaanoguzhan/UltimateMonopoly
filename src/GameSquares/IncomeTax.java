package GameSquares;

import Main.Player;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;

public class IncomeTax extends GameSquare {
	private static final long serialVersionUID = 1L;

	public IncomeTax(int id) {
		super(id, type.IncomeTax);
	}
	@Override
	public void onArrive(Player pl) {
		new gui.AdditionalWindows.MessageDisplayer("As income tax pay 10% of your assets or 200 to the pool");
		boolean choise = new GetYesNoInput("Pay 10% of your assets?", "If no you pay 200").getValue();
		int tax = 0;
		if(choise){
			int playerAsset = pl.getMoney();
			for(int i=0;i<pl.getOwnedLands().size();i++)
				playerAsset+=pl.getOwnedLands().get(i).getPrice();
			tax = (int) playerAsset/10;
		}else
			tax = 200;
		pl.reduceMoney(tax);
		Main.Main.pool += tax;
		System.out.println("Player "+ pl.getName()+ " payed " 
				+ Integer.toString(tax)+" as luxury tax");
	}

	@Override
	public String toString() {
		return "income tax";
	}

}
