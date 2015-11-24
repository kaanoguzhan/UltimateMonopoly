package GameSquares.Cards;

import GameSquares.Cards.Chance.ChanceCardType;

public abstract class ChanceCard implements Card {
	
	private ChanceCardType	type;
	private boolean			keepable;
	
	public ChanceCard(ChanceCardType type, boolean isKeepable) {
		this.type = type;
		this.keepable = isKeepable;
	}
	
	public ChanceCardType getType() {
		return type;
	}
	
	public boolean isKeepable() {
		return keepable;
	}
}
