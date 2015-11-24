package gui.Debug;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import GameSquares.Land;
import GameSquares.Ownable;
import Main.Main;

public class DicePanel extends JPanel {
	private static final long	serialVersionUID	= 1L;
	public static int			Die1, Die2, SpeedDie;
	public static boolean		chcbxTicked;
	public static boolean		chcbxExist			= false;
	public static Choice		choice;
	private JRadioButton		rbtn1, rbtn2, rbtn3, rbtn4;
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
		chckbxSetDice.setBounds(392, 9, 113, 25);
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
		
		
		rbtn1 = new JRadioButton("Player 1");
		rbtn1.addActionListener(al -> {
			switchPlayer(1);
		});
		rbtn1.setBounds(12, 60, 97, 25);
		add(rbtn1);
		
		rbtn2 = new JRadioButton("Player 2");
		rbtn1.addActionListener(al -> {
			switchPlayer(2);
		});
		rbtn2.setBounds(12, 90, 97, 25);
		add(rbtn2);
		
		rbtn3 = new JRadioButton("Player 3");
		rbtn1.addActionListener(al -> {
			switchPlayer(3);
		});
		rbtn3.setBounds(12, 120, 97, 25);
		add(rbtn3);
		
		rbtn4 = new JRadioButton("Player 4");
		rbtn1.addActionListener(al -> {
			switchPlayer(4);
		});
		rbtn4.setBounds(12, 150, 97, 25);
		add(rbtn4);
		
		choice = new Choice();
		choice.setBounds(140, 57, 244, 28);
		add(choice);
		
		JButton btnNewButton = new JButton("Upgrade");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(392, 57, 113, 28);
		add(btnNewButton);
		
		JButton btnDowngrade = new JButton("Downgrade");
		btnDowngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDowngrade.setBounds(392, 90, 113, 28);
		add(btnDowngrade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 45, 602, 2);
		add(separator);
	}
	
	
	private void switchPlayer(int playerID) {
		currentPlayerID = playerID;
		
		// Disable All Radio Buttons
		if (currentPlayerID != 1) rbtn1.setSelected(false);
		if (currentPlayerID != 2) rbtn2.setSelected(false);
		if (currentPlayerID != 3) rbtn3.setSelected(false);
		if (currentPlayerID != 4) rbtn4.setSelected(false);
		fillCombo();
	}
	
	private void fillCombo() {
		if (Main.players != null && Main.players.length - 1 >= currentPlayerID) {
			for (Land land : Main.players[currentPlayerID].getOwnedLands()) {
				choice.add(land.getName());
			}
			for (Ownable ownable : Main.players[currentPlayerID].getOwnedSquares()) {
				choice.add(ownable.getName());
			}
		}
		return; // TODO Delete this line
	}
}
