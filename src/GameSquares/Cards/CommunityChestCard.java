package GameSquares.Cards;

import Main.Player;

public abstract class CommunityChestCard {
	
	// CommunityChestCardType type;
	
	public abstract void onDraw(Player pl);
	
	public abstract String toString();
	
	public abstract String getName();
	
}
