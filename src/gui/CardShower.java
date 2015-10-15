package gui;

import gui.AdditionalWindows.MessageDisplayer;
import GameSquares.Chance.ChanceCard;
import GameSquares.CommunityChest.CommunityChestCard;

public class CardShower {
	
	public CardShower(ChanceCard Card) {
		new MessageDisplayer(Card.toString());
	}
	
	public CardShower(CommunityChestCard Card) {
		new MessageDisplayer(Card.toString());
	}
}
