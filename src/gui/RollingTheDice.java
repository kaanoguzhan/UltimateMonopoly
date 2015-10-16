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

	private static final long serialVersionUID = 1L;
	private Player player;
	private String playerNAME;
	private JLabel playerName, result, dice, whichPlayer;
	private JButton button, end, sell;
	private boolean alreadyRolled = false;

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

		whichPlayer = new JLabel();
		whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
				.getPreferredSize().getHeight()));
		add(whichPlayer);

		result.setText("result is: ");
		result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize()
				.getHeight()));
		add(result);

		end = new JButton("End Round");
		end.setBounds(70, 75, ((int) end.getPreferredSize().getWidth()), ((int) end.getPreferredSize().getHeight()));
		add(end);
		end.addActionListener(this);

		button.addActionListener(this);
		button.setText("Roll");
		button.setBounds(7, 75, ((int) button.getPreferredSize().getWidth()), ((int) button.getPreferredSize()
				.getHeight()));
		add(button);

		sell = new JButton("Sell");
		sell.addActionListener(this);
		sell.setBounds(7, 140, ((int) sell.getPreferredSize().getWidth()), ((int) sell.getPreferredSize().getHeight()));
		add(sell);

	}

	public void actionPerformed(ActionEvent arg0) {
		// Create the Dice and roll
		if (player != null) {
			playerNAME = player.getName();
		} else
			playerNAME = "..";

		if (!(player.getOwnedLands().isEmpty()))
			sell.setEnabled(true);

		whichPlayer.setText((playerNAME + " is playing, h/she has the icon number: " + player.getID()));
		whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
				.getPreferredSize().getHeight()));

		button.setEnabled(false);
		// if (arg0.getSource() == button) {
		// int[] roll = new Dice().roll2();
		// int roll1 = roll[0];
		// int roll2 = roll[1];
		// alreadyRolled = true;
		// result.setText("dice rolled : " + roll1 + "," + roll2);
		// result.setBounds(7, 115, ((int)
		// result.getPreferredSize().getWidth()), ((int)
		// result.getPreferredSize()
		// .getHeight()));
		// movePlayer(roll1 + roll2);
		//
		// if (roll1 == roll2) {
		// new
		// gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
		// button.setEnabled(true);
		// } else {
		// end.setEnabled(true);
		// }
		// }
		if (arg0.getSource() == button) {
			int[] roll = new Dice().rollWithSpeedDie();

			int roll1 = roll[0];
			int roll2 = roll[1];
			int rollSpeed = roll[2];
			alreadyRolled = true;

			if (!(roll1 == roll2 && roll2 == rollSpeed)) {
				if (Dice.isMonopolyGuy()) {
					result.setText("dice rolled : " + roll1 + "," + roll2 + "," + rollSpeed);
					result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
							.getPreferredSize().getHeight()));
					movePlayer(roll1 + roll2);
					new gui.AdditionalWindows.MessageDisplayer("You rolled MonopolyGuy !");
					// MonopolyGuy metodu
					if (roll1 != roll2)
						end.setEnabled(true);
				} else if (Dice.isBus()) {
					result.setText("dice rolled : " + roll1 + "," + roll2 + "," + rollSpeed);
					result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
							.getPreferredSize().getHeight()));
					new gui.AdditionalWindows.MessageDisplayer("You rolled Bus !");
					// Bus metodu ( roll1,roll2, roll1+rool2)'den biri kadar git
					if (roll1 != roll2)
						end.setEnabled(true);
				} else {
					result.setText("dice rolled : " + roll1 + "," + roll2 + "," + rollSpeed);
					result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
							.getPreferredSize().getHeight()));
					movePlayer(roll1 + roll2 + rollSpeed);
					if (roll1 != roll2)
						end.setEnabled(true);
				}
			}
			if (roll1 == roll2) {
				if (roll1 == rollSpeed) {
					result.setText("dice rolled : " + roll1 + "," + roll2 + "," + rollSpeed);
					result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result
							.getPreferredSize().getHeight()));
					new gui.AdditionalWindows.MessageDisplayer("You rolled triples, you can go everywhere you can!");
					// Nereye gitmek istersin? gitme kodu
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
			whichPlayer.setText(playerNAME + " has ended his/her turn");
			whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
					.getPreferredSize().getHeight()));
			alreadyRolled = false;
		} else if (arg0.getSource() == sell) {
			gui.List.createAndShowGUI(player.getOwnedLands());

			if (alreadyRolled) {
				button.setEnabled(false);
				end.setEnabled(true);
			} else {
				button.setEnabled(true);
				end.setEnabled(false);
			}
			alreadyRolled = false;
			sell.setEnabled(false);
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

	// public static void moveTo(Player pl, int id) {
	// int x = Board.squareHolder.getSquare(id).getX() - (pl.getID() * 25);
	// int y = Board.squareHolder.getSquare(id).getY();
	//
	//
	//
	// switch (pl.getID()) {
	// case 0:
	// this.playerName = Board.zero;
	// break;
	// case 1:
	// this.playerName = Board.one;
	// break;
	// case 2:
	// this.playerName = Board.two;
	// break;
	// case 3:
	// this.playerName = Board.three;
	// break;
	// }
	//
	// playerName.setBounds(x, y, 50, 40);
	// pl.moveBy(amount);
	//
	// Board.p.refreshData();
	// }

	public void setCurrentPlayer(Player player) {
		this.player = player;
		button.setEnabled(true);
		end.setEnabled(false);

		if (!(alreadyRolled) || player.getOwnedLands().isEmpty())
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

