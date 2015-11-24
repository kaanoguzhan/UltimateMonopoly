package GameSquares.Cards;

import GameSquares.Cards.CommunityChest.CommunityChestCardType;

public abstract class CommunityChestCard implements Card {
	
	private CommunityChestCardType	type;
	private boolean					keepable;
	
	public CommunityChestCard(CommunityChestCardType type, boolean isKeepable) {
		this.type = type;
		this.keepable = isKeepable;
	}
	
	public CommunityChestCardType getType() {
		return type;
	}
	
	public boolean isKeepable() {
		return keepable;
	}
}
