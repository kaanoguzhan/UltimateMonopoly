package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import GameSquares.Land;
import GameSquares.Cards.CommunityChestCard;
import GameSquares.Cards.CommunityChest.CommunityChestCardType;
import Main.Player;

public class HouseCondemned extends CommunityChestCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public HouseCondemned() {
		super(CommunityChestCardType.HouseCondemned,false);
	}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		ArrayList<Land> lands = pl.getOwnedLands();
		ArrayList<Land> housed = new ArrayList<Land>();
		for (int i = 0; i < lands.size(); i++) {
			if (lands.get(i).isHoused())
				housed.add(lands.get(i));
		}
		Random rgen = new Random();
		int condemnedHoused = rgen.nextInt(housed.size());
		Land condemned = housed.get(condemnedHoused);
		pl.addMoney(condemned.getPriceOfState() / 2);
		condemned.downgrade();
	}

	@Override
	public String toString() {
		return "You picked House Condemned Card. Sell a house 1/2 price you paid for it. (Do nothing if you have no houses)";
	}

	@Override
	public String getName() {
		return "House Condemned";
	}

}