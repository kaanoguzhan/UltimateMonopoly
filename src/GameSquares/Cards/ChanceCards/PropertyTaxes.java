package GameSquares.Cards.ChanceCards;

import java.io.Serializable;
import java.util.ArrayList;
import GameSquares.Land;
import GameSquares.Land.state;
import GameSquares.Cards.ChanceCard;
import Main.Player;
import gui.AdditionalWindows.MessageDisplayer;

public class PropertyTaxes extends ChanceCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private int tax = 5;

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		
		ArrayList<Land> lands = pl.getOwnedLands();
		int taxSum = 0;
		for(int i=0;i<lands.size();i++){
			if(lands.get(i).getState() != state.mortgage)
				taxSum+=tax;
		}
		
		pl.reduceMoney(taxSum);
		Main.Main.pool += taxSum;
	}

	@Override
	public String toString() {
		return "You picked property taxes. Pay 5$ to the pool for each unmortgaged property you own. ";
	}

}
