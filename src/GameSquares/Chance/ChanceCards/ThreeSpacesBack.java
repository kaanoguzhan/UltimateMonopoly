package GameSquares.Chance.ChanceCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class ThreeSpacesBack extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public ThreeSpacesBack() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.moveBy(-3);
	}

	@Override
	public String toString() {
		return "You picked ThreeSpacesBack Card.";
	}

}