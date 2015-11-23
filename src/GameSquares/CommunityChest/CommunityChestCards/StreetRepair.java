package GameSquares.CommunityChest.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;

import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class StreetRepair extends CommunityChestCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public StreetRepair() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		// $25 per cab-transit station
		// $40 per house
		// $115 per hotel
		// $100 per skyscraper.
	}

	@Override
	public String toString() {
		return "You picked Assessed for Street Repairs Card. Now you will pay $25 per cab-transit station, $40 per house $115 per hotel and $100 per skyscraper you own.";
	}

	@Override
	public String getName() {
		return "StreetRepair";
	}

}
