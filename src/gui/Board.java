package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import GameSquares.GameSquare;
import Main.Player;

public class Board extends JFrame implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	Player[]					players				= null;
	GameSquare[]				gameSquares			= null;
	static JLabel				zero, one, two, three;
	RollingTheDice				round				= new RollingTheDice();
	static SquareHolder			squareHolder		= new SquareHolder();
	public static PlayerInfo	informationTable	= new PlayerInfo();
	
	public Board(Player[] players, GameSquare[] gameSquares) {
		super("Monototype");
		setLayout(null);
		
		this.players = players;
		this.gameSquares = gameSquares;
		
		ImageIcon image0 = new ImageIcon("playerIcon1.gif");
		zero = new JLabel(image0);
		add(zero);
		zero.setBounds(650, 660, 50, 40);
		
		ImageIcon image1 = new ImageIcon("playerIcon2.gif");
		one = new JLabel(image1);
		add(one);
		one.setBounds(625, 660, 50, 40);
		
		ImageIcon image2 = new ImageIcon("playerIcon3.gif");
		two = new JLabel(image2);
		add(two);
		two.setBounds(600, 660, 50, 40);
		
		ImageIcon image3 = new ImageIcon("playerIcon4.gif");
		three = new JLabel(image3);
		add(three);
		three.setBounds(575, 660, 50, 40);
		
		round.setBounds(720, 0, 1920, 250);
		add(round);
		
		JButton debug = new JButton("Debug Window");
		debug.setBounds(1150, 630, 120, 70);
		add(debug);
		debug.addActionListener(this);
		
		ImageIcon image = new ImageIcon("board.jpg");
		JLabel labelForimage = new JLabel(image);
		
		informationTable.setBounds(720, 260, 550, 350);
		add(informationTable);
		
		add(labelForimage);
		labelForimage.setBounds(0, 0, 700, 700);
		
		this.setSize(1300, 750);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setUndecorated(true);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Debug frame = new Debug();
		frame.setVisible(true);
	}
	
	public void setCurrentPlayer(int id) {
		round.setCurrentPlayer(this.players[id]);
	}
}
