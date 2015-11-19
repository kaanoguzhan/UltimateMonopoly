package gui.Debug;

import gui.Board.Board;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardTab extends JPanel {
	private static final long	serialVersionUID	= 1L;
	
	public BoardTab() {
		setLayout(null);
		
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
	}
	
}
