package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Main.Admin;
import Main.Player;
import gui.AdditionalWindows.InputReaders.GetOneOption;
import gui.AdditionalWindows.InputReaders.GetTextInput;

public class RollingTheDice extends JPanel implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	private Player				player;
	private JLabel				playerName, result, dice, whichPlayer;
	private JButton				button, end, sell;
	private int					moveTo;
	private boolean				alreadyRolled		= false;
	
	public RollingTheDice() {
		setLayout(null);
		sell = new JButton();
		button = new JButton();
		dice = new JLabel();
		result = new JLabel();
		
		Image boardImage = new ImageIcon("dice.png").getImage();
		dice = new JLabel(new ImageIcon(boardImage));
		dice.setBounds(7, 10, ((int) dice.getPreferredSize().getWidth()), ((int) dice.getPreferredSize().getHeight()));
		add(dice);
		
		whichPlayer = new JLabel("It Player 1's turn");
		whichPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
			.getPreferredSize().getHeight()));
		add(whichPlayer);
		
		result.setText("<html>Dice:<br>SpeedDie:</html>");
		result.setFont(new Font("Tahoma", Font.PLAIN, 16));
		result.setBounds(12, 150, ((int) result.getPreferredSize().getWidth()) * 2, ((int) result.getPreferredSize()
			.getHeight()));
		add(result);
		
		end = new JButton("End Round");
		end.setBounds(140, 80, 116, 61);
		add(end);
		end.addActionListener(this);
		
		button.addActionListener(this);
		button.setText("Roll");
		button.setBounds(7, 80, 116, 61);
		add(button);
		
		sell = new JButton("Sell");
		sell.addActionListener(this);
		sell.setBounds(7, 200, 116, 40);
		add(sell);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// Create the Dice and roll
		if (!(player.getOwnedLands().isEmpty()))
			sell.setEnabled(true);
		
		whichPlayer
			.setText((Admin.getPlayerName(player) + " is playing, h/she has the icon number: " + player.getID()));
		whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
			.getPreferredSize().getHeight()));
		
		button.setEnabled(false);
		if (arg0.getSource() == button) {
			int[] roll = new Dice().rollWithSpeedDie();
			
			int roll1 = roll[0];
			int roll2 = roll[1];
			int rollSpeed = roll[2];
			alreadyRolled = true;
			
			result.setText("<html>Dice: " + roll1 + "," + roll2 + "<br>" + "SpeedDie: " + rollSpeed + "</html>");
			if (!(roll1 == roll2 && roll2 == rollSpeed)) {
				if (Dice.isMonopolyGuy()) {
					// result.setText("Dice: " + roll1 + "," + roll2 + " with SpeedDie:" + rollSpeed);
					// result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
					// .getPreferredSize().getHeight()));
					movePlayer(roll1 + roll2);
					new gui.AdditionalWindows.MessageDisplayer(" You rolled MonopolyGuy !");
					
					if (Admin.allLandsOwned())
						Admin.movePlayerToNextNeutralLand(player);
					
					if (roll1 != roll2)
						end.setEnabled(true);
				} else if (Dice.isBus()) {
					// result.setText("Dice: " + roll1 + "," + roll2 + " with SpeedDie:" + rollSpeed);
					// result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
					// .getPreferredSize().getHeight()));
					new gui.AdditionalWindows.MessageDisplayer(" You rolled Bus !");
					
					int option = new GetOneOption(roll1, roll2, roll1 + roll2,
						"How many squares would you like to move?").getResponse();
					
					if (option == 0) movePlayer(roll1);
					if (option == 1) movePlayer(roll2);
					if (option == 2) movePlayer(roll1 + roll2);
					
					if (roll1 != roll2)
						end.setEnabled(true);
				} else {
					// result.setText("Dice: " + roll1 + "," + roll2 + " with SpeedDie:" + rollSpeed);
					// result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
					// .getPreferredSize().getHeight()));
					movePlayer(roll1 + roll2 + rollSpeed);
					if (roll1 != roll2)
						end.setEnabled(true);
				}
			}
			if (roll1 == roll2) {
				if (roll1 == rollSpeed) {
					// result.setText("Dice: " + roll1 + "," + roll2 + " with SpeedDie:" + rollSpeed);
					// result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
					// .getPreferredSize().getHeight()));
					new gui.AdditionalWindows.MessageDisplayer("You rolled triples, you can go everywhere you can!");
					
					while (!(moveTo < 0) || (19 < moveTo))
						moveTo = new GetTextInput(
							"Enter the square you want to go, should be between 0 (GO) and 19(Pennysylvania)").getInt();
					int current = player.getLocation();
					
					movePlayer((moveTo - current) % 20);
					
					
					end.setEnabled(true);
				} else {
					new gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
					button.setEnabled(true);
				}
			} else {
				end.setEnabled(true);
			}
			
		} else if (arg0.getSource() == end) {
			Main.Main.endRound();
			whichPlayer.setText(Admin.getPlayerName(player) + " has ended his/her turn. Now its "
				+ Admin.getNextPlayerName(player.getID()) + "'s turn.");
			whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
				.getPreferredSize().getHeight()));
			alreadyRolled = false;
			sell.setEnabled(false);
		} else if (arg0.getSource() == sell) {
			gui.AdditionalWindows.List.createAndShowGUI(player.getOwnedLands());
			
			if (alreadyRolled) {
				button.setEnabled(false);
				end.setEnabled(true);
			} else {
				button.setEnabled(true);
				end.setEnabled(false);
			}
			alreadyRolled = false;
		}
		
		Board.informationTable.refreshData();
		Board.informationTable.validate();
	}
	
	private void movePlayer(int amount) {
		int location = player.getLocation();
		location = (location + amount) % 20;
		
		int x = Board.squareHolder.getSquare(location).getX() - (player.getID() * 25);
		int y = Board.squareHolder.getSquare(location).getY();
		
		playerName.setBounds(x, y, 50, 40);
		player.moveBy(amount);
		
		Board.informationTable.refreshData();
	}
	
	public void setCurrentPlayer(Player player) {
		this.player = player;
		button.setEnabled(true);
		end.setEnabled(false);
		sell.setEnabled(!player.getOwnedLands().isEmpty());
		
		switch (player.getID()) {
			case 0:
				this.playerName = Board.zero;
				break;
			case 1:
				this.playerName = Board.one;
				break;
			case 2:
				this.playerName = Board.two;
				break;
			case 3:
				this.playerName = Board.three;
				break;
		}
		
		Board.informationTable.refreshData();
		Board.informationTable.validate();
	}
}
