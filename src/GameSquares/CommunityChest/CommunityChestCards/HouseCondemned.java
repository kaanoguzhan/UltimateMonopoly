package GameSquares.CommunityChest.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import GameSquares.Land;
import GameSquares.Land.state;
import GameSquares.CommunityChest.CommunityChestCard;
import Main.Player;

public class HouseCondemned extends CommunityChestCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public HouseCondemned() {
		super();
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		ArrayList<Land> lands = pl.getOwnedLands();
		ArrayList<Land> houses = new ArrayList<Land>();
		for (int i = 0; i < lands.size(); i++) {
			if (lands.get(i).getState() == state.house)
				houses.add(lands.get(i));
		}
		Random rgen = new Random();
		int condemnedHouse = rgen.nextInt(houses.size());
		houses.get(condemnedHouse);
		// sell a house randomly.
	}

	@Override
	public String toString() {
		return "You picked House Condemned Card. Sell a house 1/2 price you paid for it. (Do nothing if you have no houses)";
	}

	@Override
	public String getName() {
		return "HouseCondemned";
	}

}
