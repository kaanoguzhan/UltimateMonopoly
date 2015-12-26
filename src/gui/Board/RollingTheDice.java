package gui.Board;

import gui.Dice;
import gui.AdditionalWindows.InputReaders.GetOneOption;
import gui.AdditionalWindows.InputReaders.GetTextInput;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import gui.Debug.DicePanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Main.Admin;
import Main.Main;
import Main.Player;
import Main.Properties;
import javax.swing.SwingConstants;

public class RollingTheDice extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel            playerName, result, dice, lblLoadProtection;
    public JLabel             whichPlayer;
    public JButton            btnRoll, btnEnd, btnSell;
    private boolean           getOutOfJail     = false;
    private Player            player;
    private int               loadProtectionCounter;
    
    public RollingTheDice() {
        setLayout(null);
        btnSell = new JButton();
        btnRoll = new JButton();
        dice = new JLabel();
        result = new JLabel();
        
        Image boardImage = new ImageIcon("dice.png").getImage();
        dice = new JLabel(new ImageIcon(boardImage));
        dice.setBounds(7, 10, ((int) dice.getPreferredSize().getWidth()), ((int) dice.getPreferredSize().getHeight()));
        add(dice);
        
        whichPlayer = new JLabel("                                                                                  ");
        whichPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
        whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
            .getPreferredSize().getHeight()));
        add(whichPlayer);
        
        result.setText("<html>Dice:<br>SpeedDie:</html>");
        result.setFont(new Font("Tahoma", Font.PLAIN, 16));
        result.setBounds(12, 150, ((int) result.getPreferredSize().getWidth()) * 2, ((int) result.getPreferredSize()
            .getHeight()));
        add(result);
        
        btnEnd = new JButton("End Round");
        btnEnd.setBounds(140, 80, 116, 61);
        add(btnEnd);
        btnEnd.addActionListener(this);
        
        btnRoll.addActionListener(this);
        btnRoll.setText("Roll");
        btnRoll.setBounds(7, 80, 116, 61);
        add(btnRoll);
        
        btnSell = new JButton("Sell");
        btnSell.addActionListener(this);
        btnSell.setBounds(7, 200, 116, 40);
        add(btnSell);
        
        lblLoadProtection = new JLabel("Load Protection");
        lblLoadProtection.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoadProtection.setBounds(140, 201, 116, 39);
        lblLoadProtection.setVisible(false);
        add(lblLoadProtection);
        
    }
    
    public void actionPerformed(ActionEvent arg0) {
        btnSell.setEnabled(!player.getOwnedSquares().isEmpty());
        whichPlayer.setText((player.getName() + " is playing"));
        whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
            .getPreferredSize().getHeight()));
        
        btnRoll.setEnabled(false);
        if (arg0.getSource() == btnRoll) {
            if (player.isJailed()) {
                if (player.isReleaseTime()) {
                    player.getOutOfJail();
                    System.out.println("Player:" + player.getName() + " is released from jail, next round "
                        + player.getName() + " will play.");
                    btnEnd.setEnabled(true);
                } else {
                    int[] rollJail = new Dice().roll2();
                    
                    int rollJail1 = rollJail[0];
                    int rollJail2 = rollJail[1];
                    
                    if (rollJail1 == rollJail2) {
                        player.getOutOfJail();
                        btnEnd.setEnabled(true);
                    } else {
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
                            btnEnd.setEnabled(true);
                        } else {
                            player.reduceJailTime();
                            System.out.println("Player:" + player.getName() + " will be in jail for "
                                + player.getJailTime() + " rounds.");
                            btnEnd.setEnabled(true);
                        }
                    }
                }
            } else {
                
                int[] roll = new Dice().rollWithSpeedDie();
                
                int roll1 = roll[0];
                int roll2 = roll[1];
                int rollSpeed = roll[2];
                
                if (DicePanel.chcbxExist && DicePanel.chcbxTicked) {
                    roll1 = DicePanel.Die1;
                    roll2 = DicePanel.Die2;
                    rollSpeed = DicePanel.SpeedDie;
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
                
                if (roll1 != roll2) {
                    if (Dice.isMonopolyGuy()) {
                        
                        boolean even = false;
                        if ((roll1 + roll2) % 2 == 0)
                            even = true;
                        
                        movePlayer(roll1 + roll2);
                        new gui.AdditionalWindows.MessageDisplayer(" You rolled MonopolyGuy !");
                        
                        if (Admin.allLandsOwned())
                            Admin.movePlayerToNextLand(player.getID(), even);
                        else
                            Admin.movePlayerToNextNeutralLand(player.getID(), even);
                        
                        if (roll1 != roll2) {
                            player.resetDoublesRolled();
                            btnEnd.setEnabled(true);
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
                            btnEnd.setEnabled(true);
                            player.resetDoublesRolled();
                        }
                    } else {
                        movePlayer(roll1 + roll2 + rollSpeed);
                        player.resetDoublesRolled();
                        btnEnd.setEnabled(true);
                    }
                }
                if (roll1 == roll2) {
                    if (roll1 == rollSpeed) {
                        new gui.AdditionalWindows.MessageDisplayer("You rolled triples, you can go everywhere you can!");
                        
                        int moveTo = Integer.MAX_VALUE;
                        while (!((0 <= moveTo) && (moveTo < Main.gameSquares.length)))
                            moveTo = new GetTextInput(
                                "Enter the square you want to go, should be between 0 (GO) and 119(Lobard Street)")
                                .getInt();
                        
                        int current = player.getLocation();
                        Admin.movePlayerBy(player.getID(), ((moveTo - current) % 20));
                        
                        player.resetDoublesRolled();
                        btnEnd.setEnabled(true);
                    } else {
                        player.doublesRolled();
                        if (player.isThirdDoubles()) {
                            player.resetDoublesRolled();
                            new gui.AdditionalWindows.MessageDisplayer(
                                "This is your third doubles, now you will go to jail !");
                            player.goToJail();
                            btnRoll.setEnabled(false);
                            btnEnd.setEnabled(true);
                        } else {
                            if (Dice.isMonopolyGuy()) {
                                movePlayer(roll1 + roll2);
                                new gui.AdditionalWindows.MessageDisplayer(" You rolled MonopolyGuy !");
                                
                                boolean even = false;
                                if ((roll1 + roll2) % 2 == 0)
                                    even = true;
                                
                                if (Admin.allLandsOwned())
                                    Admin.movePlayerToNextLand(player.getID(), even);
                                else
                                    Admin.movePlayerToNextNeutralLand(player.getID(), even);
                                new gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
                                btnRoll.setEnabled(true);
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
                                new gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
                                btnRoll.setEnabled(true);
                            } else {
                                movePlayer(roll1 + roll2 + rollSpeed);
                                new gui.AdditionalWindows.MessageDisplayer("You rolled doubles, roll again !");
                                btnRoll.setEnabled(true);
                            }
                        }
                    }
                } else {
                    player.resetDoublesRolled();
                    btnEnd.setEnabled(true);
                }
            }
        } else if (arg0.getSource() == btnEnd) {
            Main.endRound();
            whichPlayer.setText(player.getName() + " has ended his/her turn. Now its "
                + Admin.getNextPlayerName(player.getID()) + "'s turn.");
            whichPlayer.setBounds(140, 35, ((int) whichPlayer.getPreferredSize().getWidth()), ((int) whichPlayer
                .getPreferredSize().getHeight()));
            btnSell.setEnabled(false);
        } else if (arg0.getSource() == btnSell) {
            gui.AdditionalWindows.List.createAndShowGUI(player.getOwnedSquares());
            
            if (player.getDoublesRolled() == 0) {
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(true);
            } else {
                btnRoll.setEnabled(true);
            }
            
        }
        
        PlayerInfo.refreshData();
        Board.informationTable.validate();
    }
    
    private void movePlayer(int amount) {
        player.moveBy(amount);
        PlayerInfo.refreshData();
    }
    
    public void setCurrentPlayer(Player player) {
        this.player = player;
        
        boolean[] btns = { true, false, false };
        setButtonEnableds(btns);
        
        setplayerName(player);
    }
    public void loadCurrentPlayer(Player player) {
        this.player = player;
        
        
        setplayerName(player);
    }
    private void setplayerName(Player player) {
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
        PlayerInfo.setActivePlayerCard(player.getID());
        PlayerInfo.refreshData();
        Board.informationTable.validate();
    }
    
    public void setPlayerTurnLabel(String string) {
        whichPlayer.setText(string);
    }
    
    public boolean[] getButtonEnableds() {
        boolean[] output = { btnRoll.isEnabled(), btnEnd.isEnabled(), btnSell.isEnabled() };
        return output;
    }
    
    public void setButtonEnableds(boolean[] arry) {
        btnRoll.setEnabled(arry[0]);
        btnEnd.setEnabled(arry[1]);;
        btnSell.setEnabled(arry[2]);
    }
    
    public void initiateLoadProtection() {
        Main.loadProtection = true;
        loadProtectionCounter = Properties.LOAD_PRORECTION_COUNTER;
        lblLoadProtection.setText("<html>Load Protection<br>Turn/s left:" + loadProtectionCounter + "</html>");
        lblLoadProtection.setVisible(true);
    }
    
    public void reduceLoadProtection() {
        if (loadProtectionCounter < 2) {
            lblLoadProtection.setVisible(false);
            Main.loadProtection = false;
        } else
            lblLoadProtection.setText("<html>Load Protection<br>Turn/s left:" + --loadProtectionCounter + "</html>");
    }
}
