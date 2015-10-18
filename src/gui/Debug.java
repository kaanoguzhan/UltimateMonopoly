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

public class Debug extends JFrame {
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			txtMoney1;
	private JTextField			txtMoney2;
	private JTextField			txtMoney3;
	private JTextField			txtMoney4;
	private Choice				choiceOwnLan1, choiceNeuLand1;
	private Choice				choiceOwnLan2, choiceNeuLand2;
	private Choice				choiceOwnLan3, choiceNeuLand3;
	private Choice				choiceOwnLan4, choiceNeuLand4;
	
	public Debug() {
		setBounds(25, 25, 643, 663);
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
		
		JLabel lblLocation1 = new JLabel("Location: ");
		lblLocation1.setBounds(167, 13, 56, 16);
		Player0.add(lblLocation1);
		
		JLabel lblMoney1 = new JLabel("Money: " + Admin.getPlayerMoney(0));
		lblMoney1.setBounds(10, 13, 118, 16);
		Player0.add(lblMoney1);
		
		JButton btnSetMon1 = new JButton("Set");
		btnSetMon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(0, getInt(txtMoney1));
				lblMoney1.setText("Money: " + Admin.getPlayerMoney(0));
			}
		});
		btnSetMon1.setBounds(55, 55, 81, 42);
		Player0.add(btnSetMon1);
		
		JButton btnMin1 = new JButton("-");
		btnMin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.decreaseMoneyBy(0, getInt(txtMoney1));
				lblMoney1.setText("Money: " + Admin.getPlayerMoney(0));
			}
		});
		btnMin1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnMin1.setBounds(12, 76, 43, 21);
		Player0.add(btnMin1);
		
		JButton btnPls1 = new JButton("+");
		btnPls1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(0, getInt(txtMoney1));
				lblMoney1.setText("Money: " + Admin.getPlayerMoney(0));
			}
		});
		btnPls1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnPls1.setBounds(12, 55, 43, 21);
		Player0.add(btnPls1);
		
		txtMoney1 = new JTextField();
		txtMoney1.setColumns(10);
		txtMoney1.setBounds(12, 31, 125, 22);
		txtMoney1.setToolTipText("" + Admin.getPlayerMoney(0));
		Player0.add(txtMoney1);
		
		Choice choiceLoc1 = new Choice();
		fillAllSquares(choiceLoc1);
		choiceLoc1.select(Admin.getPlayerLocation(0));
		choiceLoc1.setBounds(167, 31, 140, 22);
		Player0.add(choiceLoc1);
		
		JButton btnSetLoc1 = new JButton("Set");
		btnSetLoc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.movePlayerToForced(0, choiceLoc1.getSelectedIndex());
			}
		});
		btnSetLoc1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSetLoc1.setBounds(167, 55, 70, 41);
		Player0.add(btnSetLoc1);
		
		JButton btnMove1 = new JButton("Move");
		btnMove1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(0, choiceLoc1.getSelectedIndex());
			}
		});
		btnMove1.setAlignmentX(0.5f);
		btnMove1.setBounds(237, 55, 70, 41);
		Player0.add(btnMove1);
		
		JLabel lblOwnLands1 = new JLabel("Owned Lands");
		lblOwnLands1.setBounds(329, 13, 140, 16);
		Player0.add(lblOwnLands1);
		
		choiceOwnLan1 = new Choice();
		fillOwnLands(choiceOwnLan1, 0);
		choiceOwnLan1.setBounds(329, 31, 140, 22);
		Player0.add(choiceOwnLan1);
		
		choiceNeuLand1 = new Choice();
		fillNeuLands(choiceNeuLand1, 0);
		choiceNeuLand1.setBounds(473, 31, 140, 22);
		Player0.add(choiceNeuLand1);
		
		JLabel lblNeuLands1 = new JLabel("Neutral Lands");
		lblNeuLands1.setBounds(473, 13, 140, 16);
		Player0.add(lblNeuLands1);
		
		JButton btnRemoveLnd1 = new JButton("Remove");
		btnRemoveLnd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeOwnership(0, choiceOwnLan1.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd1.setBounds(329, 55, 140, 41);
		Player0.add(btnRemoveLnd1);
		
		JButton btnClaimLnd1 = new JButton("Claim");
		btnClaimLnd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(0, choiceNeuLand1.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd1.setBounds(473, 55, 140, 41);
		Player0.add(btnClaimLnd1);
		
		JSeparator separator10 = new JSeparator();
		separator10.setOrientation(SwingConstants.VERTICAL);
		separator10.setBounds(148, 0, 2, 109);
		Player0.add(separator10);
		
		JSeparator separator01 = new JSeparator();
		separator01.setOrientation(SwingConstants.VERTICAL);
		separator01.setBounds(315, 0, 2, 109);
		Player0.add(separator01);
		
		JLabel lblPlayerName1 = new JLabel("Player 1");
		lblPlayerName1.setBounds(0, 0, 625, 22);
		Players.add(lblPlayerName1);
		lblPlayerName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel Player1 = new JPanel();
		Player1.setLayout(null);
		Player1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player1.setBounds(0, 172, 625, 109);
		Players.add(Player1);
		
		JLabel lblLocation2 = new JLabel("Location: ");
		lblLocation2.setBounds(167, 13, 56, 16);
		Player1.add(lblLocation2);
		
		JLabel lblMoney2 = new JLabel("Money: " + Admin.getPlayerMoney(1));
		lblMoney2.setBounds(10, 13, 118, 16);
		Player1.add(lblMoney2);
		
		JButton btnSetMon2 = new JButton("Set");
		btnSetMon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(1, getInt(txtMoney2));
				lblMoney2.setText("Money: " + Admin.getPlayerMoney(1));
			}
		});
		
		btnSetMon2.setBounds(55, 55, 81, 42);
		Player1.add(btnSetMon2);
		
		JButton btnMin2 = new JButton("-");
		btnMin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.decreaseMoneyBy(1, getInt(txtMoney2));
				lblMoney2.setText("Money: " + Admin.getPlayerMoney(1));
			}
		});
		btnMin2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin2.setAlignmentY(0.0f);
		btnMin2.setBounds(12, 76, 43, 21);
		Player1.add(btnMin2);
		
		JButton btnPls2 = new JButton("+");
		btnPls2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.increaseMoneyBy(1, getInt(txtMoney2));
				lblMoney2.setText("Money: " + Admin.getPlayerMoney(1));
			}
		});
		btnPls2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls2.setAlignmentY(0.0f);
		btnPls2.setBounds(12, 55, 43, 21);
		Player1.add(btnPls2);
		
		txtMoney2 = new JTextField();
		txtMoney2.setColumns(10);
		txtMoney2.setBounds(12, 31, 125, 22);
		Player1.add(txtMoney2);
		
		Choice choiceLoc2 = new Choice();
		fillAllSquares(choiceLoc2);
		choiceLoc2.select(Admin.getPlayerLocation(1));
		choiceLoc2.setBounds(167, 31, 140, 22);
		Player1.add(choiceLoc2);
		
		JButton btnSetLoc2 = new JButton("Set");
		btnSetLoc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerToForced(1, choiceLoc2.getSelectedIndex());
			}
		});
		btnSetLoc2.setAlignmentX(0.5f);
		btnSetLoc2.setBounds(167, 55, 70, 41);
		Player1.add(btnSetLoc2);
		
		JButton btnMove2 = new JButton("Move");
		btnMove2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(1, choiceLoc2.getSelectedIndex());
			}
		});
		btnMove2.setAlignmentX(0.5f);
		btnMove2.setBounds(237, 55, 70, 41);
		Player1.add(btnMove2);
		
		JLabel lblOwnLands2 = new JLabel("Owned Lands");
		lblOwnLands2.setBounds(329, 13, 140, 16);
		Player1.add(lblOwnLands2);
		
		choiceOwnLan2 = new Choice();
		fillOwnLands(choiceOwnLan2, 1);
		choiceOwnLan2.setBounds(329, 31, 140, 22);
		Player1.add(choiceOwnLan2);
		
		choiceNeuLand2 = new Choice();
		fillNeuLands(choiceNeuLand2, 1);
		choiceNeuLand2.setBounds(473, 31, 140, 22);
		Player1.add(choiceNeuLand2);
		
		JLabel lblNeuLands2 = new JLabel("Neutral Lands");
		lblNeuLands2.setBounds(473, 13, 140, 16);
		Player1.add(lblNeuLands2);
		
		JButton btnRemoveLnd2 = new JButton("Remove");
		btnRemoveLnd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.removeOwnership(1, choiceOwnLan2.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd2.setBounds(329, 55, 140, 41);
		Player1.add(btnRemoveLnd2);
		
		JButton btnClaimLnd2 = new JButton("Claim");
		btnClaimLnd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(1, choiceNeuLand2.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd2.setBounds(473, 55, 140, 41);
		Player1.add(btnClaimLnd2);
		
		JSeparator separator20 = new JSeparator();
		separator20.setOrientation(SwingConstants.VERTICAL);
		separator20.setBounds(148, 0, 2, 109);
		Player1.add(separator20);
		
		JSeparator separator21 = new JSeparator();
		separator21.setOrientation(SwingConstants.VERTICAL);
		separator21.setBounds(315, 0, 2, 109);
		Player1.add(separator21);
		
		JLabel lblPlayerName2 = new JLabel("Player 2");
		lblPlayerName2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName2.setBounds(0, 150, 625, 22);
		Players.add(lblPlayerName2);
		
		JPanel Player2 = new JPanel();
		Player2.setLayout(null);
		Player2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player2.setBounds(0, 322, 625, 109);
		Players.add(Player2);
		
		JLabel lblLocation3 = new JLabel("Location: ");
		lblLocation3.setBounds(167, 13, 56, 16);
		Player2.add(lblLocation3);
		
		JLabel lblMoney3 = new JLabel("Money: " + Admin.getPlayerMoney(2));
		lblMoney3.setBounds(10, 13, 118, 16);
		Player2.add(lblMoney3);
		
		JButton btnSetMon3 = new JButton("Set");
		btnSetMon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(2, getInt(txtMoney3));
				lblMoney3.setText("Money: " + Admin.getPlayerMoney(2));
			}
		});
		btnSetMon3.setBounds(55, 55, 81, 42);
		Player2.add(btnSetMon3);
		
		JButton btnMin3 = new JButton("-");
		btnMin3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.decreaseMoneyBy(2, getInt(txtMoney3));
				lblMoney3.setText("Money: " + Admin.getPlayerMoney(2));
			}
		});
		btnMin3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin3.setAlignmentY(0.0f);
		btnMin3.setBounds(12, 76, 43, 21);
		Player2.add(btnMin3);
		
		JButton btnPls3 = new JButton("+");
		btnPls3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(2, getInt(txtMoney3));
				lblMoney3.setText("Money: " + Admin.getPlayerMoney(2));
			}
		});
		btnPls3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls3.setAlignmentY(0.0f);
		btnPls3.setBounds(12, 55, 43, 21);
		Player2.add(btnPls3);
		
		txtMoney3 = new JTextField();
		txtMoney3.setColumns(10);
		txtMoney3.setBounds(12, 31, 125, 22);
		Player2.add(txtMoney3);
		
		Choice choiceLoc3 = new Choice();
		fillAllSquares(choiceLoc3);
		choiceLoc3.select(Admin.getPlayerLocation(2));
		choiceLoc3.setBounds(167, 31, 140, 22);
		Player2.add(choiceLoc3);
		
		JButton btnSetLoc3 = new JButton("Set");
		btnSetLoc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerToForced(2, choiceLoc3.getSelectedIndex());
			}
		});
		btnSetLoc3.setAlignmentX(0.5f);
		btnSetLoc3.setBounds(167, 55, 70, 41);
		Player2.add(btnSetLoc3);
		
		JButton btnMove3 = new JButton("Move");
		btnMove3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(2, choiceLoc3.getSelectedIndex());
			}
		});
		btnMove3.setAlignmentX(0.5f);
		btnMove3.setBounds(237, 55, 70, 41);
		Player2.add(btnMove3);
		
		JLabel lblOwnLands3 = new JLabel("Owned Lands");
		lblOwnLands3.setBounds(329, 13, 140, 16);
		Player2.add(lblOwnLands3);
		
		choiceOwnLan3 = new Choice();
		fillOwnLands(choiceOwnLan3, 2);
		choiceOwnLan3.setBounds(329, 31, 140, 22);
		Player2.add(choiceOwnLan3);
		
		choiceNeuLand3 = new Choice();
		fillNeuLands(choiceNeuLand3, 2);
		choiceNeuLand3.setBounds(473, 31, 140, 22);
		Player2.add(choiceNeuLand3);
		
		JLabel lblNeuLands3 = new JLabel("Neutral Lands");
		lblNeuLands3.setBounds(473, 13, 140, 16);
		Player2.add(lblNeuLands3);
		
		JButton btnRemoveLnd3 = new JButton("Remove");
		btnRemoveLnd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeOwnership(2, choiceOwnLan3.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd3.setBounds(329, 55, 140, 41);
		Player2.add(btnRemoveLnd3);
		
		JButton btnClaimLnd3 = new JButton("Claim");
		btnClaimLnd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(2, choiceNeuLand3.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd3.setBounds(473, 55, 140, 41);
		Player2.add(btnClaimLnd3);
		
		JSeparator separator30 = new JSeparator();
		separator30.setOrientation(SwingConstants.VERTICAL);
		separator30.setBounds(148, 0, 2, 109);
		Player2.add(separator30);
		
		JSeparator separator31 = new JSeparator();
		separator31.setOrientation(SwingConstants.VERTICAL);
		separator31.setBounds(315, 0, 2, 109);
		Player2.add(separator31);
		
		JLabel lblPlayerName3 = new JLabel("Player 3");
		lblPlayerName3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName3.setBounds(0, 300, 625, 22);
		Players.add(lblPlayerName3);
		
		JPanel Player3 = new JPanel();
		Player3.setLayout(null);
		Player3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		Player3.setBounds(0, 475, 625, 109);
		Players.add(Player3);
		
		JLabel lblLocation4 = new JLabel("Location: ");
		lblLocation4.setBounds(167, 13, 56, 16);
		Player3.add(lblLocation4);
		
		JLabel lblMoney4 = new JLabel("Money: " + Admin.getPlayerMoney(3));
		lblMoney4.setBounds(10, 13, 118, 16);
		Player3.add(lblMoney4);
		
		JButton btnSetMon4 = new JButton("Set");
		btnSetMon4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(3, getInt(txtMoney4));
				lblMoney4.setText("Money: " + Admin.getPlayerMoney(3));
			}
		});
		btnSetMon4.setBounds(55, 55, 81, 42);
		Player3.add(btnSetMon4);
		
		JButton btnMin4 = new JButton("-");
		btnMin4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.decreaseMoneyBy(3, getInt(txtMoney4));
				lblMoney4.setText("Money: " + Admin.getPlayerMoney(3));
			}
		});
		btnMin4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin4.setAlignmentY(0.0f);
		btnMin4.setBounds(12, 76, 43, 21);
		Player3.add(btnMin4);
		
		JButton btnPls4 = new JButton("+");
		btnPls4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(3, getInt(txtMoney4));
				lblMoney4.setText("Money: " + Admin.getPlayerMoney(3));
			}
		});
		btnPls4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls4.setAlignmentY(0.0f);
		btnPls4.setBounds(12, 55, 43, 21);
		Player3.add(btnPls4);
		
		txtMoney4 = new JTextField();
		txtMoney4.setColumns(10);
		txtMoney4.setBounds(12, 31, 125, 22);
		Player3.add(txtMoney4);
		
		Choice choiceLoc4 = new Choice();
		fillAllSquares(choiceLoc4);
		choiceLoc4.select(Admin.getPlayerLocation(3));
		choiceLoc4.setBounds(167, 31, 140, 22);
		Player3.add(choiceLoc4);
		
		JButton btnSetLoc4 = new JButton("Set");
		btnSetLoc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerToForced(3, choiceLoc4.getSelectedIndex());
			}
		});
		btnSetLoc4.setAlignmentX(0.5f);
		btnSetLoc4.setBounds(167, 55, 70, 41);
		Player3.add(btnSetLoc4);
		
		JButton btnMove4 = new JButton("Move");
		btnMove4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(3, choiceLoc4.getSelectedIndex());
			}
		});
		btnMove4.setAlignmentX(0.5f);
		btnMove4.setBounds(237, 55, 70, 41);
		Player3.add(btnMove4);
		
		JLabel lblOwnLands4 = new JLabel("Owned Lands");
		lblOwnLands4.setBounds(329, 13, 140, 16);
		Player3.add(lblOwnLands4);
		
		choiceOwnLan4 = new Choice();
		fillOwnLands(choiceOwnLan4, 3);
		choiceOwnLan4.setBounds(329, 31, 140, 22);
		Player3.add(choiceOwnLan4);
		
		choiceNeuLand4 = new Choice();
		fillNeuLands(choiceNeuLand4, 3);
		choiceNeuLand4.setBounds(473, 31, 140, 22);
		Player3.add(choiceNeuLand4);
		
		JLabel lblNeuLands4 = new JLabel("Neutral Lands");
		lblNeuLands4.setBounds(473, 13, 140, 16);
		Player3.add(lblNeuLands4);
		
		JButton btnRemoveLnd4 = new JButton("Remove");
		btnRemoveLnd4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.removeOwnership(3, choiceOwnLan4.getSelectedItem());
				refreshLands();
			}
		});
		btnRemoveLnd4.setBounds(329, 55, 140, 41);
		Player3.add(btnRemoveLnd4);
		
		JButton btnClaimLnd4 = new JButton("Claim");
		btnClaimLnd4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(3, choiceNeuLand4.getSelectedItem());
				refreshLands();
			}
		});
		btnClaimLnd4.setBounds(473, 55, 140, 41);
		Player3.add(btnClaimLnd4);
		
		JSeparator separator40 = new JSeparator();
		separator40.setOrientation(SwingConstants.VERTICAL);
		separator40.setBounds(148, 0, 2, 109);
		Player3.add(separator40);
		
		JSeparator separator41 = new JSeparator();
		separator41.setOrientation(SwingConstants.VERTICAL);
		separator41.setBounds(315, 0, 2, 109);
		Player3.add(separator41);
		
		JLabel lblPlayerName4 = new JLabel("Player 4");
		lblPlayerName4.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName4.setBounds(0, 450, 625, 22);
		Players.add(lblPlayerName4);
		
		
		
		
		
		
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
		choiceOwnLan1.removeAll();
		choiceNeuLand1.removeAll();
		fillOwnLands(choiceOwnLan1, 0);
		fillNeuLands(choiceNeuLand1, 0);
		
		choiceOwnLan2.removeAll();
		choiceNeuLand2.removeAll();
		fillOwnLands(choiceOwnLan2, 1);
		fillNeuLands(choiceNeuLand2, 1);
		
		choiceOwnLan3.removeAll();
		choiceNeuLand3.removeAll();
		fillOwnLands(choiceOwnLan3, 2);
		fillNeuLands(choiceNeuLand3, 2);
		
		choiceOwnLan4.removeAll();
		choiceNeuLand4.removeAll();
		fillOwnLands(choiceOwnLan4, 3);
		fillNeuLands(choiceNeuLand4, 3);
	}
}
