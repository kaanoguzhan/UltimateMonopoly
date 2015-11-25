package gui.Debug;

import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import GameSquares.Land;
import GameSquares.Ownable;
import GameSquares.Cards.ChanceCard;
import GameSquares.Cards.CommunityChestCard;
import Main.Admin;
import Main.Main;
import Main.Player;

public class DicePanel extends JPanel {
	private static final long	serialVersionUID	= 1L;
	public static int			Die1, Die2, SpeedDie;
	public static boolean		chcbxTicked;
	public static boolean		chcbxExist			= false;
	public static Choice		chcOwnables;
	public static int			currentPlayerID;
	
	public DicePanel() {
		setLayout(null);
		
		JTextField txtDie1 = new JTextField();
		txtDie1.setBounds(12, 10, 116, 22);
		add(txtDie1);
		
		JTextField txtDie2 = new JTextField();
		txtDie2.setBounds(140, 10, 116, 22);
		add(txtDie2);
		
		JTextField txtSpeedDie = new JTextField();
		txtSpeedDie.setBounds(268, 10, 116, 22);
		add(txtSpeedDie);
		
		txtDie1.setText(Die1 + "");
		txtDie2.setText(Die2 + "");
		txtSpeedDie.setText(SpeedDie + "");
		
		JCheckBox chckbxSetDice = new JCheckBox("Fix Dice");
		chckbxSetDice.setBounds(392, 9, 69, 25);
		chckbxSetDice.addActionListener(al -> {
			if (chcbxTicked)
				chcbxTicked = false;
			else
				chcbxTicked = true;
			Die1 = Integer.parseInt(txtDie1.getText());
			Die2 = Integer.parseInt(txtDie2.getText());
			SpeedDie = Integer.parseInt(txtSpeedDie.getText());
		});
		if (chcbxTicked) chckbxSetDice.setSelected(true);
		add(chckbxSetDice);
		chcbxExist = true;
		
		chcOwnables = new Choice();
		chcOwnables.setBounds(237, 58, 261, 20);
		add(chcOwnables);
		
		JButton btnNewButton = new JButton("Upgrade");
		btnNewButton.addActionListener(al -> {
			Admin.upgradeOwnable(chcOwnables.getSelectedItem());
			Debug.refreshLands();
		});
		btnNewButton.setBounds(504, 56, 110, 28);
		add(btnNewButton);
		
		JButton btnDowngrade = new JButton("Downgrade");
		btnDowngrade.addActionListener(al -> {
			Admin.downgradeOwnable(chcOwnables.getSelectedItem());
			Debug.refreshLands();
		});
		btnDowngrade.setBounds(504, 84, 110, 28);
		add(btnDowngrade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 45, 602, 2);
		add(separator);
		
		Choice chcPlayers = new Choice();
		chcPlayers.addItemListener(il -> {
			fillCombo(chcPlayers.getSelectedIndex());
		});
		chcPlayers.setBounds(12, 57, 116, 22);
		for (Player pl : Main.players)
			chcPlayers.add(pl.getName());
		add(chcPlayers);
		
		JLabel lblOwnedPropertied = new JLabel("Owned Properties:");
		lblOwnedPropertied.setBounds(142, 58, 90, 21);
		add(lblOwnedPropertied);
		
		JLabel lblGiveCard = new JLabel("Give Card:");
		lblGiveCard.setBounds(181, 121, 51, 21);
		add(lblGiveCard);
		
		Choice chcCards = new Choice();
		chcCards.setBounds(237, 121, 261, 20);
		for (ChanceCard ccc : Main.chanceDeck.getDeck())
			if (ccc.isKeepable())
				chcCards.add(ccc.getName());
		for (CommunityChestCard ccc : Main.communityDeck.getDeck())
			if (ccc.isKeepable())
				chcCards.add(ccc.getName());
		add(chcCards);
		
		JButton btnGive = new JButton("Give");
		btnGive.addActionListener(al -> {
			Player pl = Main.players[chcPlayers.getSelectedIndex()];
			for (ChanceCard cc : Main.chanceDeck.getDeck())
				if (cc.getName().equals(chcCards.getSelectedItem())) {
					pl.addToInventoryC(cc.getType());
				}
			for (CommunityChestCard ccc : Main.communityDeck.getDeck())
				if (ccc.getName().equals(chcCards.getSelectedItem()))
					pl.addToInventoryCC(ccc.getType());
		});
		btnGive.setBounds(504, 118, 110, 28);
		add(btnGive);
	}
	private void fillCombo(int playerID) {
		chcOwnables.removeAll();
		if (Main.players != null && Main.players.length - 1 >= currentPlayerID) {
			for (Land land : Main.players[playerID].getOwnedLands()) {
				chcOwnables.add(land.getName());
			}
			for (Ownable ownable : Main.players[playerID].getOwnedSquares()) {
				chcOwnables.add(ownable.getName());
			}
		}
	}
}
