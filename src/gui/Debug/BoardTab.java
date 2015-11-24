package gui.Debug;

import gui.Board.Board;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardTab extends JPanel {
	private static final long	serialVersionUID	= 1L;
	public static JTextField	txtDie1, txtDie2, txtSpeedDie;
	public static JCheckBox		chckbxSetDice;
	
	public BoardTab() {
		setLayout(null);
		
		// /////////////////////////// //
		// Old-New Board Buttons ///// //
		// /////////////////////////// //
		
		JButton btnOldBoard = new JButton("Old Board");
		btnOldBoard.addActionListener(al -> {
			Board.getLblBoard().setIcon(new ImageIcon("board700.jpg"));
			Board.getLblBoard().setBounds(0, 0, 720, 720);
		});
		btnOldBoard.setBounds(10, 5, 299, 109);
		add(btnOldBoard);
		
		JButton btnNewBoard = new JButton("New Board");
		btnNewBoard.addActionListener(al -> {
			Board.getLblBoard().setIcon(new ImageIcon("board1050.jpg"));
			Board.getLblBoard().setBounds(0, 0, 1050, 1050);
		});
		btnNewBoard.setBounds(316, 5, 299, 109);
		add(btnNewBoard);
		
		txtDie1 = new JTextField();
		txtDie1.setBounds(12, 156, 116, 22);
		add(txtDie1);
		txtDie1.setColumns(10);
		
		txtDie2 = new JTextField();
		txtDie2.setBounds(140, 156, 116, 22);
		add(txtDie2);
		txtDie2.setColumns(10);
		
		txtSpeedDie = new JTextField();
		txtSpeedDie.setBounds(268, 156, 116, 22);
		add(txtSpeedDie);
		txtSpeedDie.setColumns(10);
		
		chckbxSetDice = new JCheckBox("Fix Dice");
		chckbxSetDice.setBounds(392, 155, 113, 25);
		add(chckbxSetDice);
		
		// /////////////////////////// //
		// Fixed Dice //////////////// //
		// /////////////////////////// //
	}
}
