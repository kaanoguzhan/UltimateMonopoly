package gui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import GameSquares.GameSquare;
import GameSquares.Land;
import Main.Admin;
import Main.Main;

public class DeB extends JFrame {
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			txtMoney0;
	private JTextField			txtMoney1;
	private JTextField			txtMoney2;
	private JTextField			txtMoney3;
	private Choice				choiceOwnLan0, choiceNeuLand0;
	private Choice				choiceOwnLan1, choiceNeuLand1;
	private Choice				choiceOwnLan2, choiceNeuLand2;
	private Choice				choiceOwnLan3, choiceNeuLand3;
	
	public DeB() {
		setBounds(100, 100, 643, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Consolas", Font.PLAIN, 15));
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 625, 739);
		contentPane.add(tabbedPane);
		
		JPanel Players = new JPanel();
		Players.setBorder(null);
		tabbedPane.addTab("Players", null, Players, null);
		Players.setLayout(null);
		
		JPanel Player0 = new JPanel();
		Player0.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player0.setBounds(0, 22, 625, 109);
		Players.add(Player0);
		Player0.setLayout(null);
		
		JLabel lblLocation0 = new JLabel("Location: ");
		lblLocation0.setBounds(167, 13, 56, 16);
		Player0.add(lblLocation0);
		
		JLabel lblMoney0 = new JLabel("Money: " + Admin.getPlayerMoney(0));
		lblMoney0.setBounds(10, 13, 118, 16);
		Player0.add(lblMoney0);
		
		JButton btnSetMon0 = new JButton("Set");
		btnSetMon0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(0, getInt(txtMoney0));
				lblMoney0.setText("Money: " + Admin.getPlayerMoney(0));
			}
		});
		btnSetMon0.setBounds(55, 55, 81, 42);
		Player0.add(btnSetMon0);
		
		JButton btnMin0 = new JButton("-");
		btnMin0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.decreaseMoneyBy(0, getInt(txtMoney0));
				lblMoney0.setText("Money: " + Admin.getPlayerMoney(0));
			}
		});
		btnMin0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin0.setAlignmentY(Component.TOP_ALIGNMENT);
		btnMin0.setBounds(12, 76, 43, 21);
		Player0.add(btnMin0);
		
		JButton btnPls0 = new JButton("+");
		btnPls0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(0, getInt(txtMoney0));
				lblMoney0.setText("Money: " + Admin.getPlayerMoney(0));
			}
		});
		btnPls0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls0.setAlignmentY(Component.TOP_ALIGNMENT);
		btnPls0.setBounds(12, 55, 43, 21);
		Player0.add(btnPls0);
		
		txtMoney0 = new JTextField();
		txtMoney0.setColumns(10);
		txtMoney0.setBounds(12, 31, 125, 22);
		txtMoney0.setToolTipText("" + Admin.getPlayerMoney(0));
		Player0.add(txtMoney0);
		
		Choice choiceLoc0 = new Choice();
		fillAllSquares(choiceLoc0);
		choiceLoc0.select(Admin.getPlayerLocation(0));
		choiceLoc0.setBounds(167, 31, 140, 22);
		Player0.add(choiceLoc0);
		
		JButton btnSetLoc0 = new JButton("Set");
		btnSetLoc0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.movePlayerToForced(0, choiceLoc0.getSelectedIndex());
			}
		});
		btnSetLoc0.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSetLoc0.setBounds(167, 55, 70, 41);
		Player0.add(btnSetLoc0);
		
		JButton btnMove0 = new JButton("Move");
		btnMove0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(0, choiceLoc0.getSelectedIndex());
			}
		});
		btnMove0.setAlignmentX(0.5f);
		btnMove0.setBounds(237, 55, 70, 41);
		Player0.add(btnMove0);
		
		JLabel lblOwnLands0 = new JLabel("Owned Lands");
		lblOwnLands0.setBounds(329, 13, 140, 16);
		Player0.add(lblOwnLands0);
		
		choiceOwnLan0 = new Choice();
		fillOwnLands(choiceOwnLan0, 0);
		choiceOwnLan0.setBounds(329, 31, 140, 22);
		Player0.add(choiceOwnLan0);
		
		choiceNeuLand0 = new Choice();
		fillNeuLands(choiceNeuLand0, 0);
		choiceNeuLand0.setBounds(473, 31, 140, 22);
		Player0.add(choiceNeuLand0);
		
		JLabel lblNeuLands0 = new JLabel("Neutral Lands");
		lblNeuLands0.setBounds(473, 13, 140, 16);
		Player0.add(lblNeuLands0);
		
		JButton btnRemoveLnd0 = new JButton("Remove");
		btnRemoveLnd0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeOwnership(0, choiceOwnLan0.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd0.setBounds(329, 55, 140, 41);
		Player0.add(btnRemoveLnd0);
		
		JButton btnClaimLnd0 = new JButton("Claim");
		btnClaimLnd0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(0, choiceNeuLand0.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd0.setBounds(473, 55, 140, 41);
		Player0.add(btnClaimLnd0);
		
		JSeparator separator00 = new JSeparator();
		separator00.setOrientation(SwingConstants.VERTICAL);
		separator00.setBounds(148, 0, 2, 109);
		Player0.add(separator00);
		
		JSeparator separator01 = new JSeparator();
		separator01.setOrientation(SwingConstants.VERTICAL);
		separator01.setBounds(315, 0, 2, 109);
		Player0.add(separator01);
		
		JLabel lblPlayerName1 = new JLabel("Player 0");
		lblPlayerName1.setBounds(0, 0, 625, 22);
		Players.add(lblPlayerName1);
		lblPlayerName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel Player1 = new JPanel();
		Player1.setLayout(null);
		Player1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player1.setBounds(0, 172, 625, 109);
		Players.add(Player1);
		
		JLabel label = new JLabel("Location: ");
		label.setBounds(167, 13, 56, 16);
		Player1.add(label);
		
		JLabel label_1 = new JLabel("Money: " + Admin.getPlayerMoney(1));
		label_1.setBounds(10, 13, 118, 16);
		Player1.add(label_1);
		
		JButton btnSetMon1 = new JButton("Set");
		btnSetMon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(1, getInt(txtMoney1));
				label_1.setText("Money: " + Admin.getPlayerMoney(1));
			}
		});
		
		btnSetMon1.setBounds(55, 55, 81, 42);
		Player1.add(btnSetMon1);
		
		JButton btnMin1 = new JButton("-");
		btnMin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.decreaseMoneyBy(1, getInt(txtMoney1));
				label_1.setText("Money: " + Admin.getPlayerMoney(1));
			}
		});
		btnMin1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin1.setAlignmentY(0.0f);
		btnMin1.setBounds(12, 76, 43, 21);
		Player1.add(btnMin1);
		
		JButton btnPls1 = new JButton("+");
		btnPls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.increaseMoneyBy(1, getInt(txtMoney1));
				label_1.setText("Money: " + Admin.getPlayerMoney(1));
			}
		});
		btnPls1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls1.setAlignmentY(0.0f);
		btnPls1.setBounds(12, 55, 43, 21);
		Player1.add(btnPls1);
		
		txtMoney1 = new JTextField();
		txtMoney1.setColumns(10);
		txtMoney1.setBounds(12, 31, 125, 22);
		Player1.add(txtMoney1);
		
		Choice choiceLoc1 = new Choice();
		fillAllSquares(choiceLoc1);
		choiceLoc1.select(Admin.getPlayerLocation(1));
		choiceLoc1.setBounds(167, 31, 140, 22);
		Player1.add(choiceLoc1);
		
		JButton btnSetLoc1 = new JButton("Set");
		btnSetLoc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerToForced(1, choiceLoc0.getSelectedIndex());
			}
		});
		btnSetLoc1.setAlignmentX(0.5f);
		btnSetLoc1.setBounds(167, 55, 70, 41);
		Player1.add(btnSetLoc1);
		
		JButton btnMove1 = new JButton("Move");
		btnMove1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(1, choiceLoc0.getSelectedIndex());
			}
		});
		btnMove1.setAlignmentX(0.5f);
		btnMove1.setBounds(237, 55, 70, 41);
		Player1.add(btnMove1);
		
		JLabel label_2 = new JLabel("Owned Lands");
		label_2.setBounds(329, 13, 140, 16);
		Player1.add(label_2);
		
		choiceOwnLan1 = new Choice();
		fillOwnLands(choiceOwnLan1, 1);
		choiceOwnLan1.setBounds(329, 31, 140, 22);
		Player1.add(choiceOwnLan1);
		
		choiceNeuLand1 = new Choice();
		fillNeuLands(choiceNeuLand1, 1);
		choiceNeuLand1.setBounds(473, 31, 140, 22);
		Player1.add(choiceNeuLand1);
		
		JLabel label_3 = new JLabel("Neutral Lands");
		label_3.setBounds(473, 13, 140, 16);
		Player1.add(label_3);
		
		JButton btnRemoveLnd1 = new JButton("Remove");
		btnRemoveLnd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.removeOwnership(1, choiceOwnLan1.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd1.setBounds(329, 55, 140, 41);
		Player1.add(btnRemoveLnd1);
		
		JButton btnClaimLnd1 = new JButton("Claim");
		btnClaimLnd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(1, choiceNeuLand1.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd1.setBounds(473, 55, 140, 41);
		Player1.add(btnClaimLnd1);
		
		JSeparator separator10 = new JSeparator();
		separator10.setOrientation(SwingConstants.VERTICAL);
		separator10.setBounds(148, 0, 2, 109);
		Player1.add(separator10);
		
		JSeparator separator11 = new JSeparator();
		separator11.setOrientation(SwingConstants.VERTICAL);
		separator11.setBounds(315, 0, 2, 109);
		Player1.add(separator11);
		
		JLabel label_4 = new JLabel("Player 1");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(0, 150, 625, 22);
		Players.add(label_4);
		
		JPanel Player2 = new JPanel();
		Player2.setLayout(null);
		Player2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player2.setBounds(0, 322, 625, 109);
		Players.add(Player2);
		
		JLabel label_5 = new JLabel("Location: ");
		label_5.setBounds(167, 13, 56, 16);
		Player2.add(label_5);
		
		JLabel label_6 = new JLabel("Money: " + Admin.getPlayerMoney(2));
		label_6.setBounds(10, 13, 118, 16);
		Player2.add(label_6);
		
		JButton btnSetMon2 = new JButton("Set");
		btnSetMon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(2, getInt(txtMoney2));
				label_6.setText("Money: " + Admin.getPlayerMoney(2));
			}
		});
		btnSetMon2.setBounds(55, 55, 81, 42);
		Player2.add(btnSetMon2);
		
		JButton btnMin2 = new JButton("-");
		btnMin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.decreaseMoneyBy(2, getInt(txtMoney2));
				label_6.setText("Money: " + Admin.getPlayerMoney(2));
			}
		});
		btnMin2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin2.setAlignmentY(0.0f);
		btnMin2.setBounds(12, 76, 43, 21);
		Player2.add(btnMin2);
		
		JButton btnPls2 = new JButton("+");
		btnPls2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(2, getInt(txtMoney2));
				label_6.setText("Money: " + Admin.getPlayerMoney(2));
			}
		});
		btnPls2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls2.setAlignmentY(0.0f);
		btnPls2.setBounds(12, 55, 43, 21);
		Player2.add(btnPls2);
		
		txtMoney2 = new JTextField();
		txtMoney2.setColumns(10);
		txtMoney2.setBounds(12, 31, 125, 22);
		Player2.add(txtMoney2);
		
		Choice choiceLoc2 = new Choice();
		fillAllSquares(choiceLoc2);
		choiceLoc2.select(Admin.getPlayerLocation(2));
		choiceLoc2.setBounds(167, 31, 140, 22);
		Player2.add(choiceLoc2);
		
		JButton btnSetLoc2 = new JButton("Set");
		btnSetLoc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerToForced(2, choiceLoc0.getSelectedIndex());
			}
		});
		btnSetLoc2.setAlignmentX(0.5f);
		btnSetLoc2.setBounds(167, 55, 70, 41);
		Player2.add(btnSetLoc2);
		
		JButton btnMove2 = new JButton("Move");
		btnMove2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(2, choiceLoc0.getSelectedIndex());
			}
		});
		btnMove2.setAlignmentX(0.5f);
		btnMove2.setBounds(237, 55, 70, 41);
		Player2.add(btnMove2);
		
		JLabel label_7 = new JLabel("Owned Lands");
		label_7.setBounds(329, 13, 140, 16);
		Player2.add(label_7);
		
		choiceOwnLan2 = new Choice();
		fillOwnLands(choiceOwnLan2, 2);
		choiceOwnLan2.setBounds(329, 31, 140, 22);
		Player2.add(choiceOwnLan2);
		
		choiceNeuLand2 = new Choice();
		fillNeuLands(choiceNeuLand2, 2);
		choiceNeuLand2.setBounds(473, 31, 140, 22);
		Player2.add(choiceNeuLand2);
		
		JLabel label_8 = new JLabel("Neutral Lands");
		label_8.setBounds(473, 13, 140, 16);
		Player2.add(label_8);
		
		JButton btnRemoveLnd2 = new JButton("Remove");
		btnRemoveLnd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeOwnership(2, choiceOwnLan2.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd2.setBounds(329, 55, 140, 41);
		Player2.add(btnRemoveLnd2);
		
		JButton btnClaimLnd2 = new JButton("Claim");
		btnClaimLnd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(2, choiceNeuLand2.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd2.setBounds(473, 55, 140, 41);
		Player2.add(btnClaimLnd2);
		
		JSeparator separator20 = new JSeparator();
		separator20.setOrientation(SwingConstants.VERTICAL);
		separator20.setBounds(148, 0, 2, 109);
		Player2.add(separator20);
		
		JSeparator separator21 = new JSeparator();
		separator21.setOrientation(SwingConstants.VERTICAL);
		separator21.setBounds(315, 0, 2, 109);
		Player2.add(separator21);
		
		JLabel lblPlayer = new JLabel("Player 2");
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer.setBounds(0, 300, 625, 22);
		Players.add(lblPlayer);
		
		JPanel Player3 = new JPanel();
		Player3.setLayout(null);
		Player3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player3.setBounds(0, 475, 625, 109);
		Players.add(Player3);
		
		JLabel label_10 = new JLabel("Location: ");
		label_10.setBounds(167, 13, 56, 16);
		Player3.add(label_10);
		
		JLabel label_11 = new JLabel("Money: " + Admin.getPlayerMoney(3));
		label_11.setBounds(10, 13, 118, 16);
		Player3.add(label_11);
		
		JButton btnSetMon3 = new JButton("Set");
		btnSetMon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(3, getInt(txtMoney3));
				label_11.setText("Money: " + Admin.getPlayerMoney(3));
			}
		});
		btnSetMon3.setBounds(55, 55, 81, 42);
		Player3.add(btnSetMon3);
		
		JButton btnMin3 = new JButton("-");
		btnMin3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.decreaseMoneyBy(3, getInt(txtMoney3));
				label_11.setText("Money: " + Admin.getPlayerMoney(3));
			}
		});
		btnMin3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin3.setAlignmentY(0.0f);
		btnMin3.setBounds(12, 76, 43, 21);
		Player3.add(btnMin3);
		
		JButton btnPls3 = new JButton("+");
		btnPls3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(3, getInt(txtMoney3));
				label_11.setText("Money: " + Admin.getPlayerMoney(3));
			}
		});
		btnPls3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls3.setAlignmentY(0.0f);
		btnPls3.setBounds(12, 55, 43, 21);
		Player3.add(btnPls3);
		
		txtMoney3 = new JTextField();
		txtMoney3.setColumns(10);
		txtMoney3.setBounds(12, 31, 125, 22);
		Player3.add(txtMoney3);
		
		Choice choiceLoc3 = new Choice();
		fillAllSquares(choiceLoc3);
		choiceLoc3.select(Admin.getPlayerLocation(3));
		choiceLoc3.setBounds(167, 31, 140, 22);
		Player3.add(choiceLoc3);
		
		JButton btnSetLoc3 = new JButton("Set");
		btnSetLoc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerToForced(3, choiceLoc0.getSelectedIndex());
			}
		});
		btnSetLoc3.setAlignmentX(0.5f);
		btnSetLoc3.setBounds(167, 55, 70, 41);
		Player3.add(btnSetLoc3);
		
		JButton btnMove3 = new JButton("Move");
		btnMove3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(3, choiceLoc0.getSelectedIndex());
			}
		});
		btnMove3.setAlignmentX(0.5f);
		btnMove3.setBounds(237, 55, 70, 41);
		Player3.add(btnMove3);
		
		JLabel label_12 = new JLabel("Owned Lands");
		label_12.setBounds(329, 13, 140, 16);
		Player3.add(label_12);
		
		choiceOwnLan3 = new Choice();
		fillOwnLands(choiceOwnLan3, 3);
		choiceOwnLan3.setBounds(329, 31, 140, 22);
		Player3.add(choiceOwnLan3);
		
		choiceNeuLand3 = new Choice();
		fillNeuLands(choiceNeuLand3, 3);
		choiceNeuLand3.setBounds(473, 31, 140, 22);
		Player3.add(choiceNeuLand3);
		
		JLabel label_13 = new JLabel("Neutral Lands");
		label_13.setBounds(473, 13, 140, 16);
		Player3.add(label_13);
		
		JButton btnRemoveLnd3 = new JButton("Remove");
		btnRemoveLnd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeOwnership(3, choiceOwnLan3.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd3.setBounds(329, 55, 140, 41);
		Player3.add(btnRemoveLnd3);
		
		JButton btnClaimLnd3 = new JButton("Claim");
		btnClaimLnd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(3, choiceNeuLand3.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd3.setBounds(473, 55, 140, 41);
		Player3.add(btnClaimLnd3);
		
		JSeparator separator30 = new JSeparator();
		separator30.setOrientation(SwingConstants.VERTICAL);
		separator30.setBounds(148, 0, 2, 109);
		Player3.add(separator30);
		
		JSeparator separator31 = new JSeparator();
		separator31.setOrientation(SwingConstants.VERTICAL);
		separator31.setBounds(315, 0, 2, 109);
		Player3.add(separator31);
		
		JLabel lblPlayer_1 = new JLabel("Player 3");
		lblPlayer_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer_1.setBounds(0, 450, 625, 22);
		Players.add(lblPlayer_1);
		
		
		
		
		
		
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
		for (GameSquare land : Main.gameSquares)
			if (land instanceof Land && ((Land) land).getOwner() == null)
				choice.add(((Land) land).getName());
	}
	
	private void fillOwnLands(Choice choice, int playerID) {
		for (Land land : Main.players[playerID].getOwnedLands()) {
			choice.add(land.getName());
		}
	}
	
	private void refreshLands() {
		choiceOwnLan0.removeAll();
		choiceNeuLand0.removeAll();
		fillOwnLands(choiceOwnLan0, 0);
		fillNeuLands(choiceNeuLand0, 0);
		
		choiceOwnLan1.removeAll();
		choiceNeuLand1.removeAll();
		fillOwnLands(choiceOwnLan1, 1);
		fillNeuLands(choiceNeuLand1, 1);
		
		choiceOwnLan2.removeAll();
		choiceNeuLand2.removeAll();
		fillOwnLands(choiceOwnLan2, 2);
		fillNeuLands(choiceNeuLand2, 2);
		
		choiceOwnLan3.removeAll();
		choiceNeuLand3.removeAll();
		fillOwnLands(choiceOwnLan3, 3);
		fillNeuLands(choiceNeuLand3, 3);
	}
}
