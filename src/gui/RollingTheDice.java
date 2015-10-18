package gui;

import gui.AdditionalWindows.InputReaders.GetOneOption;
import gui.AdditionalWindows.InputReaders.GetTextInput;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Main.Admin;
import Main.Properties;

public class RollingTheDice extends JPanel implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	private int					playerID;
	private JLabel				playerName, result, dice, whichPlayer;
	private JButton				button, end, sell;
	private boolean				rolledDouble = false;
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
		sell.setEnabled(Admin.playerHasLand(playerID));
		
		whichPlayer
			.setText((Admin.getPlayerName(playerID) + " is playing"));
		whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
			.getPreferredSize().getHeight()));
		
		button.setEnabled(false);
		if (arg0.getSource() == button) {
			int[] roll = new Dice().rollWithSpeedDie();
			
			int roll1 = roll[0];
			int roll2 = roll[1];
			int rollSpeed = roll[2];
			
			result.setText("<html>Dice: " + roll1 + "," + roll2 + "<br>" + "SpeedDie: " + rollSpeed + "</html>");
			if (!(roll1 == roll2 && roll2 == rollSpeed)) {
				if (Dice.isMonopolyGuy()) {
					// result.setText("Dice: " + roll1 + "," + roll2 + " with SpeedDie:" + rollSpeed);
					// result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
					// .getPreferredSize().getHeight()));
					movePlayer(roll1 + roll2);
					new gui.AdditionalWindows.MessageDisplayer(" You rolled MonopolyGuy !");

					if (Admin.allLandsOwned()){
						Admin.movePlayerToNextLand(playerID);	
					}
					else{ 
						Admin.movePlayerToNextNeutralLand(playerID);
					}
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
			} if (roll1 == roll2) {
				rolledDouble = true;
				if (roll1 == rollSpeed) {
					rolledDouble =false;
					// result.setText("Dice: " + roll1 + "," + roll2 + " with SpeedDie:" + rollSpeed);
					// result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
					// .getPreferredSize().getHeight()));
					new gui.AdditionalWindows.MessageDisplayer("You rolled triples, you can go everywhere you can!");
					
					int moveTo = Integer.MAX_VALUE;
					while (!((0 <= moveTo) && (moveTo < Properties.TOTAL_SQUARES)))
						moveTo = new GetTextInput(
							"Enter the square you want to go, should be between 0 (GO) and 19(Pennysylvania)").getInt();
					
					
					int current = Main.Main.players[playerID].getLocation();
					Admin.movePlayerBy(playerID, ((moveTo-current)%20));					
					
					end.setEnabled(true);
				} else {
					new gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
					button.setEnabled(true);
				}
			} else {
				rolledDouble =false;
				end.setEnabled(true);
			}
			
		} else if (arg0.getSource() == end) {
			Main.Main.endRound();
			whichPlayer.setText(Admin.getPlayerName(playerID) + " has ended his/her turn. Now its "
				+ Admin.getNextPlayerName(playerID) + "'s turn.");
			whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
				.getPreferredSize().getHeight()));
			sell.setEnabled(false);
		} else if (arg0.getSource() == sell) {
			gui.AdditionalWindows.List.createAndShowGUI(Admin.getPlayerLands(playerID));

			if(!rolledDouble){
				button.setEnabled(false);
				end.setEnabled(true);
			} else {
				button.setEnabled(true);
			}
		
		}
		
		Board.informationTable.refreshData();
		Board.informationTable.validate();
	}
	private void movePlayer(int amount) {
		int location = Admin.getPlayerLocation(playerID);
		location = (location + amount) % 20;
		
		int x, y;
		switch (playerID){
			case 0:
				x = Board.squareHolder.getSquare(location).getX() - 25;
				y = Board.squareHolder.getSquare(location).getY() - 50;
				break;
			case 1:
				x = Board.squareHolder.getSquare(location).getX() - 65;
				y = Board.squareHolder.getSquare(location).getY() - 50;
				break;
			case 2:
				x = Board.squareHolder.getSquare(location).getX() - 65;
				y = Board.squareHolder.getSquare(location).getY() - 10;
				break;
			case 3:
				x = Board.squareHolder.getSquare(location).getX() - 25;
				y = Board.squareHolder.getSquare(location).getY() - 10;
				break;
			default:
				x = Board.squareHolder.getSquare(location).getX() - (playerID * 30);
				y = Board.squareHolder.getSquare(location).getY();
				break;
		}
		
		playerName.setBounds(x, y, 50, 40);
		Admin.movePlayerBy(playerID, amount);
		
		Board.informationTable.refreshData();
	}
	
	public void setCurrentPlayer(int playerID) {
		this.playerID = playerID;
		button.setEnabled(true);
		end.setEnabled(false);
		sell.setEnabled(false);
		
		switch (Admin.getPlayerID(playerID)) {
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
