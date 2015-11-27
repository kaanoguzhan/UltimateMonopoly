package GameSquares.Cards;


public abstract class ChanceCard implements Card {
	
	private CardType	type;
	private boolean			keepable;
	
	public ChanceCard(CardType type, boolean isKeepable) {
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
