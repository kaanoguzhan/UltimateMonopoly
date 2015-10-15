package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Main.Dice;
import Main.Player;

public class RollingTheDice extends JPanel implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	private Player				player;
	private SquareHolder		squareHolder		= new SquareHolder();
	private JLabel				playerName, result, dice;
	private JButton				button;
	
	public RollingTheDice() {
		setLayout(null);
		button = new JButton();
		dice = new JLabel();
		result = new JLabel();
		
		Image boardImage = new ImageIcon("dice.png").getImage();
		dice = new JLabel(new ImageIcon(boardImage));
		dice.setBounds(7, 10, ((int) dice.getPreferredSize().getWidth()), ((int) dice.getPreferredSize().getHeight()));
		add(dice);
		
		result.setText("result is: ");
		result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize()
			.getHeight()));
		add(result);
		
		button.addActionListener(this);
		button.setText("Roll");
		button.setBounds(7, 75, ((int) button.getPreferredSize().getWidth()), ((int) button.getPreferredSize()
			.getHeight()));
		add(button);
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		// Create the Dice and roll
		int[] roll = new Dice().roll2();
		
		result.setText("dice rolled : " + roll[0] + "," + roll[1]);
		result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize()
			.getHeight()));
		
		movePlayer(roll[0] + roll[1]);
	}
	
	private void movePlayer(int amount) {
		int location = player.getLocation();
		location = (location + amount) % 20;
		
		int x = squareHolder.getSquare(location).getX() - (player.getID() * 25);
		int y = squareHolder.getSquare(location).getY();
		
		// (player.getLocation() + roll[0] + roll[1]) % 20
		// zero for now, later it will be player.getID (zero,one,two,three).setBounds
		playerName.setBounds(x, y, 50, 40);
		player.moveBy(amount);
	}
	public void setCurrentPlayer(Player player) {
		this.player = player;
		switch (player.getID()) {
			case 0:
				this.playerName = Board.zero;
				
			case 1:
				this.playerName = Board.one;
				
			case 2:
				this.playerName = Board.two;
				
			case 3:
				this.playerName = Board.three;
		}
	}
	
	public void remove() {
		remove(dice);
		remove(button);
		remove(result);
	}
	
}


// private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
// Dice d = new Dice();
// int a = d.roll();
// int b = d.roll();
// jLabel2.setText("" + a + " - " + b);
//
// Firstgui gui = new Firstgui();
// gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// gui.setSize(1000,1000);
// gui.setVisible(true);
// gui.setTitle("Learnin");
//
// jButton1.setEnabled(false);
// }


