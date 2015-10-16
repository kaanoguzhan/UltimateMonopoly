package gui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import GameSquares.Land;
import Main.Admin;
import Main.Main;

public class DeB extends JFrame {
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			txtMoney0;
	private JTextField			textField;
	private JTextField			textField_1;
	private JTextField			textField_2;
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				DeB frame = new DeB();
				frame.setVisible(true);
				SwingUtilities.updateComponentTreeUI(frame);
				
			}
		});
	}
	
	// Create the frame.
	public DeB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnSetMon0 = new JButton("Set");
		btnSetMon0.setBounds(55, 55, 81, 42);
		Player0.add(btnSetMon0);
		
		JButton btnMin0 = new JButton("-");
		btnMin0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMin0.setAlignmentY(Component.TOP_ALIGNMENT);
		btnMin0.setBounds(12, 76, 43, 21);
		Player0.add(btnMin0);
		
		JButton btnPls0 = new JButton("+");
		btnPls0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPls0.setAlignmentY(Component.TOP_ALIGNMENT);
		btnPls0.setBounds(12, 55, 43, 21);
		Player0.add(btnPls0);
		
		txtMoney0 = new JTextField();
		txtMoney0.setBounds(12, 31, 125, 22);
		Player0.add(txtMoney0);
		txtMoney0.setColumns(10);
		
		JLabel lblMoney0 = new JLabel("Money: ");
		lblMoney0.setBounds(10, 13, 118, 16);
		Player0.add(lblMoney0);
		
		Choice choiceLoc0 = new Choice();
		fillAllSquares(choiceLoc0);
		choiceLoc0.setBounds(167, 31, 140, 22);
		Player0.add(choiceLoc0);
		
		JButton btnSetLoc0 = new JButton("Set");
		btnSetLoc0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.movePlayerToForced(1, choiceLoc0.getSelectedIndex());
			}
		});
		btnSetLoc0.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSetLoc0.setBounds(167, 55, 70, 41);
		Player0.add(btnSetLoc0);
		
		JButton btnMove0 = new JButton("Move");
		btnMove0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.movePlayerTo(1, choiceLoc0.getSelectedIndex());
			}
		});
		btnMove0.setAlignmentX(0.5f);
		btnMove0.setBounds(237, 55, 70, 41);
		Player0.add(btnMove0);
		
		JLabel lblOwnLands0 = new JLabel("Owned Lands");
		lblOwnLands0.setBounds(329, 13, 140, 16);
		Player0.add(lblOwnLands0);
		
		Choice choiceOwnLan0 = new Choice();
		fillOwnLands(choiceOwnLan0, 0);
		choiceOwnLan0.setBounds(329, 31, 140, 22);
		Player0.add(choiceOwnLan0);
		
		Choice choiceNeuLand0 = new Choice();
		fillNeuLands(choiceNeuLand0, 0);
		choiceNeuLand0.setBounds(473, 31, 140, 22);
		Player0.add(choiceNeuLand0);
		
		JLabel lblNeuLands0 = new JLabel("Neutral Lands");
		lblNeuLands0.setBounds(473, 13, 140, 16);
		Player0.add(lblNeuLands0);
		
		JButton btnRemoveLnd0 = new JButton("Remove");
		btnRemoveLnd0.setBounds(329, 55, 140, 41);
		Player0.add(btnRemoveLnd0);
		
		JButton btnClaimLnd0 = new JButton("Claim");
		btnClaimLnd0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.giveOwnership(0, choiceNeuLand0.getSelectedItem());
				refreshLands(0, choiceOwnLan0, choiceNeuLand0);
			}
		});
		btnClaimLnd0.setBounds(473, 55, 140, 41);
		Player0.add(btnClaimLnd0);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(148, 0, 2, 109);
		Player0.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(315, 0, 2, 109);
		Player0.add(separator_1);
		
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
		
		JButton button = new JButton("Set");
		button.setBounds(55, 55, 81, 42);
		Player1.add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setAlignmentY(0.0f);
		button_1.setBounds(12, 76, 43, 21);
		Player1.add(button_1);
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.increaseMoneyBy(0, getInt(txtMoney0));
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setAlignmentY(0.0f);
		button_2.setBounds(12, 55, 43, 21);
		Player1.add(button_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 31, 125, 22);
		Player1.add(textField);
		
		JLabel label_1 = new JLabel("Money: ");
		label_1.setBounds(10, 13, 118, 16);
		Player1.add(label_1);
		
		Choice choice = new Choice();
		choice.setBounds(167, 31, 140, 22);
		Player1.add(choice);
		
		JButton button_3 = new JButton("Set");
		button_3.setAlignmentX(0.5f);
		button_3.setBounds(167, 55, 70, 41);
		Player1.add(button_3);
		
		JButton button_4 = new JButton("Move");
		button_4.setAlignmentX(0.5f);
		button_4.setBounds(237, 55, 70, 41);
		Player1.add(button_4);
		
		JLabel label_2 = new JLabel("Owned Lands");
		label_2.setBounds(329, 13, 140, 16);
		Player1.add(label_2);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(329, 31, 140, 22);
		Player1.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(473, 31, 140, 22);
		Player1.add(choice_2);
		
		JLabel label_3 = new JLabel("Neutral Lands");
		label_3.setBounds(473, 13, 140, 16);
		Player1.add(label_3);
		
		JButton button_5 = new JButton("Remove");
		button_5.setBounds(329, 55, 140, 41);
		Player1.add(button_5);
		
		JButton button_6 = new JButton("Claim");
		button_6.setBounds(473, 55, 140, 41);
		Player1.add(button_6);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(148, 0, 2, 109);
		Player1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(315, 0, 2, 109);
		Player1.add(separator_3);
		
		JLabel label_4 = new JLabel("Player 1");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(0, 150, 625, 22);
		Players.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel.setBounds(0, 322, 625, 109);
		Players.add(panel);
		
		JLabel label_5 = new JLabel("Location: ");
		label_5.setBounds(167, 13, 56, 16);
		panel.add(label_5);
		
		JButton button_7 = new JButton("Set");
		button_7.setBounds(55, 55, 81, 42);
		panel.add(button_7);
		
		JButton button_8 = new JButton("-");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_8.setAlignmentY(0.0f);
		button_8.setBounds(12, 76, 43, 21);
		panel.add(button_8);
		
		JButton button_9 = new JButton("+");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_9.setAlignmentY(0.0f);
		button_9.setBounds(12, 55, 43, 21);
		panel.add(button_9);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 31, 125, 22);
		panel.add(textField_1);
		
		JLabel label_6 = new JLabel("Money: ");
		label_6.setBounds(10, 13, 118, 16);
		panel.add(label_6);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(167, 31, 140, 22);
		panel.add(choice_3);
		
		JButton button_10 = new JButton("Set");
		button_10.setAlignmentX(0.5f);
		button_10.setBounds(167, 55, 70, 41);
		panel.add(button_10);
		
		JButton button_11 = new JButton("Move");
		button_11.setAlignmentX(0.5f);
		button_11.setBounds(237, 55, 70, 41);
		panel.add(button_11);
		
		JLabel label_7 = new JLabel("Owned Lands");
		label_7.setBounds(329, 13, 140, 16);
		panel.add(label_7);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(329, 31, 140, 22);
		panel.add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(473, 31, 140, 22);
		panel.add(choice_5);
		
		JLabel label_8 = new JLabel("Neutral Lands");
		label_8.setBounds(473, 13, 140, 16);
		panel.add(label_8);
		
		JButton button_12 = new JButton("Remove");
		button_12.setBounds(329, 55, 140, 41);
		panel.add(button_12);
		
		JButton button_13 = new JButton("Claim");
		button_13.setBounds(473, 55, 140, 41);
		panel.add(button_13);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(148, 0, 2, 109);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(315, 0, 2, 109);
		panel.add(separator_5);
		
		JLabel lblPlayer = new JLabel("Player 2");
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer.setBounds(0, 300, 625, 22);
		Players.add(lblPlayer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_1.setBounds(0, 475, 625, 109);
		Players.add(panel_1);
		
		JLabel label_10 = new JLabel("Location: ");
		label_10.setBounds(167, 13, 56, 16);
		panel_1.add(label_10);
		
		JButton button_14 = new JButton("Set");
		button_14.setBounds(55, 55, 81, 42);
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("-");
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_15.setAlignmentY(0.0f);
		button_15.setBounds(12, 76, 43, 21);
		panel_1.add(button_15);
		
		JButton button_16 = new JButton("+");
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_16.setAlignmentY(0.0f);
		button_16.setBounds(12, 55, 43, 21);
		panel_1.add(button_16);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 31, 125, 22);
		panel_1.add(textField_2);
		
		JLabel label_11 = new JLabel("Money: ");
		label_11.setBounds(10, 13, 118, 16);
		panel_1.add(label_11);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(167, 31, 140, 22);
		panel_1.add(choice_6);
		
		JButton button_17 = new JButton("Set");
		button_17.setAlignmentX(0.5f);
		button_17.setBounds(167, 55, 70, 41);
		panel_1.add(button_17);
		
		JButton button_18 = new JButton("Move");
		button_18.setAlignmentX(0.5f);
		button_18.setBounds(237, 55, 70, 41);
		panel_1.add(button_18);
		
		JLabel label_12 = new JLabel("Owned Lands");
		label_12.setBounds(329, 13, 140, 16);
		panel_1.add(label_12);
		
		Choice choice_7 = new Choice();
		choice_7.setBounds(329, 31, 140, 22);
		panel_1.add(choice_7);
		
		Choice choice_8 = new Choice();
		choice_8.setBounds(473, 31, 140, 22);
		panel_1.add(choice_8);
		
		JLabel label_13 = new JLabel("Neutral Lands");
		label_13.setBounds(473, 13, 140, 16);
		panel_1.add(label_13);
		
		JButton button_19 = new JButton("Remove");
		button_19.setBounds(329, 55, 140, 41);
		panel_1.add(button_19);
		
		JButton button_20 = new JButton("Claim");
		button_20.setBounds(473, 55, 140, 41);
		panel_1.add(button_20);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(148, 0, 2, 109);
		panel_1.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(315, 0, 2, 109);
		panel_1.add(separator_7);
		
		JLabel lblPlayer_1 = new JLabel("Player 3");
		lblPlayer_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer_1.setBounds(0, 450, 625, 22);
		Players.add(lblPlayer_1);
		
		
		btnPls0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(0, getInt(txtMoney0));
			}
		});
		btnMin0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.decreaseMoneyBy(0, getInt(txtMoney0));
			}
		});
		btnSetMon0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(0, getInt(txtMoney0));
			}
		});
	}
	
	private int getInt(JTextField txtField) {
		return Integer.parseInt(txtField.getText());
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
		choice.add("Oriental Ave");
		choice.add("Vermont Ave");
		choice.add("Connecticut");
		choice.add("St. Charles Place");
		choice.add("States Ave");
		choice.add("Virginia");
		choice.add("St. James Place");
		choice.add("Tennessee");
		choice.add("New York Ave");
		choice.add("Pacific");
		choice.add("North Carolina");
		choice.add("Pennsylvania");
		
		try {
			for (int i = 0; i < Main.players.length; i++)
				for (Land land : Main.players[playerID].getOwnedLands())
					choice.remove(land.getName());
		} catch (Exception e) {}
	}
	
	private void fillOwnLands(Choice choice, int playerID) {
		for (Land land : Main.players[playerID].getOwnedLands()) {
			choice.add(land.getName());
		}
	}
	
	private void refreshLands(int playerID, Choice... choice) {
		if (choice.length == 2) {
			choice[0].removeAll();
			choice[1].removeAll();
			fillOwnLands(choice[0], playerID);
			fillNeuLands(choice[1], playerID);
		}
	}
}
