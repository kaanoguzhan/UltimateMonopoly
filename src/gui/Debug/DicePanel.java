package gui.Debug;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import GameSquares.Land;
import GameSquares.Ownable;
import Main.Admin;
import Main.Main;
import Main.Player;

public class DicePanel extends JPanel {
	private static final long	serialVersionUID	= 1L;
	public static int			Die1, Die2, SpeedDie;
	public static boolean		chcbxTicked;
	public static boolean		chcbxExist			= false;
	public static Choice		choice;
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
		
		choice = new Choice();
		choice.setBounds(140, 57, 244, 28);
		add(choice);
		
		JButton btnNewButton = new JButton("Upgrade");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.upgradeOwnable(choice.getSelectedItem());
				Debug.refreshLands();
			}
		});
		btnNewButton.setBounds(392, 57, 110, 28);
		add(btnNewButton);
		
		JButton btnDowngrade = new JButton("Downgrade");
		btnDowngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.downgradeOwnable(choice.getSelectedItem());
				Debug.refreshLands();
			}
		});
		btnDowngrade.setBounds(392, 90, 110, 28);
		add(btnDowngrade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 45, 602, 2);
		add(separator);
		
		Choice choice_1 = new Choice();
		choice_1.addItemListener(il -> {
			fillCombo(choice_1.getSelectedIndex());
		});
		choice_1.setBounds(12, 57, 116, 22);
		for (Player pl : Main.players)
			choice_1.add(pl.getName());
		add(choice_1);
	}
	
	private void fillCombo(int playerID) {
		choice.removeAll();
		if (Main.players != null && Main.players.length - 1 >= currentPlayerID) {
			for (Land land : Main.players[playerID].getOwnedLands()) {
				choice.add(land.getName());
			}
			for (Ownable ownable : Main.players[playerID].getOwnedSquares()) {
				choice.add(ownable.getName());
			}
		}
	}
}
