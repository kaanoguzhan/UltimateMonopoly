package gui;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Main.Dice;
import Main.Player;

public class RollOnce extends JFrame implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	private boolean				rolledSame;
	private JLabel				picked, picked2, result, dice;
	private JButton				button;
	private int					rolled;
	private Player player;
	public RollOnce(Player pl) {
		setLayout(null);
		this.player = pl;
		
		rolled = new Random().nextInt(6) + 1;
		
		picked = new JLabel("You picked : " + rolled);
		picked2 = new JLabel("If you roll this number you will get 100$");
		button = new JButton();
		dice = new JLabel();
		result = new JLabel();
		
		Image boardImage = new ImageIcon("dice.png").getImage();
		dice = new JLabel(new ImageIcon(boardImage));
		dice.setBounds(7, 10, ((int) dice.getPreferredSize().getWidth()), ((int) dice.getPreferredSize().getHeight()));
		add(dice);
		
		picked.setBounds(70, 74, ((int) picked.getPreferredSize().getWidth()), ((int) picked.getPreferredSize()
			.getHeight()));
		add(picked);
		
		picked2.setBounds(70, 87, ((int) picked2.getPreferredSize().getWidth()), ((int) picked2.getPreferredSize()
			.getHeight()));
		add(picked2);
		
		
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
        GameSquares.RollOnce.isRolledSame(player);
		boolean a = GameSquares.RollOnce.rolledSame;
		int b = GameSquares.RollOnce.rolled;
          
		if (a == true) {		
			result.setText("dice rolled : " + b + "   YOU WIN !!!");
			result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize()
				.getHeight()));
		} else {
			
			result.setText("dice rolled : " + b + "   Better luck next time");
			result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize()
				.getHeight()));
		}
	}
	
	public boolean isRolledSame() {
		return rolledSame;
	}
}
