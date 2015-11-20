package GameSquares.Chance.ChanceCards;

import java.io.Serializable;
import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToSqueezePlay extends ChanceCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public AdvanceToSqueezePlay() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.moveTo(96);
	}
	
	@Override
	public String toString() {
		return "You picked AdvanceToSqueezePlay Card.";
	}
}
