package GameSquares.Cards;

import GameSquares.GameSquare;
import Main.Player;

public class Chance extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	public enum ChanceCardType {
		AdvanceToSqueezePlay, AdvanceToStart, AdvanceToStCharlesPlace, AdvanceToTheNearestRailroad,
		AdvanceToTheNearestUtility, ElectedAsChairPerson, GeneralRepairs, GetOutOfJail, GoToJail,
		Hurricane, MargiGras, PropertyTaxes, SchoolFees, ThreeSpacesBack
	}
	
	private ChanceDeck	ChanceDeck	= null;
	
	public Chance(int id, ChanceDeck ChanceDeck, Player[] players) {
		super(id, type.Chance);
		this.ChanceDeck = ChanceDeck;
	}
	
	@Override
	public void onArrive(Player pl) {
		ChanceCard card = ChanceDeck.draw();
		card.onDraw(pl);
	}
	
	@Override
	public String toString() {
		return "Chance. Location: " + id;
	}
	
}
