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
		setBounds(100, 100, 641, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Consolas", Font.PLAIN, 15));
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 625, 553);
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
		
		JLabel lblPlayerName1 = new JLabel("Player 1");
		lblPlayerName1.setBounds(0, 0, 625, 22);
		Players.add(lblPlayerName1);
		lblPlayerName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		btnPls0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.increaseMoneyBy(1, getInt(txtMoney0));
			}
		});
		btnMin0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.decreaseMoneyBy(1, getInt(txtMoney0));
			}
		});
		btnSetMon0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.setMoney(1, getInt(txtMoney0));
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
		
		for (int i = 0; i < Main.players.length; i++)
			for (Land land : Main.players[playerID].getOwnedLands())
				choice.remove(land.getName());
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
