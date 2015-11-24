package gui.Debug;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiceTab extends JPanel {
	private static final long	serialVersionUID	= 1L;
	public static int			Die1, Die2, SpeedDie;
	public static boolean		chcbxTicked;
	public static boolean		chcbxExist			= false;
	
	public DiceTab() {
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
	}
}
