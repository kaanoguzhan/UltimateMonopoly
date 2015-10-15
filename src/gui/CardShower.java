package gui;

import javax.swing.JOptionPane;

import GameSquares.Chance.ChanceCard;
import GameSquares.CommunityChest.CommunityChestCard;

public class CardShower {

	public CardShower(ChanceCard Card) {
		JOptionPane.showMessageDialog(null, Card.toString());
	}

	public CardShower(CommunityChestCard Card) {
		JOptionPane.showMessageDialog(null, Card.toString());
	}
}
