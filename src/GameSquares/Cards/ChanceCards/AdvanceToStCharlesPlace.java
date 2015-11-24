package GameSquares.Cards.ChanceCards;

import java.io.Serializable;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Cards.Chance.ChanceCardType;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class AdvanceToStCharlesPlace extends ChanceCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public AdvanceToStCharlesPlace() {
		super(ChanceCardType.AdvanceToStCharlesPlace, false);
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.moveTo(6);
	}
	
	@Override
	public String toString() {
		return "You picked AdvanceToStCharlesPlace Card.";
	}
	
	@Override
	public String getName() {
		return "Advance to StCharlesPlace";
	}
}
