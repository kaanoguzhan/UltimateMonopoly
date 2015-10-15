package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollingTheDice extends JPanel implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	private SquareHolder		squareHolder		= new SquareHolder();
	private JLabel				player;
	private JLabel				dice;
	private JButton				button;
	private JLabel				result;
	
	int							i					= 0;
	
	
	public RollingTheDice(JLabel player) {
		setLayout(null);
		this.player = player;
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
		// DICE AT BURDA ABIZI, dice attiktan sonra ne yapicalsa asagi
		result.setText("dice rolled :");
		result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize()
			.getHeight()));
		
		movePlayer(i++%20);
	}
	
	private void movePlayer(int location) { // player parametresi de alincak
		int x = squareHolder.getSquare(location).getX();
		int y = squareHolder.getSquare(location).getY();
		
		// zero for now, later it will be player.getID (zero,one,two,three).setBounds
		player.setBounds(x, y, 50, 40);
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


