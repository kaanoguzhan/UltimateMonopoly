package gui.Board;

import gui.Debug;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import GameSquares.GameSquare;
import Main.Player;
import java.awt.Component;
import javax.swing.Box;

public class Board extends JFrame {
	
	private static final long	serialVersionUID	= 1L;
	Player[]					players;
	GameSquare[]				gameSquares;
	RollingTheDice				round				= new RollingTheDice();
	static SquareHolder			squareHolder		= new SquareHolder();
	public static PlayerInfo	informationTable	= new PlayerInfo();
	private static JLabel		lblBoard;
	static JLabel				zero, one, two, three;
	
	public Board(Player[] players, GameSquare[] gameSquares) {
		super("Monototype");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1640, 1090);
		setVisible(true);
		setLayout(null);
		// setUndecorated(true);
		
		this.players = players;
		this.gameSquares = gameSquares;
		
		zero = new playerIcon("playerIcon1.gif", 650, 660, 50, 40);
		add(zero);
		
		one = new playerIcon("playerIcon2.gif", 625, 660, 50, 40);
		add(one);
		
		two = new playerIcon("playerIcon3.gif", 600, 660, 50, 40);
		add(two);
		
		three = new playerIcon("playerIcon4.gif", 575, 660, 50, 40);
		add(three);
		
		round.setBounds(1060, 11, 550, 250);
		getContentPane().add(round);
		
		JButton debug = new JButton("Debug Window");
		debug.setBounds(1490, 630, 120, 70);
		getContentPane().add(debug);
		debug.addActionListener(al -> {
			// SaveLoad.load(); // TODO Save remove
			Debug frame = new Debug();
			frame.setVisible(true);
		});
		
		ImageIcon image = new ImageIcon("board1050.jpg");
		setLblBoard(new JLabel(image));
		getContentPane().add(getLblBoard());
		getLblBoard().setBounds(0, 0, 1050, 1050);
		
		informationTable.setBounds(1060, 272, 550, 350);
		getContentPane().add(informationTable);
	}
	
	public void setCurrentPlayer(int id) {
		round.setCurrentPlayer(id);
	}
	public static JLabel getLblBoard() {
		return lblBoard;
	}
	public static void setLblBoard(JLabel lblBoard) {
		Board.lblBoard = lblBoard;
	}
}


class playerIcon extends JLabel {
	private static final long	serialVersionUID	= 1L;
	
	playerIcon(String imageName, int x, int y, int height, int width) {
		super(new ImageIcon(imageName));
		super.setBounds(x, y, height, width);
	}
}
