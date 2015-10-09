package GameSquares.Chance.ChanceCards;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToStart extends ChanceCard {

	public AdvanceToStart() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		System.out.println(pl.getName()+" picked AdvanceToStart Card.");
		pl.moveTo(0);
		
	}
}
