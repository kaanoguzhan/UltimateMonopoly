package GameSquares.CommunityChest;

import Main.Player;

public abstract class CommunityChestCard {
	
	public abstract void onDraw(Player pl);
	
	public abstract String toString();
	
	public abstract String getName();
}
