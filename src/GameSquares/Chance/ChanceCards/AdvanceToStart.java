package GameSquares.Chance.ChanceCards;

import java.io.Serializable;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToStart extends ChanceCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public AdvanceToStart() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.moveTo(0);
		
	}
	
	@Override
	public String toString() {
		return "You picked AdvanceToStart Card.";
	}
}
