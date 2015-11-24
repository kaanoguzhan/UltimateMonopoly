package gui.Board;

import gui.Dice;
import gui.AdditionalWindows.InputReaders.GetOneOption;
import gui.AdditionalWindows.InputReaders.GetTextInput;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import gui.Debug.BoardTab;

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
import Main.Properties;

public class RollingTheDice extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel playerName, result, dice, whichPlayer;
	private JButton button, end, sell;
	private boolean rolledDoubles = false, getOutOfJail = false;
	private int doublesRolled = 0;
	private Player player;

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
		sell.setEnabled(!player.getOwnedLands().isEmpty());

		whichPlayer.setText((player.getName() + " is playing"));
		whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
				.getPreferredSize().getHeight()));

		button.setEnabled(false);
		if (arg0.getSource() == button) {

			if (player.isJailed()) {
				if (player.isReleaseTime()) {
					player.getOutOfJail();
					System.out.println("Player:" + player.getName() + " is released from jail, next round "
							+ player.getName() + " will play.");
				} else {
					int[] rollJail = new Dice().roll2();

					int rollJail1 = rollJail[0];
					int rollJail2 = rollJail[1];

					if (rollJail1 == rollJail2)
						player.getOutOfJail();
					else {
						if (player.hasGetOutOfJail()) {
							getOutOfJail = new GetYesNoInput("You can use GetOutOfJail Card", "Do you want to use it ?")
									.getValue();
						}
						if (getOutOfJail) {
							player.removeGetOutOfJailCard();
						} else if (getOutOfJail = new GetYesNoInput("By paying $50 fee you can get out of jail",
								"Do you want to pay ?").getValue()) {
							player.payToPool(50);
						}
						if (getOutOfJail) {
							player.getOutOfJail();
						} else {
							player.reduceJailTime();
							System.out.println("Player:" + player.getName() + " will be in jail for "
									+ player.getJailTime() + " rounds.");
						}
					}
				}
			} else {

				int[] roll = new Dice().rollWithSpeedDie();

				int roll1 = roll[0];
				int roll2 = roll[1];
				int rollSpeed = roll[2];

				if (BoardTab.chckbxSetDice != null && BoardTab.chckbxSetDice.isSelected()) {
					roll1 = Integer.parseInt(BoardTab.txtDie1.getText());
					roll2 = Integer.parseInt(BoardTab.txtDie2.getText());
					rollSpeed = Integer.parseInt(BoardTab.txtSpeedDie.getText());
					switch (rollSpeed) {
					case 1:
					case 2:
					case 3:
						Dice.bus = false;
						Dice.monopolyGuy = false;
						break;
					case 4:
					case 5:
						Dice.bus = false;
						Dice.monopolyGuy = true;
						break;
					case 6:
						Dice.bus = true;
						Dice.monopolyGuy = false;
						break;
					}
				}

				result.setText("<html>Dice: " + roll1 + "," + roll2 + "<br>" + "SpeedDie: " + rollSpeed + "</html>");

				if (!(roll1 == roll2 && roll2 == rollSpeed)) {
					if (Dice.isMonopolyGuy()) {
						movePlayer(roll1 + roll2);
						new gui.AdditionalWindows.MessageDisplayer(" You rolled MonopolyGuy !");

						if (Admin.allLandsOwned())
							Admin.movePlayerToNextLand(player.getID());
						else
							Admin.movePlayerToNextNeutralLand(player.getID());

						if (roll1 != roll2) {
							end.setEnabled(true);
							doublesRolled = 0;
						}
					} else if (Dice.isBus()) {
						new gui.AdditionalWindows.MessageDisplayer(" You rolled Bus !");

						int option = new GetOneOption(roll1, roll2, roll1 + roll2,
								"How many squares would you like to move?").getResponse();

						if (option == 0)
							movePlayer(roll1);
						if (option == 1)
							movePlayer(roll2);
						if (option == 2)
							movePlayer(roll1 + roll2);

						if (roll1 != roll2) {
							end.setEnabled(true);
							doublesRolled = 0;
						}
					} else {
						movePlayer(roll1 + roll2 + rollSpeed);
						if (roll1 != roll2) {
							end.setEnabled(true);
							doublesRolled = 0;
						}
					}
				}
				if (roll1 == roll2) {
					if (roll1 == rollSpeed) {
						new gui.AdditionalWindows.MessageDisplayer("You rolled triples, you can go everywhere you can!");

						int moveTo = Integer.MAX_VALUE;
						while (!((0 <= moveTo) && (moveTo < Properties.TOTAL_SQUARES)))
							moveTo = new GetTextInput(
									"Enter the square you want to go, should be between 0 (GO) and 119(Lobard Street)")
									.getInt();

						int current = player.getLocation();
						Admin.movePlayerBy(player.getID(), ((moveTo - current) % 20));

						end.setEnabled(true);
						doublesRolled = 0;
					} else {
						rolledDoubles = true;
						doublesRolled++;
						if (doublesRolled == 3) {
							rolledDoubles = false;
							doublesRolled = 0;
							new gui.AdditionalWindows.MessageDisplayer(
									"This is your third doubles, now you will go to jail !");
							player.goToJail();
							button.setEnabled(false);
							end.setEnabled(true);
						} else {
							new gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
							button.setEnabled(true);
						}
					}
				} else {
					rolledDoubles = false;
					doublesRolled = 0;
					end.setEnabled(true);
				}
			}
		} else if (arg0.getSource() == end) {
			Main.Main.endRound();
			whichPlayer.setText(player.getName() + " has ended his/her turn. Now its "
					+ Admin.getNextPlayerName(player.getID()) + "'s turn.");
			whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
					.getPreferredSize().getHeight()));
			sell.setEnabled(false);
		} else if (arg0.getSource() == sell) {
			gui.AdditionalWindows.List.createAndShowGUI(player.getOwnedLands());

			if (!rolledDoubles) {
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
		player.moveBy(amount);

		int location = player.getLocation();
		location = (location + amount) % 120;

		int x, y;
		switch (player.getID()) {
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
			x = Board.squareHolder.getSquare(location).getX() - (player.getID() * 30);
			y = Board.squareHolder.getSquare(location).getY();
			break;
		}

		playerName.setBounds(x, y, 50, 40);
		Board.informationTable.refreshData();
	}

	public void setCurrentPlayer(Player player) {
		this.player = player;
		if (-1 == player.getLocation())
			end.doClick();

		button.setEnabled(true);
		end.setEnabled(false);
		sell.setEnabled(false);

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
