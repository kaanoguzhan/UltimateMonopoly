package GameSquares.Cards;

public abstract class CommunityChestCard implements Card {
	
	private CardType	type;
	private boolean					keepable;
	
	public CommunityChestCard(CardType type, boolean isKeepable) {
		this.type = type;
		this.keepable = isKeepable;
	}
	
	public CardType getType() {
		return type;
	}
	
	public boolean isKeepable() {
		return keepable;
	}
}
