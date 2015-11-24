package GameSquares.Cards.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.Chance.ChanceCardType;
import GameSquares.Cards.ChanceCard;
import Main.Player;

public class AdvanceToSqueezePlay extends ChanceCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public AdvanceToSqueezePlay() {
		super(ChanceCardType.AdvanceToSqueezePlay, false);
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
	
	@Override
	public String getName() {
		return "Advance to SqueezePlay";
	}
}