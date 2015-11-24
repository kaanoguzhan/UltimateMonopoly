package GameSquares.CommunityChest.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;
import java.util.ArrayList;

import GameSquares.Cab;
import GameSquares.Land;
import GameSquares.Land.state;
import GameSquares.Ownable;
import GameSquares.TransitStation;
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
		ArrayList<Land> lands = pl.getOwnedLands();
		// ArrayList<Ownable> cabTransits=pl.getOwnedUtilities(); olacak abizi
		ArrayList<Ownable> cabTransits = new ArrayList<Ownable>();
		int cabTransit = 0;
		int houses = 0;
		int hotels = 0;
		int skyscrapers = 0;
		for (int i = 0; i < cabTransits.size(); i++) {
			if (cabTransits.get(i) instanceof Cab || cabTransits.get(i) instanceof TransitStation) {
				cabTransit++;
			}
		}
		for (int i = 0; i < lands.size(); i++) {
			if (lands.get(i).getState() == state.house)
				houses++;
			else if (lands.get(i).getState() == state.twoHouse)
				houses += 2;
			else if (lands.get(i).getState() == state.threeHouse)
				houses += 3;
			else if (lands.get(i).getState() == state.fourHouse)
				houses += 4;
			else if (lands.get(i).getState() == state.hotel)
				hotels += 1;
			else if (lands.get(i).getState() == state.skyscraper)
				skyscrapers += 1;
		}
		pl.reduceMoney(25 * cabTransit + 40 * houses + 115 * hotels + 100 * skyscrapers);
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
