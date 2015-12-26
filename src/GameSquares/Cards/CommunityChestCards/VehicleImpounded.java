package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.Cards.CommunityChestCard;
import Main.Player;

public class VehicleImpounded extends CommunityChestCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public VehicleImpounded() {
		super(CardType.VehicleImpounded, false);
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.payToPool(50);
		pl.moveTo(20);
		pl.LoseTurn(true);
	}

	public String toString() {
		return "You picked VehicleImpounded Card.";
	}

	@Override
	public String getName() {
		return "Vehicle Impounded";
	}

}
