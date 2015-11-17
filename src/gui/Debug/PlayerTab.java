package gui.Debug;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import GameSquares.GameSquare;
import GameSquares.Land;
import Main.Admin;
import Main.Main;

public class PlayerTab extends JPanel {
	private static final long	serialVersionUID	= 1L;
	private int					playerID			= 0;
	private JTextField			txtMoney1;
	private Choice				choiceOwnLan, choiceNeuLand;
	
	public PlayerTab(int playerID) {
		setLayout(null);
		this.playerID = playerID;
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		
		JLabel lblLocation1 = new JLabel("Location: ");
		lblLocation1.setBounds(167, 13, 56, 16);
		add(lblLocation1);
		
		JLabel lblMoney1 = new JLabel("Money: " + Admin.getPlayerMoney(this.playerID));
		lblMoney1.setBounds(10, 13, 118, 16);
		add(lblMoney1);
		
		JButton btnSetMon1 = new JButton("Set");
		btnSetMon1.addActionListener(al -> {
			Admin.setMoney(playerID, getInt(txtMoney1));
			lblMoney1.setText("Money: " + Admin.getPlayerMoney(this.playerID));
		});
		btnSetMon1.setBounds(55, 55, 81, 42);
		add(btnSetMon1);
		
		JButton btnMin1 = new JButton("-");
		btnMin1.addActionListener(al -> {
			Admin.decreaseMoneyBy(playerID, getInt(txtMoney1));
			lblMoney1.setText("Money: " + Admin.getPlayerMoney(this.playerID));
		});
		btnMin1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnMin1.setBounds(12, 76, 43, 21);
		add(btnMin1);
		
		JButton btnPls1 = new JButton("+");
		btnPls1.addActionListener(al -> {
			Admin.increaseMoneyBy(playerID, getInt(txtMoney1));
			lblMoney1.setText("Money: " + Admin.getPlayerMoney(this.playerID));
		});
		btnPls1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnPls1.setBounds(12, 55, 43, 21);
		add(btnPls1);
		
		txtMoney1 = new JTextField();
		txtMoney1.setColumns(10);
		txtMoney1.setBounds(12, 31, 125, 22);
		txtMoney1.setToolTipText("" + Admin.getPlayerMoney(this.playerID));
		add(txtMoney1);
		
		Choice choiceLoc1 = new Choice();
		fillAllSquares(choiceLoc1);
		choiceLoc1.select(Admin.getPlayerLocation(this.playerID));
		choiceLoc1.setBounds(167, 31, 140, 22);
		add(choiceLoc1);
		
		JButton btnSetLoc1 = new JButton("Set");
		btnSetLoc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.movePlayerToForced(playerID, choiceLoc1.getSelectedIndex());
			}
		});
		btnSetLoc1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSetLoc1.setBounds(167, 55, 70, 41);
		add(btnSetLoc1);
		
		JButton btnMove1 = new JButton("Move");
		btnMove1.addActionListener(al -> {
			Admin.movePlayerTo(playerID, choiceLoc1.getSelectedIndex());
		});
		btnMove1.setAlignmentX(0.5f);
		btnMove1.setBounds(237, 55, 70, 41);
		add(btnMove1);
		
		JLabel lblOwnLands1 = new JLabel("Owned Lands");
		lblOwnLands1.setBounds(329, 13, 140, 16);
		add(lblOwnLands1);
		
		Choice choiceOwnLan1 = new Choice();
		fillOwnLands(choiceOwnLan1, playerID);
		choiceOwnLan1.setBounds(329, 31, 140, 22);
		add(choiceOwnLan1);
		
		Choice choiceNeuLand1 = new Choice();
		fillNeuLands(choiceNeuLand1, playerID);
		choiceNeuLand1.setBounds(473, 31, 140, 22);
		add(choiceNeuLand1);
		
		JLabel lblNeuLands1 = new JLabel("Neutral Lands");
		lblNeuLands1.setBounds(473, 13, 140, 16);
		add(lblNeuLands1);
		
		JButton btnRemoveLnd1 = new JButton("Remove");
		btnRemoveLnd1.addActionListener(al -> {
			Admin.removeOwnership(playerID, choiceOwnLan1.getSelectedItem());
			Debug.refreshLands();
		});
		btnRemoveLnd1.setBounds(329, 55, 140, 41);
		add(btnRemoveLnd1);
		
		JButton btnClaimLnd1 = new JButton("Claim");
		btnClaimLnd1.addActionListener(al -> {
			Admin.giveOwnership(playerID, choiceNeuLand1.getSelectedItem());
			Debug.refreshLands();
		});
		btnClaimLnd1.setBounds(473, 55, 140, 41);
		add(btnClaimLnd1);
		
		JSeparator separator10 = new JSeparator();
		separator10.setOrientation(SwingConstants.VERTICAL);
		separator10.setBounds(148, 0, 2, 109);
		add(separator10);
		
		JSeparator separator01 = new JSeparator();
		separator01.setOrientation(SwingConstants.VERTICAL);
		separator01.setBounds(315, 0, 2, 109);
		add(separator01);
		
		
		
	}
	
	private int getInt(JTextField txtField) {
		if (txtField.getText() != null && txtField.getText().length() >= 1)
			return Integer.parseInt(txtField.getText());
		else
			return 0;
	}
	
	private void fillAllSquares(Choice choice) {
		choice.add("StartSquare");
		choice.add("Oriental Ave");
		choice.add("CommunityChest1");
		choice.add("Vermont Ave");
		choice.add("Connecticut");
		choice.add("RollOnce");
		choice.add("St. Charles Place");
		choice.add("Chance1");
		choice.add("States Ave");
		choice.add("Virginia");
		choice.add("FreePark");
		choice.add("St. James Place");
		choice.add("CommunityChest2");
		choice.add("Tennessee");
		choice.add("New York Ave");
		choice.add("SqueezePlay");
		choice.add("Pacific");
		choice.add("North Carolina");
		choice.add("Chance2");
		choice.add("Pennsylvania");
	}
	
	private void fillNeuLands(Choice choice, int playerID) {
		if (Main.players != null && Main.players.length - 1 >= playerID)
			for (GameSquare land : Main.gameSquares)
				if (land instanceof Land && ((Land) land).getOwner() == null)
					choice.add(((Land) land).getName());
	}
	
	private void fillOwnLands(Choice choice, int playerID) {
		if (Main.players != null && Main.players.length - 1 >= playerID)
			for (Land land : Main.players[playerID].getOwnedLands()) {
				choice.add(land.getName());
			}
	}
	
	void refresh() {
		choiceOwnLan.removeAll();
		choiceNeuLand.removeAll();
		fillOwnLands(choiceOwnLan, playerID);
		fillNeuLands(choiceNeuLand, playerID);
	}
}
