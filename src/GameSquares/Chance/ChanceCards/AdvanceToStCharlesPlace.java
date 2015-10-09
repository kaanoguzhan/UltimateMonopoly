package GameSquares.Chance.ChanceCards;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToStCharlesPlace extends ChanceCard {
	
	public AdvanceToStCharlesPlace() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		System.out.println(pl.getName()+" picked AdvanceToStCharlesPlace Card.");
		pl.moveTo(6);
	}
}
